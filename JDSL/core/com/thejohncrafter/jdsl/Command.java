package com.thejohncrafter.jdsl;

/**
 * Cette classe permet de créer des commandes pour les DSLs.<br>
 * <br>
 * This class is used to create DSL commands.
 * 
 * @author thejohncrafter
 *
 */
public abstract class Command {
	
	/**
	 * Cette méthode est appellée lors de l'appel de la commande.<br>
	 * <br>
	 * This method is called when the command is called.
	 * @param args Les arguments de la commande.<br>
	 * <br>
	 * The command's args.
	 * @param uniqueID L'ID unique du <code>CommandsExecuter</code> 
	 * dans lequel la commmande est appelée.<br>
	 * <br>
	 * The <code>CommandExecuter</code>'s where the commande is called unique id.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 */
	public abstract void run(String uniqueID, String[] args) throws JDSLException;
	
}
