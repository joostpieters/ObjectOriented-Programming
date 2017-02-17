package worms.model;

/**
 * A class tuple
 *  
 *  @version 1.0
 *  @author Minh Tri Tran 
 *  		1Ba informatica
 *  Code repository SVN:
 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/

 */

public class Tuple<Double, Worm> {
	public final Double i;
	public final Worm worm;
	
	/**
	 * Intialize this new tuple with the given parameters
	 * 
	 * @param 	i
	 * 			The double number to stock
	 * @param 	worm
	 * 			The worm to stock
	 * 
	 * @post	new.getI() == i
	 * @post	new.getWorm() == worm
	 */
	public Tuple(Double i, Worm worm)
	{
		this.i = i;
		this.worm = worm;
	}

}
