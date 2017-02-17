package worms.model.programs.parser;

public class Sqrt extends UnaryExpression<Double>{


	public Sqrt(Expression<Double> newExpression)
	{
		super(newExpression);
	}
	@Override
	public Literal<Double> evaluate()
	{
		return new Literal<>(Math.sqrt((Double)operand.evaluate().getValue()));
	}

}
