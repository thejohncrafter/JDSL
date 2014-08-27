package com.thejohncrafter.jdsl.control_structures;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsExecuter;
import com.thejohncrafter.jdsl.ExecutersList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette structure de contrôle est l'équivalent d'un if en Java.<br>
 * <br>
 * This control structure is like a if in Java.
 * 
 * @author thejohncrafter
 *
 */
public class If extends Command {

	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {
		
		if(args.length != 1)
			throw new JDSLException("structure if : bad arguments count : " + args.length);
		
		boolean b;
		
		if(args[0].equals("true"))
			b = true;
		else if(args[0].equals("false"))
			b = false;
		else
			throw new JDSLException("structure if : bad argument : " + args[0]);
		
		JDSL.out.println("structure if :");
		JDSL.out.println("\tdo : " + b);
		
		if(b == false){
			
			CommandsExecuter e = ExecutersList.getExecuter(uniqueID);
			int lineToGoTo = e.getMatchingEndTag(e.getCurrLine());
			lineToGoTo++;
			e.setCurrLine(lineToGoTo);
			JDSL.out.println("\tmusn't go inside strusture. goeing to line " + lineToGoTo);
			
		}
		
	}
	
}
