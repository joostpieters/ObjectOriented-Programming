package worms.model;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *  A class ComparatorPriority that implements Comparator<Vector>
 *  
 *  @version 1.0
 *  @author Minh Tri Tran 
 *  		1Ba informatica
 *  Code repository SVN:
 *  		http://sourceforge.net/p/projecttran/code/HEAD/tree/
 * 		
 */
public class ComparatorPriority implements Comparator<Vector>{

	/**
	 * Intialize this ComparatorPriority
	 */
	public ComparatorPriority(){}
	
	/**
	 * Compare to vectors based on their priority
	 * 
	 * @return	|if(o1.getPriority() == o2.getPriority()) the return 0;
	 *			|else then 
	 * 			|	if(return o1.getPriority()<o2.getPriority()) then return -1
	 *			|	else return 1
	 *
	 */
	@Override
	public int compare(Vector o1, Vector o2) {
		// TODO Auto-generated method stub
		if(o1.getPriority() == o2.getPriority()) return 0;
		return o1.getPriority()>o2.getPriority()? -1 : 1;
	}

}
