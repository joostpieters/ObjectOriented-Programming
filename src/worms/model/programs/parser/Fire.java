package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;
import worms.model.Worm;

public class Fire extends Action{

	public Expression<Double> propulsion;

	public Fire(IActionHandler newHandler, Expression<Double> newPropulsion) 
	{
		super(newHandler);
		
		setPropulsion(newPropulsion);
		newPropulsion.setHolder(this);
		newPropulsion.setProgram(program);
	}

	public Expression<Double> getPropulsion()
	{
		return propulsion;
	}
	public void setPropulsion(Expression<Double> newPropulsion)
	{
		propulsion = newPropulsion;
	}

	@Override
	public void execute() 
	{
		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone || program.isInterrupt()) return;
		
		program.stackOfStatements.push(this);
		if(!(program.getWorm().canShoot(  ((Double) propulsion.evaluate().getValue()).intValue()) ) 
				|| program.hasExceedNumberInstructions())
		{
			program.interrupt();
			return;
		}
		program.incrementInstructionNumber();
		
		getActionHandler().fire(program.getWorm(), ((Double) propulsion.evaluate().getValue()).intValue() );
		isDone = true;
		program.stackOfStatements.pop();
	}
	@Override
	public void reset()
	{
		isDone = false;
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		propulsion.setProgram(program);
	}
}
