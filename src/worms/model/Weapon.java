package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

/**
 * An abstract class Weapon 
 *  
 *  @version 1.0
 *  @author Minh Tri Tran 
 *  		1Ba informatica
 *  Code repository SVN:
 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
 *	@invar	Each weapon has a proper worm
 *			|hasProperWorm()
 *	@invar	Each weapon has a proper projectile
 *			|hasProperProjectile()
 *
 */

public abstract class Weapon {

	protected Worm worm;
	protected Projectile projectile;
	protected boolean isTerminated;
	protected int actionPointsCost;

	/**
	 * Intialize this new Weapon with the given worm
	 * 
	 * @param 	worm
	 * 			The worm that use this weapon
	 * 
	 * @post 	|new.getWorm() == worm
	 * 
	 */
	public Weapon(Worm worm, int actionPointsCost)
	{
		setWorm(worm);
		setActionPointsCost(actionPointsCost);
	}

	/**
	 * Return the worm of this weapon
	 * 
	 */
	@Basic
	public Worm getWorm()
	{
		return worm;
	}

	/**
	 * Return the action points cost of this weapon
	 * 
	 */
	@Basic
	public int getActionPointsCost()
	{
		return actionPointsCost;
	}

	/**
	 * Set the action points cost for this weapon
	 * 
	 * @param 	actionPointsCost
	 * 
	 * @post	new.getActionPointsCost() == actionPointsCost
	 * 
	 */
	public void setActionPointsCost(int actionPointsCost)
	{
		this.actionPointsCost = actionPointsCost;
	}

	/**
	 * Set the given worm as worm 
	 * 
	 * @param 	worm
	 * 			The worm to set as
	 * 
	 * @post	|new.getWorm() == worm
	 * 
	 */
	public void setWorm(Worm worm)
	{
		this.worm = worm;
	}

	/**
	 * Return the projectile
	 */
	@Basic
	public Projectile getProjectile()
	{
		return projectile;
	}

	/**
	 * Set the given projectile as projectile, and given world as the world of this object 
	 * 
	 * @param 	world
	 * 			The world that this object belongs to 
	 * @param	projectile
	 * 			The projectile to set as projectile for this weapon
	 * 
	 * @post	|new.getProjectile() == projectile
	 * @post	|new.getProjectile().getWeapon() == this
	 * @post	|new.world.getActiveProjectile() == projectile
	 * 
	 */
	public void setProjectile(Projectile projectile)
	{
		this.projectile = projectile;
		if(projectile != null) projectile.setWeapon(this);
		getWorm().getWorld().setActiveProjectile(projectile);	
	}

	/**
	 * Remove the projectile of this weapon
	 * 
	 * @post	new.getProjectile() == null
	 * @post	old.getProjectile().getWeapon() == null
	 * 
	 * @throws	IllegalStateException
	 * 			projectile == null
	 * 
	 */
	public void removeProjectile()
	{
		if(projectile == null) throw new IllegalStateException();

		projectile.setWeapon(null);
		projectile = null; 
	}

	/**
	 * Terminate this weapon
	 * 
	 * @post	old.getProjectile().isTerminated == true
	 * @post	new.getProjectile() == null
	 * @post	new.isTerminated == true
	 * 
	 */
	public void terminate()
	{
		if(projectile != null && !projectile.isTerminated()) projectile.terminate();
		projectile = null;
		isTerminated = true;
		worm = null;
	}

	/**
	 * Check whether this weapon is terminated
	 * 
	 * @return	Result == isTerminated
	 */
	public boolean isTerminated()
	{
		return isTerminated;
	}

	@Basic
	public abstract String getName();

	/**
	 * Check whether this weapon has a proper worm
	 * 
	 * @return	|Result ==  
	 * 			|	worm == null || (worm!= null && !worm.isTerminated())
	 * 
	 */
	public boolean hasProperWorm()
	{
		return worm == null || (worm!= null && !worm.isTerminated());
	}

	/**
	 * Check whether this weapon has a proper projectile
	 * 
	 * @return	|Result == !projectile.isTerminated;
	 * 
	 */
	public boolean hasProperProjectile()
	{
		return !projectile.isTerminated;
	}


}
