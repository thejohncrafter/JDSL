package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande fonctionne de la même manière que echo en <code>batch</code>.<br>
 * <br>
 * This command works like the command echo in <code>batch</code>.
 * 
 * @author thejohncrafter
 *
 */
public class Echo extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		String echo = args[0];
		
		for(int i = 1; i < args.length; i++)
			echo += ' ' + args[i];
		
		JDSL.out.println("command echo:\n\tline to say : " + echo);
		
		System.out.println(echo);
		
	}

}
