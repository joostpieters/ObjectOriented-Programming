package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;
import worms.model.Worm;

public class Move extends Action{

	public Move(IActionHandler newHandler) 
	{
		super(newHandler);
	}

	@Override
	public void execute() 
	{
		if(program.hasExceedNumberInstructions()) program.interrupt();
		if(isDone || program.isInterrupt()) return;
		program.incrementInstructionNumber();
		
		program.stackOfStatements.push(this);
		if(!(program.getWorm().canMove())) 
		{
			program.interrupt();
			return;
		}
		getActionHandler().move(program.getWorm());
		isDone = true;
		program.stackOfStatements.pop();
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
	}

}
