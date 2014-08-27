package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.VarList;

/**
 * Cette commande permet d'ajouter une variable dans le DSL.<br>
 * <br>
 * This commande ellows youto add a variable in a DSL.
 * 
 * @author thejohncrafter
 *
 */
public class AddVar extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length < 2)
			throw new JDSLException("command addVar : too few arguments !");
		
		String name = uniqueID + args[0];
		
		JDSL.out.println("running command addVar :");
		JDSL.out.println("\tvariable name : " + name);
		
		String var = args[1];
		
		for(int i = 2; i < args.length; i++)
			var += ' ' + args[i];
		
		JDSL.out.println("\tvariable content : " + var);
		
		VarList.putVar('%' + name + '%', var);
		
		JDSL.out.println("\tvariable succesfully added !");
		
	}
	
}
