package worms.model.programs.parser;

import worms.model.Worm;

public class Getter extends UnaryExpression<Worm>
{
	public Val value;

	public Getter(Expression<Worm> newOperand, Val newValue) {
		super(newOperand);
		value = newValue;
		// TODO Auto-generated constructor stub
	}
	@Override
	public Literal<?> evaluate() {
		// TODO Auto-generated method stub
		if(operand.evaluate().getValue() == null)
		{
			program.interrupt();
			return null;
		}
		return  value.evaluate(operand);
	} 

	public enum Val 
	{
		//enum return

		X
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e) {
				// TODO Auto-generated method stub
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getX()));
			}
		},
		Y
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e) {
				// TODO Auto-generated method stub
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getY()));
			}	
		},
		HP
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getHitPoints()));
			}
		},
		MAX_HP
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getMaxHitPoints()));
			}
		},
		RADIUS
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getRadius()));
			}
		},
		DIRECTION
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getOrientation()));
			}
		},
		ACTION_POINTS
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getActionPoints()));
			}
		},
		MAX_ACTION_POINTS
		{
			@Override
			Literal<Double> evaluate(Expression<Worm> e)
			{
				return new Literal<>( new Double(((Worm)(e.evaluate().getValue())).getMaxActionPoints()));
			}
		};
		abstract Literal<Double> evaluate(Expression<Worm> e);

	}
}



