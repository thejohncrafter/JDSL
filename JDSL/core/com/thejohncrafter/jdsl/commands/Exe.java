package com.thejohncrafter.jdsl.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsExecuter;
import com.thejohncrafter.jdsl.ExecutersList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet d'exécuter un autre fichier DSL.<br>
 * <br>
 * This command allows you to execute another DSL file.
 * 
 * @author thejohncrafter
 *
 */
public class Exe extends Command{
	
	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 2)
			throw new JDSLException("command exe : bad argument count");
		
		boolean anythingIfFileNotFound = Boolean.parseBoolean(args[1]);
		
		JDSL.out.println("command exe :");
		JDSL.out.println("\tfile to run : " + args[0]);
		JDSL.out.println("\tdo anything if file isn't found : " + anythingIfFileNotFound);
		
		int commandLine = ExecutersList.getExecuter(uniqueID).getCurrLine();
		
		try {
			
			String id = uniqueID.substring(0, uniqueID.length()-2) + "//" + commandLine + "::" + args[0];
			
			new CommandsExecuter(args[0], id).execute();
			
		} catch (FileNotFoundException e) {
			
			if(!anythingIfFileNotFound){
				
				JDSL.out.println("error : file not found");
				e.printStackTrace();
				throw new JDSLException("error : file not found", e);
				
			}else{
				
				JDSL.out.println("\tDSL can't be found");
				return;
				
			}
			
		} catch (IOException e) {
			
			JDSL.out.println("input/output error");
			e.printStackTrace();
			throw new JDSLException("input/output error", e);
			
		}
		
		JDSL.out.println("\tDSL successfully executed !");
		
	}

}
