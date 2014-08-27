package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette classe abstraite permet de créer des méthodes.<br>
 * <br>
 * This abstract class makes you able to create methods.
 * 
 * @author thejohncrafter
 *
 */
public abstract class Method {
	
	/**
	 * Cette méthode est appellée lors de l'appel de la méthode.<br>
	 * <br>
	 * This method is called when the method is called.
	 * @param args Les arguments de la méthode.<br>
	 * <br>
	 * The method's args.
	 * @param uniqueID L'ID unique du <code>CommandsExecuter</code> 
	 * dans lequel la méthode est appelée.<br>
	 * <br>
	 * The <code>CommandExecuter</code>'s where the method is called unique id.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 */
	public abstract String run(String uniqueID, String[] args) throws JDSLException;
	
}
