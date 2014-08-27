package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette méthode permet de vérifier l'inégalité de deux objets.<br>
 * <br>
 * This method makes you able to know if two objects aren't différents.
 * 
 * @author thejohncrafter
 *
 */
public class LogicDifferent extends Method {
	
	@Override
	public String run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("method diff : bad arguments count");
		
		if(!args[0].equals(args[1]))
			return "true";
		
		return "false";
		
	}
	
}
