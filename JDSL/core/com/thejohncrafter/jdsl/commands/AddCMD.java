package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet de charger des commandes dans <code>CommandsList</code>.<br>
 * <br>
 * This command is used  to load commands in <code>CommandsList</code>.
 * 
 * @author thejohncrafter
 * @see CommandsList
 */
public class AddCMD extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("command addCMD : bad argument count.");
		
		JDSL.out.println("running command addCMD :");
		JDSL.out.println("\tcommand to load : " + args[0]);
		JDSL.out.println("\tcommand custom name : " + args[1]);
		
		try {
			
			Class<?> c = Class.forName(args[0]);
			
			CommandsList.putCommand(uniqueID + args[1], (Command) c.newInstance());
			
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
		
		JDSL.out.println("command successfully loaded !");
		
	}
	
}
