package worms.model.programs.parser;

import worms.model.Worm;

public class IsWorm extends UnaryExpression<Worm>{

	public IsWorm(Expression<Worm> newOperand) {
		super(newOperand);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Literal<?> evaluate()
	{
		// TODO Auto-generated method stub
		try
		{
			Worm worm = (Worm)operand.evaluate().getValue();
			if(worm != null) return new Literal<Boolean>(true);
			else return new Literal<Boolean>(false);
		}
		catch(ClassCastException error)
		{
			return new Literal<Boolean>(false);
		}	
	}

}
