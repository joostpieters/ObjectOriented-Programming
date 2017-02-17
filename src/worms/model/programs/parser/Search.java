package worms.model.programs.parser;

import worms.model.World;
import worms.model.Worm;
import worms.util.Util;

public class Search extends UnaryExpression<Double>{

	public Self self;
	public Search(Expression<Double> newOperand) {
		super(newOperand);
	}
	public void setSelf(Self self)
	{
		this.self = self;
	}
	public Self getSelf()
	{
		return self;
	}
	@Override
	public Literal<Worm> evaluate() {
		// TODO Auto-generated method stub
		Worm executingWorm = program.getWorm();
		World world = executingWorm.getWorld();
		
		Double alfa = ((Double)(executingWorm.getOrientation()) + (Double)(operand.evaluate().getValue())) % (2*Math.PI);
		Double e;
		Worm closestWorm = null; 
		Double smallestDistance = Double.MAX_VALUE;
		
		for(Worm worm : world.getWorms())
		{
			Double distance = Worm.calcDistance(worm.getX(), worm.getY(), executingWorm.getX(),  executingWorm.getY());
			e = Math.tan(worm.getRadius()/distance);
			if(worm != executingWorm
					&&	(Util.fuzzyBetween(alfa - e,alfa + e, (Math.atan2(worm.getY()- executingWorm.getY(), worm.getX()- executingWorm.getX())) % (2*Math.PI)) 
							|| Util.fuzzyBetween(alfa + e,alfa - e,  (Math.atan2(worm.getY()- executingWorm.getY(), worm.getX()- executingWorm.getX())) % (2*Math.PI) )))
						if(distance < smallestDistance)
						{
							closestWorm = worm;
							smallestDistance = distance;
						}
//			System.out.println("Orientation of executing worm : "+ executingWorm.getOrientation());
//			System.out.println("Between value :" + (alfa-e) +" and " + (alfa+e));
//			System.out.println("Angle between :" +Math.atan2(worm.getY()- executingWorm.getY(), worm.getX()- executingWorm.getX()));
		}
		return new Literal<>(closestWorm);
	}

}
