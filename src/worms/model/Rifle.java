package worms.model;

import be.kuleuven.cs.som.annotate.Basic;

	/**
	 *  A class rifle, extendsind the class Weapon  
	 *  @version 1.0
	 *  @author Minh Tri Tran 
	 *  		1Ba informatica
	 *  Code repository SVN:
	 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
	 * 		
	 */
public class Rifle extends Weapon{

	
	/**
	 * Initialize this new rifle with the given worm
	 * 
	 * @param 	worm	
	 * 			The worm to set
	 * 
	 * @post	new.getWorm() == worm
	 * 
	 */
	public Rifle(Worm worm) {
		super(worm, 10);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Return WeaponsName.RIFLE.toString()
	 */
	@Basic @Override
	public String getName() {
		// TODO Auto-generated method stub
		return WeaponsName.RIFLE.toString();
	}

}
