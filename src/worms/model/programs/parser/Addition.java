package worms.model.programs.parser;

public class Addition extends BinaryExpression<Double>{

	
	public Addition(Expression<Double> operandLeft,
			Expression<Double> operandRight) {
		super(operandLeft, operandRight);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Literal<Double> evaluate() {
		// TODO Auto-generated method stub
		return new Literal<Double>((Double)(operandLeft.evaluate().getValue()) + (Double)(operandRight.evaluate().getValue()));
	}
	
	

	
}
