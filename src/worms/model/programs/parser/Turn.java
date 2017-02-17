package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;
import worms.model.Worm;

public class Turn extends Action{

	public Expression<Double> angle;

	public Turn(IActionHandler newHandler, Expression<Double> newAngle) 
	{
		super(newHandler);
		
		setAngle(newAngle);
		newAngle.setHolder(this);
		newAngle.setProgram(program);
	}

	public Expression<Double> getAngle()
	{
		return angle;
	}
	public void setAngle(Expression<Double> newAngle)
	{
		angle = newAngle;
	}

	@Override
	public void execute() 
	{

		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone || program.isInterrupt()) return;
		program.incrementInstructionNumber();
	
		program.stackOfStatements.push(this);
		if(!(program.getWorm().canTurn( (Double)angle.evaluate().getValue() )))
		{
			program.interrupt();
			return;
		}
		getActionHandler().turn(program.getWorm(), (Double)angle.evaluate().getValue());
		isDone = true;
		program.stackOfStatements.pop();
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		angle.setProgram(program);
	}

}
