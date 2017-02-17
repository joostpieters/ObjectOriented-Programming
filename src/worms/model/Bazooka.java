package worms.model;

import be.kuleuven.cs.som.annotate.Basic;


	/**
	 *  A class bazooka, extending the class weapon 
	 *  
	 *  @version 1.0
	 *  @author Minh Tri Tran 
	 *  		1Ba informatica
	 *  Code repository SVN:
	 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
	 * 		
	 */
public class Bazooka extends Weapon{
	
	/**
	 * Initialize this new bazooka with the given worm
	 * 
	 * @param	worm
	 * 			The worm that this bazooka belongs to
	 */
	public Bazooka(Worm worm) {
		super(worm, 50);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Return the name of this weapon
	 * 
	 * @return	|Result == WeaponsName.BAZOOKA.toString()
	 */
	@Basic @Override
	public String getName() {
		// TODO Auto-generated method stub
		return WeaponsName.BAZOOKA.toString();
	}

}
