package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet de supprimer une commande donnée de <code>CommandsList</code>.<br>
 * <br>
 * This command allows to delete a given command from <code>CommandsList</code>.
 * 
 * @author thejohncrafter
 *
 */
public class RemoveCMD extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("command rmCMD : bad argument count");
		
		String command = uniqueID + args[0];
		
		JDSL.out.println("running command rmCMD :");
		JDSL.out.println("\tcommand to remove : " + command);
		
		CommandsList.removeCmd(command);
		
	}
	
}
