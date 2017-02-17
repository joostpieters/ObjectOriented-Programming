package worms.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
import worms.util.Util;

/**
 * A class World which contains data such as passableMap, width ..
 *  
 *  @version 1.0
 *  @author Minh Tri Tran 
 *  		1Ba informatica
 *  Code repository SVN:
 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
 *  
 *  @invar 	Each world must have proper worms
 *  	  	|hasProperWorms()
 *  @invar	Each world must have a proper current worm
 *  		|hasProperCurrentWorm()
 *  @invar 	Each world must have a proper projectile
 *  		|hasProperActiveProjectile()	
 *
 */

public class World {

	private double width;
	private double height;
	private final boolean[][] passableMap;
	private Random random;
	private final double scale;

	private final static double MIN_SIZE = .0;
	private final static double MAX_SIZE = Double.MAX_VALUE;

	private Collection<Worm> worms = new ArrayList<Worm>();
	private Worm currentWorm;

	private Projectile activeProjectile;

	private double midX;
	private double midY;

	private boolean terminated;

	/**
	 * Initialize this new world with the given width, height, passableMap, random
	 *
	 * 
	 * @param	width
	 * 			The width of this new world
	 * @param	height
	 * 			The height of this new world	
	 * @param	passableMap
	 * 			The passableMap containing whether or not a pixel is passable
	 * @param	random
	 * 			A random generator that generate random values
	 * 
	 * @post	The width of this new world is equals the given width
	 * 			|new.getWidth() == width
	 * @post	The height of this new world is equals the given height
	 * 			|new.getHeight() == height
	 * @post 	The passable map of this new worm is equals the given passable map.
	 * 			|new.getPassableMap() == passableMap
	 * @post 	The random of this new worm is equals the given random.
	 * 			|new.getRandom() == random
	 * 
	 */
	public World(double width, double height, boolean[][] passableMap, Random random)
	{
		setWidth(width);
		setHeight(height);
		this.passableMap = passableMap;
		setMidX();
		setMidY();
		setRandom(random);
		this.scale = this.getPassableMap().length/getHeight();
	}

	/**
	 * Return the scale of this world
	 * 
	 */
	public double getScale()
	{
		return this.scale;
	}

	/**
	 * Return the current worm
	 * 
	 */
	public Worm getCurrentWorm()
	{
		return currentWorm;
	}

	/**
	 * Set the given worm as the current worm
	 * 
	 * @param 	worm
	 * 		  	The worm to set as current worm
	 * 
	 * @post	The current worm is equal to the given worm
	 * 			|new.getCurrentWorm() == worm
	 * 
	 * @throws	IllegalArgumentException
	 * 			|!canHaveAsCurrentWorm(worm)
	 * 
	 */
	public void setCurrentWorm(Worm worm)
	{
		if(!canHaveAsCurrentWorm(worm)) throw new IllegalArgumentException();
		currentWorm = worm;
	}

	/**
	 * Set the given projectile as the active projectile of this world
	 * 
	 * @param 	projectile
	 * 		  	The projectile to set as the active projectile
	 * 
	 * @post	The active projectile is equal to the given projectile
	 * 			|new.getActiveProjectile() == projectile
	 * 
	 * @throws	IllegalArgumentException
	 * 			|!canHaveAsActiveProjectile(projectile)
	 * 
	 */
	public void setActiveProjectile(Projectile projectile)
	{
		if(!canHaveAsActiveProjectile(projectile)) throw new IllegalArgumentException();
		activeProjectile = projectile;
	}

	private void setWidth(double newWidth)
	{
		if(isValidSize(newWidth)) width = newWidth;
	}
	private void setHeight(double newHeight)
	{
		if(isValidSize(newHeight)) height = newHeight;
	}
	private void setMidX()
	{
		midX = width/2.0;
	}
	private void setMidY()
	{
		midY = height /2.0;
	}
	private boolean isValidSize(double size)
	{
		return !Double.isNaN(size) && size >= MIN_SIZE && size <= MAX_SIZE ;
	}

	/**
	 * Set the given random as random
	 * 
	 * @param 	random
	 * 		  	The random to set as the random of this world
	 * 
	 * @post	|new.getRandom() == random
	 * 
	 */
	public void setRandom(Random random)
	{
		this.random = random;
	}

	/**
	 * Add the given worm in this world
	 * 
	 * @param 	worm
	 * 			The worm to add
	 * 
	 * @post	new.getWorms().get(getWorms().size - 1) == worm
	 * 
	 * @throws	IllegalArgumentException
	 * 			!canHaveAsWorm(worm)
	 * 
	 */
	public void addWorm(Worm worm)
	{
		if(!(canHaveAsWorm(worm))) throw new IllegalArgumentException();
		worms.add(worm);
	}

	/**
	 * Return x position of the middle point of this world
	 * 
	 */
	public double getMidX()
	{
		return midX;
	}

	/**
	 * Return y position of the middle point of this world
	 * 
	 */
	public double getMidY()
	{
		return midY;
	}

	/**
	 * Return the minimal size of all worlds
	 * 
	 */
	@Basic
	public static double getMinimalSize()
	{
		return MIN_SIZE;
	}

	/**
	 * Return the maximal size of all worlds
	 * 
	 */
	@Basic
	public static double getMaximalSize()
	{
		return MAX_SIZE;
	}

	/**
	 * Return the width of this world
	 * 
	 */
	@Basic
	public double getWidth()
	{
		return width;
	}

	/**
	 * Return the height of this world
	 * 
	 */
	@Basic
	public double getHeight()
	{
		return height;
	}

	/**
	 * Return the passable map of this world
	 * 
	 */
	@Basic
	public boolean[][] getPassableMap()
	{
		return passableMap;
	}

	/**
	 * Return the random of this world
	 * 
	 */
	@Basic
	public Random getRandom()
	{
		return random;
	}

	/**
	 * Return the list containing all worms in this world
	 * 
	 */
	@Basic
	public Collection<Worm> getWorms()
	{
		return worms;
	}

	/**
	 * Return the active projectile of this world
	 * 
	 */
	@Basic
	public Projectile getActiveProjectile()
	{
		return activeProjectile;
	}

	/**
	 * Remove the given worm from this world
	 * 
	 * @param 	worm	
	 * 			The worm to be removed
	 * 
	 * @post	worm.(new getWorld()) == null
	 * 			new.getWorms().contains(worm) == false
	 * 			
	 * @throws	NullPointerException
	 * 			|worm == null
	 */
	public void removeWorm(Worm worm)
	{
		if(worm == null) throw new NullPointerException();
		worms.remove(worm);
	}

	/**
	 * Return whether the given position is in range of the passable map
	 * 
	 * @param 	i
	 * 			The x position to check
	 * @param 	j
	 * 			The y position to check
	 * 
	 * @return	|Result == i >=0 && i < getPassableMap()[0].length && j >= 0 && j < getPassableMap().length
	 * 
	 */
	public boolean isInRange(double i, double j){
		return (i >=0 && i <= getPassableMap()[0].length && j >= 0 && j <= getPassableMap().length);
	}

	/**
	 * Return whether the given vector is in range of the passable map
	 * 
	 * @param 	vector
	 * 			The vector to check
	 * 
	 * @return	|Result == 
	 * 			|		isInRange(vector.getX(), vector.getY())
	 * 
	 */
	public boolean isInRange(Vector vector)
	{
		return isInRange(vector.getX(), vector.getY());
	}

	/**
	 * Return whether the given coordinates are in range of the height and width of the map
	 * 
	 * @param 	i
	 * 
	 * @param	j
	 * 			
	 * 
	 * @return	|Result == 
	 * 			|		i >=0 && i <= getWidth() && j >= 0 && j <= getHeight()
	 * 
	 */
	public boolean isInRangeInMeters(double i, double j)
	{
		return (i >=0 && i <= width && j >= 0 && j <= height);
	}

	/**
	 * Check whether the given location is impassable
	 * 
	 * @param x
	 * 
	 * @param y
	 * 
	 * @return	|Result == !getPassableMap()[x][y]
	 * 		
	 */
	public boolean isImpassable(double x, double y)
	{
		//		if(!isInRange(x, y)) return true;
		//
		//		double xViewedOnAPixel;
		//		double yViewedOnAPixel;
		//		if(Util.fuzzyEquals(x % (1/getScale()), 1) )
		//		{
		//			xViewedOnAPixel = 0;
		//			x = Math.round(x);
		//		}
		//		else
		//		{
		//			xViewedOnAPixel =  x % (1/getScale());
		//		}
		//
		//		if(Util.fuzzyEquals(y% (1/getScale()), 1) )
		//		{
		//			yViewedOnAPixel = 0;
		//			y = Math.round(y);
		//		}
		//		else
		//		{
		//			yViewedOnAPixel =  y % (1/getScale());
		//		}
		//
		//		double nextPixel = .1*(1/getScale());
		//
		//
		//		if(Util.fuzzyEquals(0, xViewedOnAPixel)) 
		//		{
		//			if(Util.fuzzyEquals(0, yViewedOnAPixel))
		//			{
		//				//diagonal
		//				if(isInRange(x-nextPixel, y-nextPixel) && isInRange(x+nextPixel, y+nextPixel) &&
		//						!getPassableMap()[(int)(x-nextPixel)][(int)(y-nextPixel)] &&
		//						!getPassableMap()[(int)(x+nextPixel)][(int)(y+nextPixel)]) 
		//					return true;
		//				else if(isInRange(x-nextPixel, y+nextPixel) && isInRange(x+nextPixel, y-nextPixel) &&
		//						!getPassableMap()[(int)(x-nextPixel)][(int)(y+nextPixel)] &&
		//						!getPassableMap()[(int)(x+nextPixel)][(int)(y-nextPixel)]) 
		//					return true;
		//				else return false;
		//			}
		//			else
		//			{
		//				//boven and beneden
		//				if(isInRange(x, y) && isInRange(x-nextPixel, y) &&
		//						!getPassableMap()[(int)(x-nextPixel)][(int)(y)] && !getPassableMap()[(int)x][(int)y]) return true;
		//				else 
		//					return false;
		//			}
		//		}
		//		else
		//		{
		//			if(Util.fuzzyEquals(0, yViewedOnAPixel))
		//			{
		//				//left right
		//				if(isInRange(x, y) && isInRange(x, y-nextPixel) &&
		//						!getPassableMap()[(int)(x)][(int)(y-nextPixel)] && !getPassableMap()[(int)x][(int)y]) return true;
		//				else 
		//					return false;
		//			}
		//			else
		//			{
		//				return !getPassableMap()[(int)x][(int)y];
		//			}
		//		}
		return !getPassableMap()[(int)x][(int)y];			

	}

	/**
	 * 	Check whether a given area is impassable
	 * @param 	x
	 * 			The x position of the center of the area to check
	 * @param 	y
	 * 			The y position of the center of the area to check
	 * @param 	radius
	 * 			The radius of the area to check
	 * 
	 * @return	for each j in realX - realRadius .. realX - realRadius + 2*realRadius width step 1*getScale()
	 *				for each j in realX - realRadius .. realX - realRadius + 2*realRadius width step 1*getScale() 
	 *					if(isInRange(i, j) && isImpassable(i, j)) then
	 *						result ==  true;
	 *			result == false;
	 * 
	 */
	public boolean isImpassable(double x, double y, double insideRadius, double outsideRadius)
	{
		double tmp = x;
		x = y;
		y = tmp;

		double iRadius = insideRadius;
		double addAngle;
		for(; Util.fuzzyLessThanOrEqualTo(iRadius, outsideRadius); iRadius+=1)//.05*outsideRadius)
		{
			double iAngle = 0;

			if(iRadius == 0)
			{
				if(isInRange(x,y) && isImpassable(x, y)) return true;
				iRadius +=0.05*outsideRadius;
			}
			//addAngle = 1/iRadius;
			addAngle = (Math.PI/2.0)/iRadius;
			for(; Util.fuzzyLessThan(iAngle, 2*Math.PI); iAngle+= addAngle)
			{
				if(isInRange(iRadius * Math.cos(iAngle) + y, iRadius * Math.sin(iAngle) + x) && isImpassable(iRadius * Math.sin(iAngle) + x, iRadius * Math.cos(iAngle) + y))
				{
					return true;
				}
			}
		}

		return false;

	}

	/**
	 * Check whether the given circular area is impassable
	 * 
	 * @param 	x
	 * @param 	y
	 * @param 	radius
	 * 
	 * @return	|Result == isImpassable(x, y, 0, Math.abs(radius))
	 * 
	 */	
	public boolean isImpassable(double x, double y, double radius)
	{
		if(Double.isNaN(x) || Double.isNaN(y) || Double.isNaN(radius) || !isInRange(x, y) ) return false;
		return isImpassable(x, y, 0, Math.abs(radius));
	}

	/**
	 * 	Check whether a given area is adjacent to impassable terrain
	 * 
	 * @param 	x
	 * 			The x position of the center of the area to check
	 * @param 	y
	 * 			The y position of the center of the area to check
	 * @param 	radius
	 * 			The radius of the area to check
	 * 
	 * @return	Result ==
	 * 			|!isImpassable(x, y, radius) &&
	 *			|isImpassable(x, y, radius+1, radius + radius*.1);
	 * 
	 */
	public boolean isAdjacent(double x, double y, double radius)
	{
		return !isImpassable(x, y, radius) &&
				isImpassable(x, y, radius+1, radius + radius*.1);
	}

	/**
	 * Convert the given vector to a vector with pixelled coordinates
	 *  
	 * @param 	v
	 * 		
	 * @return	|Result ==
	 * 			|		new Vector(convertToRealX(v.getX()), convertToRealY(v.getY()))
	 * 			
	 */
	public Vector convertToReal(Vector v)
	{
		return new Vector(convertToRealX(v.getX()), convertToRealY(v.getY())) ;
	}

	/**
	 * Convert the given vector to a vector with coordinates in meters
	 *  
	 * @param 	v
	 * 		
	 * @return	|Result ==
	 * 			|		new Vector(v.getX()/getScale(), (v.getY()-getHeight()*getScale())/(-getScale())
	 * 			
	 */
	public Vector convertToScale(Vector v)
	{
		return new Vector(v.getX()/getScale(), (v.getY()-getHeight()*getScale())/(-getScale()));
	}


	public void startNextTurn()
	{
		int x = ((ArrayList<Worm>) getWorms()).indexOf(getCurrentWorm());
		if(x == getWorms().size()-1) x = -1;
		for(++x; x < getWorms().size(); x++) if(((ArrayList<Worm>) getWorms()).get(x).isAlive()) break;

		this.setCurrentWorm((Worm)getWorms().toArray()[x]);
		getCurrentWorm().setActionPoints(getCurrentWorm().getMaxActionPoints());
		getCurrentWorm().setHitPoints(getCurrentWorm().getHitPoints() + 10);

		if(getCurrentWorm().hasProgram())
		{
			getCurrentWorm().getProgram().execute();
			startNextTurn();
		}
	}

	/**
	 * Convert the single x coordinate to pixelled x coordinate
	 * 
	 * @param	 x
	 * 
	 * @return	|Result == x*getScale()
	 * 
	 */
	public double convertToRealX(double x)
	{
		return x*this.getScale();
	}

	/**
	 * Convert the single y coordinate to pixelled y coordinate
	 * 
	 * @param	 y
	 * 
	 * @return	|Result == getHeight()*getScale() - y*getScale()
	 * 
	 */
	public double convertToRealY(double y)
	{
		return this.getHeight()*getScale() - y*this.getScale();
	}

	/**
	 * Add a new worm at a random adjacent location, if no such location is found then move towards the center of the map
	 * 
	 * @param 	program
	 * 
	 * @post	|new.getWorms().size == this.getWorms().size + 1
	 * 
	 */
	public void addNewWorm(Program program)
	{
		double radius = Worm.MIN_RADIUS*3;
		double x = random.nextDouble()*getWidth();
		double y = random.nextDouble()*getHeight();
		double angleTowardsCenter = (Math.atan2(getMidY() -y,  getMidX()-x))% (2*Math.PI);

		while( !isAdjacent(convertToReal(new Vector(x,y)).getX(), convertToReal(new Vector(x,y)).getY(), radius*getScale() ))
		{
			if(!isInRangeInMeters(x, y)) return;
			//half 0.1 radius => mist geen adjacency
			x = x + (0.05*radius)*Math.cos(angleTowardsCenter);
			y = y + (0.05*radius)*Math.sin(angleTowardsCenter);
		}
		String name;
		if(program == null) name = Worm.DEFAULT_NAME;
		else name = "Computer";

		Worm newWorm = new Worm(this, x, y, Math.PI/2, radius, name, program);
		newWorm.setState(State.ADJACENT);
	}


	/**
	 * Check if this world has proper worms
	 * 
	 * @return	|Result == for each worm in Worms
	 * 						 canHaveAsWorm(worm) && worm.hasProperWorld() && worm.getWorld() != this
	 * 
	 */
	@Raw
	public boolean hasProperWorms()
	{
		for(Worm worm : worms)
		{
			if(!canHaveAsWorm(worm)) return false;
			if(!hasProperWorm(worm)) return false;
		}
		return true;
	}

	/**
	 * Check if this world can have the given worm as worm
	 * 
	 * @param 	worm
	 * 
	 * @return	|Result == 		
	 * 			|	return worm!=null && !worm.isTerminated()
	 * 			
	 */
	@Raw
	public boolean canHaveAsWorm(Worm worm)
	{
		return worm!=null 
				&& !hasAsWorm(worm)
				&& !worm.isTerminated();
	}

	/**
	 * Check whether this world has a proper current worm
	 * 
	 * @return |Result == hasProperWorm(currentWorm);
	 * 
	 */
	@Raw
	public boolean hasProperCurrentWorm()
	{
		return hasProperWorm(currentWorm);
	}

	/**
	 * Check whether the given worm is proper to this world
	 * 
	 * @param 	worm
	 * 
	 * @return	|Result == 
	 * 			|	worm!= null && worm.getWorld() == this && !worm.isTerminated() && hasAsWorm(worm)
	 * 
	 */
	@Raw
	public boolean hasProperWorm(Worm worm)
	{
		return worm!= null && worm.getWorld() == this && !worm.isTerminated() && hasAsWorm(worm);
	}

	/**
	 * Check whether the given has the given worm as worm
	 * 
	 * @param 	worm
	 * 
	 * @return	|Result == getWorms().contains(worm)
	 * 
	 */
	@Raw
	public boolean hasAsWorm(Worm worm)
	{
		return worms.contains(worm);
	}

	/**
	 * Check whether this world can have the given worm as current worm
	 * 
	 * @param 	worm
	 * 	
	 * @return	|Result == hasAsWorm(worm)
	 * 
	 */
	@Raw
	public boolean canHaveAsCurrentWorm(Worm worm)
	{
		return hasAsWorm(worm);
	}

	/**
	 * Check whether the active projectile is proper to this world
	 * 
	 * @return	|Result == 
	 * 			|	activeProjectile == null ) ||
	 *			|	(activeProjectile != null && activeProjectile.hasProperWorld() && !activeProjectile.isTerminated());
	 * 
	 */
	@Raw
	public boolean hasProperActiveProjectile()
	{
		return (activeProjectile == null ) 
				|| (activeProjectile != null && activeProjectile.hasProperWorld() && !activeProjectile.isTerminated());
	}

	/**
	 * Check whether this world can have the given projectile as active projectile
	 * 
	 * @param 	projectile
	 * 
	 * @return	|Result == 
	 * 			| 	 !projectile.isTerminated()
	 * 
	 */
	@Raw
	public boolean canHaveAsActiveProjectile(Projectile projectile)
	{
		return true;
	}

	/**
	 * Terminate this world
	 * 
	 * @post	for each worm in this.getWorms()
	 * 				new worm.isTerminated()
	 * @post	this.activeProjectile.isTerminated()
	 * 
	 * @post	isTerminated() == true
	 * 
	 */
	public void terminate()
	{
		for(Worm worm : worms)
			worm.terminate();
		worms = null;
		currentWorm = null;
		if(activeProjectile != null) activeProjectile.terminate();
		activeProjectile = null;
		terminated = true;
	}

	/**
	 * Check whether this world is terminated
	 * 
	 * @return	|Result == terminated
	 */
	public boolean isTerminated()
	{
		return terminated;
	}

}
