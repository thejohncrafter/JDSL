package com.thejohncrafter.jdsl.jobject;

import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.methods.Method;

/**
 * Cette méthode cherche la clé de l'objet du nom donné.<br>
 * <br>
 * This method finds the key of the object with the given name.
 * 
 * @author thejohncrafter
 *
 */
public class GetObject extends Method {

	@Override
	public String run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("Method getObj : bad argument count");
		
		return ObjectsList.getObjectKey(args[0]);
		
	}
	
}
