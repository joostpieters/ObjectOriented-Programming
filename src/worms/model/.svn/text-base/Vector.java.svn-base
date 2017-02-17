package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

public class Vector {

	/**
	 * A class Vector, containing  data of an object location.
	 *  
	 *  @version 1.0
	 *  @author Minh Tri Tran 
	 *  		1Ba informatica
	 *  Code repository SVN:
	 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/

	 */

	private double x;
	private double y;
	private double length;
	private double d;
	private double s;
	private double priority;
	private Vector origin;
	private Worm originWorm;
	private boolean isTerminated = false;

	/**
	 * Initialize this new vector with position (0,0).
	 * 
	 * @effect	This new vector is initialized with x and y location 0
	 * 			|this(0,0)
	 */
	public Vector()
	{
		this(0.0,0.0);
	}

	/**
	 * Initialize this new vector at the given location (x,y).
	 * 
	 * @param	x
	 * 			The x location for this new vector.
	 * @param	y
	 * 			The y location for this new vector.
	 * 
	 * @post 	The location of this new worm is equals the given (x,y)-location.
	 * 			|new.getX() == x && new.getY() == y
	 * 
	 * 
	 */
	public Vector(double x, double y)
	{
		this.x = x;
		this.y = y;
		this.setLength();
	}

	/**
	 * Return the x location of this vector.
	 * 
	 */
	@Basic
	public double getX()
	{
		return this.x;
	}
	/**
	 * Return the y location of this vector.
	 * 
	 */
	@Basic
	public double getY()
	{
		return this.y;
	}
	/**
	 * Return the length of this vector.
	 * 
	 */
	@Basic
	public double getLength()
	{
		setLength();
		return this.length;
	}

	/**
	 * Set the x location of this vector at the given x.
	 * 
	 * @param 	x
	 * 		  	The new x location for this vector.
	 * 
	 *  @post	The new x location of this vector is equal to the given x.
	 * 			|new.getX() == x
	 */
	public void setX(double x)
	{
		this.x = x;
	}

	/**
	 * Set the y location of this vector at the given y.
	 * 
	 * @param 	y
	 * 		  	The new y location for this vector.
	 * 
	 *  @post	The new y location of this vector is equal to the given y.
	 * 			|new.getY() == y
	 */
	public void setY(double y)
	{
		this.y = y;
	}

	/**
	 * Set the length of this vector.
	 * 
	 *  @post	The new length of this vector is equal to the square root
	 *  		of the sum of their squares.
	 * 			|new.getLength() == Sqrt( get.X()² + getY()²)
	 */
	public void setLength()
	{
		this.length = Math.sqrt(getX()*getX() + getY()*getY());
	}
	
	/**
	 * Set the origin vector and worm
	 * 
	 * @param 	v
	 * 			The vector as origin vector
	 * @param 	worm
	 * 			The worm as origin worm
	 * 
	 * @post	|new.getOrigin() == v
	 * @post	|new.getOriginWorm() == worm
	 * 
	 */
	public void setOrigin(Vector v, Worm worm)
	{
		origin  = v;
		originWorm = worm;
		setD();
		setS();
		setPriority();
	}
	
	
	private void setD()
	{
		if(origin != null) d = Math.sqrt(Math.pow(origin.getX() - getX(), 2) + Math.pow(origin.getY() - getY(),2));
		else d = 0;
	}
	private void setS()
	{
		if(origin != null)
		{
			s= Math.atan2(origin.getY() - getY(), getX() - origin.getX() ) % (2*Math.PI);
			
		}
		else s = 0;
	}
	private void setPriority()
	{
		if(originWorm != null) priority = d/originWorm.getRealRadius() + (.7875- Math.abs( originWorm.getOrientation()%Math.PI - Math.abs(s)%Math.PI))/.7875;
		else priority = 0;
	}
	
	/**
	 * Return the origin vector
	 * 
	 */
	public Vector getOrigin()
	{
		return origin;
	}
	
	/**
	 * Return the origin worm
	 * 
	 */
	public Worm getOriginWorm()
	{
		return originWorm;
	}
	
	/**
	 * Return the distance
	 * 
	 */
	public double getD()
	{
		return d;
	}
	
	/**
	 * Return the divergence
	 * 
	 */
	public double getS()
	{
		return s;
	}
	
	/**
	 * Return the priority
	 * 
	 */
	public double getPriority()
	{
		return priority;
	}

	/**
	 * Terminate this vector
	 * 
	 * @post	new.getX() == 0
	 * @post	new.getY() == 0
	 * @post	new.getLenght() == 0
	 * @post 	new.getOrigin() == null
	 * @post 	new.getOriginWorm() == null
	 * @post	new.isTerminated == true
	 */
	public void terminate()
	{
		setX(0);
		setY(0);
		setLength();
		origin = null;
		originWorm = null;
		setD();
		setS();
		isTerminated = true;
	}
	
	/**
	 * Check whether this vector is terminated
	 * 
	 * @return	|Result == isTerminated
	 */
	public boolean isTerminated()
	{
		return isTerminated;
	}


}
