package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet de délayer deux actions.<br>
 * <br>
 * This command allows you do delay two actions.
 * 
 * @author thejohncrafter
 *
 */
public class Sleep extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("command sleep : bad arguments count");
		
		System.out.println("command sleep");
		System.out.println("\ttime to sleep : " + args[0] + " miliseconds");
		
		try {
			
			Thread.sleep(Long.parseLong(args[0]));
			
		} catch (NumberFormatException e) {
			
			System.out.println("\terror when trying to parse argument 1 :");
			e.printStackTrace();
			throw new JDSLException("error when trying to parse argument 1" + e);
			
		} catch (InterruptedException e) {
			
			System.out.println("\terror wheen sleeping :");
			e.printStackTrace();
			throw new JDSLException("error wheen sleeping", e);
			
		}
		
		System.out.println("\tslept without any error !");
		
	}
	
}
