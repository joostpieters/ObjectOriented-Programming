package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;
import worms.model.Worm;

public class ToggleWeapon extends Action{

	public ToggleWeapon(IActionHandler newHandler) 
	{
		super(newHandler);
	}

	@Override
	public void execute() 
	{
		if(program.hasExceedNumberInstructions())
		{
			program.interrupt();
			return;
		}

		program.incrementInstructionNumber();

		program.stackOfStatements.push(this);
		getActionHandler().toggleWeapon(program.getWorm());
		program.stackOfStatements.pop();
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
	}

}
