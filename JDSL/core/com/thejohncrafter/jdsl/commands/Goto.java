package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.ExecutersList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet d'aller ou de retourner à la ligne donnée.<br>
 * <br>
 * This command allows you to go or to come back to a given script line.
 * 
 * @author thejohncrafter
 *
 */
public class Goto extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("command goto : bad argument count");
		
		int line;
		
		try{
			
			line = Integer.parseInt(args[0]);
			line++;
			
		}catch(NumberFormatException e){
			
			throw new JDSLException("command goto : bad number format");
			
		}
		
		if(line < 0)
			throw new JDSLException("command goto : argument is too low");
		
		line--;
		
		JDSL.out.println("command goto :");
		JDSL.out.println("\tline to go to : " + line);
		
		ExecutersList.getExecuter(uniqueID).setCurrLine(line);
		
	}
	
}
