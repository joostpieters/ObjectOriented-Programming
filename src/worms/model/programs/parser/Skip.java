package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;

public class Skip extends Action{

	public Skip(IActionHandler newHandler) 
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
		return;
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
	}


}
