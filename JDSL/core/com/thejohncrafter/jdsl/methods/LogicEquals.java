package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette méthode permet de vérifier l'égalité de deux objets.<br>
 * <br>
 * This method makes you able to know if two objects arent equals.
 * 
 * @author thejohncrafter
 *
 */
public class LogicEquals extends Method {

	@Override
	public String run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("method equals : bad arguments count");
		
		if(args[0].equals(args[1]))
			return "true";
		
		return "false";
		
	}
	
}
