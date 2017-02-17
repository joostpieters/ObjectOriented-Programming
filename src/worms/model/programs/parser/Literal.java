package worms.model.programs.parser;

import worms.model.Program;
import be.kuleuven.cs.som.annotate.*;

/**
 * A class of integer literals.
 * 
 * @version  2.0
 * @author   Eric Steegmans
 * @param <T>
 */
public class Literal<T> extends BasicExpression<T> {

	
	public Literal(T newValue)
	{
		setValue(newValue);
	}
	public void setValue(T newValue)
	{
		value =  newValue;
	}
	@Override
	public boolean isMutable() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getValue().toString();
	}

	@Override
	public boolean equals(Object other) {
		// TODO Auto-generated method stub
		return this.getValue().equals(((Literal<T>) other).getValue());
	}
	@Override
	public Literal<?> evaluate() {
		// TODO Auto-generated method stub
		return this;
	}
	@Override
	public void setProgram(Program program) {
		// TODO Auto-generated method stub
		this.program = program;
	}

}