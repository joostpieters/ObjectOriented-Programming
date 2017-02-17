package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

/**
 *  An abstract class entity
 *  
 *  @version 1.0
 *  @author Minh Tri Tran 
 *  		1Ba informatica
 *  Code repository SVN:
 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
 *  
 *  @invar	Each entity has a proper world
 *  		|hasProperWorld()
 *  @invar	Each entity has a valid orientation
 *  		|isValidOrientation(getOrientation())
 * 		
 */
public abstract class Entity {

	protected final double DENSITY;
	
	protected World world;
	protected Vector vector = new Vector();
	protected Vector realVector = new Vector();
	protected double orientation;
	protected double radius;
	protected double realRadius;
	protected double mass;
	protected double force;


	/**
	 * Initialize this new entity . 
	 * 
	 * @effect	This new entity is initialized with x and y location 0, with an orientation of 0, with density 1
	 * 			and set in the given world.
	 * 			|this(world, 0.0, 0.0, 0.0, 1);
	 * 
	 */
	public Entity(World world)
	{
		this(world, 0.0, 0.0, 0.0, 1);
	}

	/**
	 * Initialize this new entity at the given location (x,y), with the given orientation, given density
	 * in the given world. 
	 * 
	 * @param	world
	 * 			The world to create this entity entity within
	 * @param	x
	 * 			The x location for this new entity.		
	 * @param	y
	 * 			The y location for this new entity.
	 * @param	orientation
	 *			The orientation for this new entity.
	 * @param	density
	 * 			The density for this new entity.
	 *
	 * @post	The world of this new entity is equals the given world
	 * 			|new.getWorld() == world
	 * @post 	The location of this new entity is equals the given (x,y)-location.
	 * 			|new.getX() == x && new.getY() == y
	 * @post 	The orientation of this new entity is equals the given orientation.
	 * 			|new.getOrientation() == orientation
	 * @post 	The density of this new entity is equals the given density.
	 * 			|new.getDensity() == density
	 * 
	 */
	public Entity (World world, double x, double y, double orientation, double density)
	{
		this.setWorld(world);
		this.setX(x);
		this.setY(y);
		this.setOrientation(orientation);
		this.DENSITY = density;
	}


	/**
	 * Return the force of this entity
	 * 
	 */
	@Basic
	public double getForce()
	{
		return force;
	}

	/**
	 * Return the x location of this entity.
	 * 
	 */
	@Basic
	public double getX()
	{
		return vector.getX();
	}

	/**
	 * Return the y location of this entity.
	 * 
	 */
	@Basic
	public double getY()
	{
		return vector.getY();
	}

	/**
	 * Return the orientation of this entity.
	 * 
	 */
	@Basic
	public double getOrientation()
	{
		return orientation;
	}

	/**
	 * Return the radius of this entity.
	 * 
	 */
	@Basic
	public double getRadius()
	{
		return radius;
	}

	/**
	 * Return the mass of this entity.
	 * 
	 */
	@Basic
	public double getMass()
	{
		return mass;
	}

	/**
	 * Return the world of this entity
	 * 
	 */
	public World getWorld()
	{
		return world;
	}


	/**
	 * Return the real(= not scaled) x of this entity
	 * 
	 */
	public double getRealX()
	{
		return realVector.getX();
	}

	/**
	 * Return the real y of this entity
	 * 
	 */
	public double getRealY()
	{
		return realVector.getY();
	}

	/**
	 * Return the real radius of this entity
	 * 
	 */
	public double getRealRadius()
	{
		return realRadius;
	}

	/**
	 * Return the vector which contains positional information of this entity
	 * 
	 */
	public Vector getVector()
	{
		return vector;
	}

	/**
	 * Return the real vector which contains positional information of this entity
	 * 
	 */
	public Vector getRealVector()
	{
		return realVector;
	}

	public double getDensity()
	{
		return DENSITY;
	}


	//Mutators + checkers
	
	/**
	 * Set the world of this entity with the given world
	 * 
	 * @param 	world
	 * 		 	The world which this entity belongs to
	 * 
	 * @post	The new world of this entity is equal to the given world.
	 * 			|new.getWorld() == world
	 *
	 * @post   The last entity in the list of the world is equal to this entity
	 *      	|(new world).getentitys().get((new world).getentitys().size()) == this
	 *      
	 */
	protected abstract void setWorld(World world);

	/**
	 * Set the real radius in function of the radius and the scale
	 * 
	 * @post	The real radius is equal to the radius multiply by the scale of the world
	 * 			|new.getRealRadius() = getRadius()*getWorld().getScale()
	 * 
	 */
	protected void setRealRadius()
	{
		realRadius = getRadius()*getWorld().getScale();
	}


	/**
	 * Set the x location of this entity with the given x-location.
	 * 
	 * @param 	x
	 * 		 	The new x location for this entity.
	 * 
	 * @post	The new x location of this entity is equal to the given x.
	 * 			|new.getX() == x
	 * 
	 * @throws	IllegalArgumentException
	 * 			The given x is not a number
	 * 			|Double.isNaN(x) == true
	 * 
	 */
	public void setX(double x) throws IllegalArgumentException
	{
		if(Double.isNaN(x)) throw new IllegalArgumentException();
		vector.setX(x);
		realVector.setX(world.convertToRealX(x));
	}

	/**
	 * Set the real vector of this entity by converting vector.
	 * 
	 * @post	The real vector is equal to the vector converted to real value (pixels)
	 * 			|new.getRealVector() == convertToReal(getVector())
	 *
	 */
	public void setRealVector()
	{
		realVector = world.convertToReal(vector);
	}

	/**
	 * Set the y location of this entity with the given y-location.
	 * 
	 * @param	y
	 * 		  	The new y location for this entity.
	 * 
	 * @post	The new y location of this entity is equal to the given y.
	 * 			|new.getY() == y
	 * 
	 * @throws	IllegalArgumentException
	 * 			The given y is not a number
	 * 			|Double.isNaN(y) == true
	 * 
	 */
	public void setY(double y) throws IllegalArgumentException
	{
		if(Double.isNaN(y)) throw new IllegalArgumentException();
		vector.setY(y);
		realVector.setY(world.convertToRealY(y));
	}


	/**
	 * Set the orientation of this entity with the given angle.
	 * 
	 * @param 	angle
	 * 		 	The new orientation for this entity.
	 * 
	 * @pre		The given angle must be a valid angle.
	 * 			|isValidOrientation(angle) == true
	 * 
	 * @post	The new orientation for this entity is equal to the given angle.
	 * 			|new.getOrientation() == angle 
	 * 
	 */

	public void setOrientation(double angle)
	{
		assert isValidOrientation(angle);
		this.orientation = angle;
	}

	/**
	 * Check whether the given angle is valid
	 * 
	 * @param 	angle
	 * 			The angle to check
	 * 
	 * @return	|Result == !Double.isNaN(angle) && !Double.isInfinite(angle)
	 * 	
	 */
	protected static boolean isValidOrientation(double angle)
	{
		return !Double.isNaN(angle) && !Double.isInfinite(angle);
	}


	//Action methods + action checkers

	/**
	 * Check whether this entity can jump.
	 * 
	 * @return 	Return true if and only if there are action points left and if the orientation set on a positive scale of 2PI is smaller or equal to PI.
	 * 			|result == this.getActionPoints() > 0 && this.getSmallestPositiveAngle(this.getOrientation)<= Math.PI
	 * 
	 */
	public abstract boolean canJump();

	/**
	 * @post	The new (x,y) location of this entity is equal to its (x,y) location after jumping.
	 * 			|new.getX(jumpStep(jumpTime()[0])
	 * 			|new.getY(jumpStep(jumpTime()[1])
	 * 
	 * @throws 	IllegalArgumentException
	 * 			This entity cannot jump.
	 * 			 |!canJump() == true
	 */
	public abstract void jump(double timeStep);

	/**
	 * Return the time needed to perform a possible jump until it collide with an impassable terrain
	 * 
	 * @return 	Return the time needed to perform a possible jump
	 * 		
	 */
	public abstract Tuple<Double, Worm> jumpTime(double timeStep);


	/**
	 * Return the (x,y) location during a possible jump
	 * 
	 * @param 	time
	 * 		 	The time elapsed from the beginning of the jump to now
	 * 
	 * @return Return x and y location after the given time during a possible jump.
	 * 
	 */
	public double[] jumpStep(double time) throws IllegalArgumentException, IllegalStateException
	{
		if(Double.isNaN(time) || Double.isInfinite(time) || time<0 ) throw new IllegalArgumentException();
		if(!canJump()) throw new IllegalStateException();

		double initialVelocity = (getForce()/this.getMass()) * Constants.TIME_EXERTEDFORCE;
		double initialVelocityX = initialVelocity* Math.cos(this.getOrientation());
		double initialVelocityY = initialVelocity* Math.sin(this.getOrientation());

		return new double[] {this.getX() + (initialVelocityX*time),
				this.getY() + (initialVelocityY*time - .5*Constants.GRAVITATION*Math.pow(time, 2))};
	}

	/**
	 * Check whether the given vector is in the sector (in front of this entity)
	 * 
	 * @param 	point
	 * 			The vector to check 
	 * 
	 * @return	Return true if and only if the the vector created from the entity's orientation minus PI/4 to the given vector is oriented counterclockwise and
	 * 			the vector created from the entity's orientation plus PI/4 to the given vector is oriented clockwise and
	 * 			the distance between the vector and entity is smaller than its radius and
	 * 			the distance between the vector and entity is greater than .1 meter
	 * 			Otherwise return false
	 * 			|Return 
	 * 			|!isClockWise(startVector, point, getRealVector()) &&
	 *			|isClockWise(endVector, point, getRealVector()) &&
	 * 		 	|calcDistance(point, getRealVector()) <= getRealRadius() &&
	 *			|calcDistance(point, getRealVector()) > .1*getWorld().getScale()
	 */
	protected boolean isInSector(Vector point)
	{
		Vector startVector = new Vector(getRealX() + Math.cos(getOrientation()-.7875)*getRealRadius(), getRealY() - Math.sin(getOrientation()-.7875)*getRealRadius());
		Vector endVector = new Vector(getRealX() + Math.cos(getOrientation()+.7875)*getRealRadius(), getRealY() - Math.sin(getOrientation()+.7875)*getRealRadius());

		return  !isClockWise(startVector, point, getRealVector()) &&
				isClockWise(endVector, point, getRealVector()) &&
				calcDistance(point, getRealVector()) <= getRealRadius() &&
				calcDistance(point, getRealVector()) > .1*getWorld().getScale();
	}


	private boolean isClockWise(Vector v1, Vector v2, Vector center)
	{
		return (v1.getX()-center.getX())*(v2.getY()-center.getY()) - (v2.getX()-center.getX())*(v1.getY()-center.getY())  > 0;
	}
	
	/**
	 * Calculate the distance between the two given vectors
	 * 
	 * @param 	v1
	 * 			The first vector
	 * @param 	v2
	 * 			The second vector
	 * 
	 * @return	|Result == Math.sqrt(  Math.pow(v1.getX()-v2.getX(),2) +  Math.pow(v1.getY()-v2.getY(),2) )
	 * 
	 */
	public static double calcDistance(Vector v1, Vector v2)
	{
		return Math.sqrt(  Math.pow(v1.getX()-v2.getX(),2) +  Math.pow(v1.getY()-v2.getY(),2) );
	}
	
	/**
	 * Calculate the distance between the two points
	 * 
	 * @param 	x1
	 * @param	y1 
	 * @param 	x2
	 * @param	y2
	 * 
	 * @return	|Result == Math.sqrt(  Math.pow(v1.getX()-v2.getX(),2) +  Math.pow(v1.getY()-v2.getY(),2) )
	 * 
	 */
	public static double calcDistance(double x1, double y1, double x2, double y2)
	{
		return Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	}

	/**
	 * Terminate this entity.
	 * 
	 * @post 	The bazooka is terminated
	 *       	|old.getBazooka().isTerminated() == true && new.getBazooka() == null
	 * @post 	The rifle is terminated
	 *      	|old.getRifle().isTerminated() == true && new.getRifle() == null
	 * @post 	The selectedWeapon is equal to null
	 *      	|new.getSelectedWeapon() == null
	 * @post 	The world is equal to null
	 *      	|new.getWorld() == null
	 * @post 	The vector is equal to null
	 *      	|old.getVector().isTerminated == true && new.getVector() == null
	 * @post 	The real vector is equal to null
	 *      	|new.getRealVector() == null
	 * @post 	The orientation is equal to 0
	 *      	|new.getOrientation() == 0	 
	 * @post 	The radius is equal to 0
	 *      	|new.getRadius() == 0	
	 * @post 	The name is equal to null
	 *      	|new.getName() == null
	 * @post 	The state is equal to TERMINATED
	 *      	|new.getState() == State.TERMINATED	    
	 *
	 */
	public void terminate()
	{
		vector.terminate();
		vector = null;
		realVector.terminate();
		realVector = null;
	}

	/**
	 * Check whether this entity is terminated
	 * 
	 * @return	Return true if and only if the state of this entity equals to TERMINATED, otherwise return false
	 * 			|Result == getState() == State.TERMINATED
	 * 
	 */
	
	public abstract boolean isTerminated();

	public abstract boolean hasProperWorld();

}
