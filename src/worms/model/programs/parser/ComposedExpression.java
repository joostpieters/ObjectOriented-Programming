package worms.model.programs.parser;

public abstract class ComposedExpression<T> extends Expression<T>{


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
	
	public abstract void setOperandAt(int index, Expression<T> operand);

}
