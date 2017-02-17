package worms.model.programs.parser;

/**
 * A class of basic integer expressions.
 *   A basic expression does not involve any operators. Its
 *   value can be obtained without any computations.
 * 
 * @version  2.0
 * @author   Eric Steegmans
 */
public abstract class BasicExpression<T> extends Expression<T> {

	/**
	 * Check whether this basic expression has the given expression as
	 * one of its subexpressions.
	 *
	 * @return  True if and only if the given expression is the same
	 *          expression as this basic expression.
	 *        | result == (expression == this)
	 */
	@Override
	public final boolean hasAsSubExpression(Expression<T> expression) {
		return expression == this;
	}

	@Override 
	public int getNbOperands()
	{
		return 1;
	}

	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		//Not implemented yet
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValue().toString();
	}
	
	public T value;
	
	public T getValue()
	{
		return value;
	}
	

}