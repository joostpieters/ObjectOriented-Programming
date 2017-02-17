package worms.model.programs.parser;

import worms.gui.game.IActionHandler;
import worms.model.Program;

public class Print extends Action{

	public boolean isDone = false;
	public Expression<?> message;

	public Print(IActionHandler newHandler, Expression<?> newMessage ) 
	{
		super(newHandler);

		setMessage(newMessage);
		newMessage.setHolder(this);
		newMessage.setProgram(program);
	}
	public void setMessage(Expression<?> newMessage)
	{
		message = newMessage;
	}
	public Expression<?> getMessage()
	{
		return message;
	}
	@Override
	public void execute() 
	{
		if(isDone || program.hasExceedNumberInstructions())
		{
			program.interrupt();
			return;
		}
		program.incrementInstructionNumber();
		getActionHandler().print(getMessage().evaluate().getValue().toString());	
		isDone = true;
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
		message.setProgram(program);
	}

}
