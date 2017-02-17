package worms.model.programs.parser;

import worms.util.Util;

public class Division extends BinaryExpression<Double>{


	public Division(Expression<Double> operandLeft,
			Expression<Double> operandRight) {
		super(operandLeft, operandRight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Literal<?> evaluate() {
		// TODO Auto-generated method stub
		if(Util.fuzzyEquals( (Double)(operandRight.evaluate().getValue()), 0))
		{
			program.interrupt();
			return null;
		}
		return new Literal<Double>((Double)(operandLeft.evaluate().getValue()) / (Double)(operandRight.evaluate().getValue()));
	}




}
