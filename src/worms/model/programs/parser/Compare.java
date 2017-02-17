package worms.model.programs.parser;

import worms.model.Worm;

public class Compare extends BinaryExpression<Double>
{
	public ComparesValue value;

	public Compare(Expression<Double> operandLeft, Expression<Double> operandRight, ComparesValue newValue) {
		super(operandLeft, operandRight);
		value = newValue;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Literal<Boolean> evaluate() {
		// TODO Auto-generated method stub
		return  value.evaluate(operandLeft, operandRight);
	} 

	public enum ComparesValue 
	{
		//enum return

		SMALLER
		{
			@Override
			Literal<Boolean> evaluate(Expression<Double> operandLeft,
					Expression<Double> operandRight) {
				// TODO Auto-generated method stub
				System.out.println(operandLeft.evaluate().getValue());
				return new Literal<>( new Boolean(  new Double((Double) operandLeft.evaluate().getValue()) < (Double)operandRight.evaluate().getValue()   )  );
			}

		},
		SMALLER_OR_EQUAL
		{
			@Override
			Literal<Boolean> evaluate(Expression<Double> operandLeft,
					Expression<Double> operandRight) {
				// TODO Auto-generated method stub
				return new Literal<>( new Boolean(  (Double)operandLeft.evaluate().getValue() <= (Double)operandRight.evaluate().getValue()   )  );
			}

		},
		GREATER
		{
			@Override
			Literal<Boolean> evaluate(Expression<Double> operandLeft,
					Expression<Double> operandRight) {
				// TODO Auto-generated method stub
				return new Literal<>( new Boolean(  (Double)operandLeft.evaluate().getValue() > (Double)operandRight.evaluate().getValue()   )  );
			}

		},
		GREATER_OR_EQUAL
		{
			@Override
			Literal<Boolean> evaluate(Expression<Double> operandLeft,
					Expression<Double> operandRight) {
				// TODO Auto-generated method stub
				return new Literal<>( new Boolean(  (Double)operandLeft.evaluate().getValue() >= (Double)operandRight.evaluate().getValue()   )  );
			}

		};
		
		abstract Literal<Boolean> evaluate(Expression<Double> operandLeft, Expression<Double> operandRight);

	}
}



