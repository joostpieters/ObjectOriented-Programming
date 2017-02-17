package worms.model.programs.parser;

import java.util.ArrayList;
import java.util.List;

import worms.model.Program;

public class Sequence extends Statement{
	
	public List<Statement> listOfStatements = new ArrayList<Statement>();

	public Sequence(List<Statement> newListOfStatements)
	{
		for(Statement newStatement : newListOfStatements)
		{
			addStatement(newStatement);
			newStatement.setParent(this);
		}
	}

	public void addStatement(Statement newStatement)
	{
		listOfStatements.add(newStatement);
	}
	public List<Statement> getListOfStatements()
	{
		return listOfStatements;
	}

	@Override
	public void execute() {

		// TODO Auto-generated method stub
		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone ||  program.isInterrupt()) return;
		
		program.stackOfStatements.push(this);
		for(Statement statement : listOfStatements)
		{
			statement.execute();
			if(program.isInterrupt()) return;
		}
		isDone = true;
		program.stackOfStatements.pop();
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		for(Statement statement : listOfStatements)
			statement.setProgram(program);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		isDone = false;
		for(Statement statement : listOfStatements)
			statement.reset();
	}

}
