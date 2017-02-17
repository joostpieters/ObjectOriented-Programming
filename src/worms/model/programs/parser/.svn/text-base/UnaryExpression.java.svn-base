package worms.model.programs.parser;

import worms.model.Program;

public abstract class UnaryExpression<T> extends ComposedExpression<T>{

	public Expression<T> operand;
	
	public UnaryExpression(Expression<T> newOperand)
	{
		setOperandAt(1, newOperand);
		newOperand.setParent(this);
		newOperand.setProgram(program);
	}
	@Override
	public int getNbOperands()
	{
		return operand.getNbOperands();
	}
	@Override
	public void setOperandAt(int index, Expression<T> operand)
	{
		this.operand = operand;
	}
	@Override
	public void setProgram(Program program)
	{
		this.program = program;
		operand.setProgram(program);
	}
}
