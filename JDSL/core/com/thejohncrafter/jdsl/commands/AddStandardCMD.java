package com.thejohncrafter.jdsl.commands;

import com.thejohncrafter.jdsl.Command;
import com.thejohncrafter.jdsl.CommandsList;
import com.thejohncrafter.jdsl.JDSL;
import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette commande permet d'ajouter une commande "standard" 
 * (accessible depuis tous les fichiers DSL).<br>
 * <br>
 * This command allows to add a "standard" command 
 * (usable from all the DSL files).
 * 
 * @author thejohncrafter
 * 
 */
public class AddStandardCMD extends Command {
	
	private static ClassLoader classLoader = AddStandardCMD.class.getClassLoader();
	
	@Override
	public void run(String uniqueID, String[] args) throws JDSLException {

		if(args.length != 2)
			throw new JDSLException("command addStdCMD : bad argument count.");
		
		JDSL.out.println("running command addStdCMD :");
		JDSL.out.println("\tcommand to load : " + args[0]);
		JDSL.out.println("\tcommand custom name : " + args[1]);
		
		try {
			
			Class<?> c = classLoader.loadClass(args[0]);
			
			String loc = "";
			
			for(int i = 0; i < uniqueID.length(); i++){
				
				if(uniqueID.charAt(i) == '/' || uniqueID.charAt(i) == ':')
					break;
				
				loc += uniqueID.charAt(i);
				
			}
			
			loc += "::";
			
			CommandsList.putCommand(loc + args[1], (Command) c.newInstance());
			
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
	
	/**
	 * @return Le ClassLoader de la commande.<br>
	 * <br>
	 * The command's ClassLoader.
	 */
	public static ClassLoader getClassLoader() {return classLoader;}
	
	/**
	 * @param classLoader Le ClassLoader de la commande.<br>
	 * <br>
	 * The command's ClassLoader.
	 */
	public static void setClassLoader(ClassLoader classLoader) {AddStandardCMD.classLoader = classLoader;}
	
}
