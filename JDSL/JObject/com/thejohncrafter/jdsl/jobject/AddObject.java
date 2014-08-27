package com.thejohncrafter.jdsl.jobject;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSLException;

public class AddObject extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("command addObj : bad argument count");
		
		String symbol = uniqueID + args[0];
		Object value = null;
		
		try {
			
			value = Class.forName(args[1]).newInstance();
			
		} catch (ClassNotFoundException e) {
			
			throw new JDSLException("command addObj : can't find object class");
			
		} catch (InstantiationException e) {
			
			throw new JDSLException("command addObj : can't instantiate object");
			
		} catch (IllegalAccessException e) {
			
			throw new JDSLException("command addObj : can't access to object class");
			
		}
		
		ObjectsList.putObj(symbol, value);
		
	}
	
}
