package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;
import com.thejohncrafter.jdsl.VarList;

/**
 * Cette commande permet de supprimer une variable ajoutée avec <code>ADDVAR</code>.<br>
 * <br>
 * This command allows you to delete a variable added with <code>ADDVAR</code>.
 * 
 * @author thejohncrafter
 * @see AddVar
 *
 */
public class RemoveVar extends Command{

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("command rmvar : bad arguments count");
		
		String var = uniqueID + args[0];
		
		JDSL.out.println("command rmvar :");
		JDSL.out.println("\tvariable to remove : " + var);
		
		if(VarList.removeVar('%' + var + '%').equals("%"))
			throw new JDSLException("variable " + var + " is unreachable !");
		
		JDSL.out.println("\tvariable successfully removed !");
		
	}
	
}
