package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsExecuter;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.Properties;

/**
 * Cette commande permet de mettre à jour un propriété donnée.<br>
 * <br>
 * This command allows you to update a given property.
 * 
 * @author thejohncrafter
 *
 */
public class SetProperty extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length < 2)
			throw new JDSLException("command setProp : bad argument count");
		
		JDSL.out.println("command setProp :");
		JDSL.out.println("\tproperty : " + args[0]);
		
		String value = args[1];
		
		for(int i = 2; i < args.length; i++)
			value += ' ' + args[i];
		
		JDSL.out.println("\tvalue : " + value);
		
		String loc = CommandsExecuter.getRootExecuterName(uniqueID);
		
		JDSL.out.println("\tvariable location : " + loc);
		
		Properties.putProp(loc + args[0], value);
		
		JDSL.out.println("\tcommand succesfully executed.");
		
	}
	
}
