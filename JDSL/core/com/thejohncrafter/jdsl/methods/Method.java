package com.thejohncrafter.jdsl.methods;

import com.thejohncrafter.jdsl.JDSLException;

/**
 * Cette classe abstraite permet de cr�er des m�thodes.<br>
 * <br>
 * This abstract class makes you able to create methods.
 * 
 * @author thejohncrafter
 *
 */
public abstract class Method {
	
	/**
	 * Cette m�thode est appell�e lors de l'appel de la m�thode.<br>
	 * <br>
	 * This method is called when the method is called.
	 * @param args Les arguments de la m�thode.<br>
	 * <br>
	 * The method's args.
	 * @param uniqueID L'ID unique du <code>CommandsExecuter</code> 
	 * dans lequel la m�thode est appel�e.<br>
	 * <br>
	 * The <code>CommandExecuter</code>'s where the method is called unique id.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 */
	public abstract String run(String uniqueID, String[] args) throws JDSLException;
	
}
