package worms.model;

	/**
	 *  A class projectileBazooka that implements the class projectile 
	 *  
	 *  @version 1.0
	 *  @author Minh Tri Tran 
	 *  		1Ba informatica
	 *  Code repository SVN:
	 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
	 * 		
	 */
public class ProjectileBazooka extends Projectile{
	
	/**
	 * Intialize this projectile with the given x, y location and orientation
	 * 
	 * @param 	x
	 * 			The x location of this projectile
	 * @param 	y
	 *			The y location of this projectile
	 * @param 	orientation
	 * 			The orientation for this projectile
	 * 
	 * @post	new.getX() == x
	 * @post	new.getY() == y
	 * @post	new.getOrientation() == orientation
	 * @post	new.getMass() == .3
	 * @post	new.getDamage() == 80
	 * @post	new.getActionPointsCost() == 50
	 * 
	 */
	public ProjectileBazooka (World world, double x, double y, double orientation, Weapon weapon) {
		super(world, x, y, .3, orientation, weapon);
		// Variabel setForce(1.5);
		setDamage(80);
	}

}
