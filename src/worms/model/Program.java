package worms.model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import worms.gui.game.IActionHandler;
import worms.model.programs.ParseOutcome;
import worms.model.programs.ProgramParser;
import worms.model.programs.parser.*;

public class Program {

	public String text;
	public IActionHandler handler;
	public ProgramIndustry programIndustry;
	public ProgramParser<Expression<?>, Statement, Type<?>> parser;
	
	
	public Stack<Statement> stackOfStatements = new Stack<>();
	public Map<String, Type<?>> globals;
	public Statement mainStatement;

	public Worm worm;
	public int instructionNumber;
	
	public static final int INSTRUCTION_NUMBER_MAX = 1000;
	
	public boolean enter;

	public Program(String text, IActionHandler handler)
	{
		setText(text);
		setActionHandler(handler);
	}
	public ParseOutcome<?> parse()
	{
		programIndustry = new ProgramIndustry(handler);
		parser = new ProgramParser<>(programIndustry);
		parser.parse(getText());
		System.out.println(getText());
		
		if(!parser.getErrors().isEmpty()) return ParseOutcome.failure(parser.getErrors());
		setGlobals(parser.getGlobals());
		
		setMainStatement(parser.getStatement());
		return ParseOutcome.success(this) /*fill here program parsed which will be add to worm */;
	}


	public boolean hasExceedNumberInstructions()
	{
		return instructionNumber >= INSTRUCTION_NUMBER_MAX;
	}
	public void incrementInstructionNumber()
	{
		instructionNumber++;
	}
	public int getInstructionNumber()
	{
		return instructionNumber;
	}
	public void setText(String text)
	{
		this.text = text;
	}
	public String getText()
	{
		return text;
	}
	public void setActionHandler(IActionHandler handler)
	{
		this.handler = handler;
	}
	public IActionHandler getActionHandler()
	{
		return handler;
	}


	public void setGlobals(Map<String, Type<?>> globals)
	{
		this.globals = new HashMap<String, Type<?>>();
		for(Map.Entry<String, Type<?>> variable : globals.entrySet())
		{
			//Defining type
			
			try
			{
				double testType = ((Literal<Double>)(variable.getValue().getExpression())).getValue();
				this.globals.put(variable.getKey(), new Type<Double>(new Literal<Double>(.0)));
			}
			catch (NullPointerException | ClassCastException e1)
			{
				try
				{
					boolean testType = ((Literal<Boolean>)(variable.getValue().getExpression())).getValue();
					this.globals.put(variable.getKey(), new Type<Boolean>(new Literal<Boolean>(false)));
				}
				catch(NullPointerException | ClassCastException e2)
				{
//					((Literal<Worm>)(variable.getValue().getExpression())).setValue(null);
					this.globals.put(variable.getKey(), new Type<Worm>(new Literal<Worm>(null)));
				}
			}
			
		}
	}
	public void setMainStatement(Statement newMainStatement)
	{
		mainStatement = newMainStatement;
		mainStatement.setProgram(this);
	}
	public Map<String, Type<?>> getGlobals()
	{
		return new HashMap<>(globals);
	}
	public Statement getMainStatement()
	{
		return mainStatement;
	}
	public void setWorm(Worm newWorm)
	{
		worm = newWorm;
	}
	public Worm getWorm()
	{
		return worm;
	}


	public void execute()
	{
		restart();
		if(stackOfStatements.isEmpty() || hasExceedNumberInstructions())
		{
			reset();
			mainStatement.execute();
		}
		else 
		{
			while(!stackOfStatements.isEmpty())
				stackOfStatements.pop().execute();
		}
	}
	public void reset()
	{
		mainStatement.reset();
		resetGlobals();
		instructionNumber = 0;
	}
	public void resetGlobals()
	{
		setGlobals(parser.getGlobals());
	}
	public void interrupt()
	{
		enter = false;
	}
	public void restart()
	{
		enter = true;
	}
	public boolean isInterrupt()
	{
		return !enter;
	}

}
