package worms.model.programs.parser;

import java.util.ArrayList;
import java.util.List;

import worms.model.Program;

public abstract class Statement {
	
	public Program program;
	public Statement parent;
	public void setParent(Statement newParent)
	{
		this.parent = newParent;
	}
	public boolean isDone = false;
	
	public abstract void setProgram(Program program);
	
	public Statement getMainStatement()
	{
		return program.getMainStatement();
	}

	public abstract void execute();
	
	public abstract void reset();
}

