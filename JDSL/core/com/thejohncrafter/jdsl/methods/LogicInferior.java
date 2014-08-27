package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette méthode permet de savoir si le nombre a est inférieur au nombre b.<br>
 * <br>
 * This method makes you able to know if number a is inferior as number b.
 * 
 * @author thejohncrafter
 *
 */
public class LogicInferior extends Method {
	
	@Override
	public String run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("test inf : bad arguments count");
		
		int a, b;
		
		try{
			
			a = Integer.parseInt(args[0]);
			b = Integer.parseInt(args[1]);
			
		}catch(NumberFormatException e){
			
			throw new JDSLException("test inf : bad number format");
			
		}
		
		if(a < b)
			return "true";
		
		return "false";
		
	}
	
}
