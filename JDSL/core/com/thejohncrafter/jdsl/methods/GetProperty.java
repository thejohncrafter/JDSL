package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.CommandsExecuter;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.Properties;

/**
 * Cette méthode permet d'aller chercher un propriété.<br>
 * <br>
 * This method allows to get a property.
 * 
 * @author thejohncrafter
 * @see Properties
 * 
 */
public class GetProperty extends Method {

	@Override
	public String run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("method getProp : bad argument count");
		
		String loc = CommandsExecuter.getRootExecuterName(uniqueID) + args[0];
		
		JDSL.out.println("method getProp :\n\tproperty to get : " + loc);
		
		String prop = Properties.getProp(loc);
		
		if(prop == null)
			prop = "null";
		
		return prop;
		
	}

}
