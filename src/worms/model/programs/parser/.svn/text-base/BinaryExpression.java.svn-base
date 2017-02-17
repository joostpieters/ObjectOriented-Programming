package worms.model.programs.parser;

import worms.model.Program;

public abstract class BinaryExpression<T> extends ComposedExpression<T>{

	public Expression<T> operandLeft;
	public Expression<T> operandRight;
	
	public BinaryExpression(Expression<T> operandLeft, Expression<T> operandRight)
	{
		setOperandAt(1, operandLeft);
		operandLeft.setParent(this);
		setOperandAt(2, operandRight);
		operandRight.setParent(this);
	}
	@Override
	public int getNbOperands()
	{
		return operandLeft.getNbOperands() + operandRight.getNbOperands();
	}
	@Override
	public void setOperandAt(int index, Expression<T> operand)
	{
		if(index == 1) operandLeft = operand;
		else operandRight = operand;
	}
	
	@Override
	public void setProgram(Program program)
	{
		this.program = program;
		operandLeft.setProgram(program);
		operandRight.setProgram(program);
	}
	
}
