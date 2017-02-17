package worms.model.programs.parser;

public class Equality<T> extends BinaryExpression<T>{

	boolean equal;
	public Equality(Expression<T> operandLeft, Expression<T> operandRight, boolean equal) {
		super(operandLeft, operandRight);
		this.equal = equal;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Literal<Boolean> evaluate() {
		
		// TODO Auto-generated method stub
		if(operandLeft.evaluate().getValue() == null)  
		{ 
			if(operandRight.evaluate().getValue() == null) return new Literal<>(equal);
			else return new Literal<>(!equal);
		}
		else
		{
			//XAND
			return new Literal<>(!(equal ^ operandLeft.evaluate().getValue().equals(operandRight.evaluate().getValue())));
		}
	}

}
