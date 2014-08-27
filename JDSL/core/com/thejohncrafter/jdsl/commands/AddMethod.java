package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.MethodsList;
import com.thejohncrafter.jdsl.methods.Method;

/**
 * Cette commande permet de charger des m�thodes dans <code>MethodsList</code>.<br>
 * <br>
 * This command is used to load methods in <code>MethodsList</code>.
 * 
 * @author thejohncrafter
 * @see MethodsList
 */
public class AddMethod extends Command {
	
	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("command addMethod : bad argument count.");
		
		JDSL.out.println("running command addMethod :");
		JDSL.out.println("\tmethod to load : " + args[0]);
		JDSL.out.println("\tmethod custom name : " + args[1]);
		
		try {
			
			Class<?> c = Class.forName(args[0]);
			
			MethodsList.putMethod(uniqueID + args[1], (Method) c.newInstance());
			
		} catch (ClassNotFoundException e) {
			
			JDSL.out.println("can't find class " + args[0]);
			throw new JDSLException("can't find class " + args[0] + ' ' + e);
			
		} catch (InstantiationException e) {
			
			JDSL.out.println("can't instantiate class " + args[0]);
			throw new JDSLException("can't instantiate class " + args[0] + ' ' + e);
			
		} catch (IllegalAccessException e) {
			
			JDSL.out.println("can't access to class " + args[0] + " (illegal access)");
			throw new JDSLException("can't access to class " + args[0] + " (illegal access)" + ' ' + e);
			
		}
		
		JDSL.out.println("method successfully loaded !");
		
	}
	
}
