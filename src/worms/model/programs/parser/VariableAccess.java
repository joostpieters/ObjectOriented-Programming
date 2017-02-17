package worms.model.programs.parser;

import worms.model.Program;

public class VariableAccess<T> extends Expression<T>{

	public String variable;
	
	public VariableAccess(String variable)
	{
		this.variable = variable;
	}
	
	@Override
	public Literal<?> evaluate() {
		// TODO Auto-generated method stub
		return (Literal<?>) program.getGlobals().get(variable).getExpression();
	}
	
	@Override
	public int getNbOperands() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean hasAsSubExpression(Expression<T> expression) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
	}
}
