package worms.model.programs.parser;

import worms.gui.game.IActionHandler;

public abstract class Action extends Statement{
	
	//action for only self

	public IActionHandler handler;
	public Action(IActionHandler newHandler)
	{
		setActionHandler(newHandler);
	}
	public void setActionHandler(IActionHandler newHandler)
	{
		handler = newHandler;
	}
	public IActionHandler getActionHandler()
	{
		return handler;
	}
	@Override
	public void reset()
	{
		isDone = false;
	}

}
