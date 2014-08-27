package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe contient toutes les vriables du dsl.<br>
 * <br>
 * This class contains all the DSL's commands.
 * 
 * @author thejohncrafter
 *
 */
public class CommandsList {
	
	/**
	 * Cette ArrayList permet de sauvegarder les commandes.<br>
	 * <br>
	 * This ArrayList allows to save all the commands.
	 * @see Command
	 */
	private static final HashMap<String, Command> list = new HashMap<String, Command>();
	
	/**
	 * Cette méthode permet d'ajouter une commande dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a command in <code>list</code>.
	 * @param key La clé d'accés à la commande.<br>
	 * <br>
	 * The commands access key.
	 * @param content La comande.<br>
	 * <br>
	 * The command.
	 * @see list
	 */
	public static void putCommand(String key, Command content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher la commande stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si la commande est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the command stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the command is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à la commande.<br>
	 * <br>
	 * The command's access key.
	 * @return La commande correspondant à la clé d'accés.<br>
	 * <br>
	 * The command matching to the access key.
	 * @see list
	 */
	public static Command getCommand(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode supprime la commande à la clé donnée dans instance 
	 * et la retourne.<br>
	 * <br>
	 * This method deletes the command at the given key and returns it.
	 * @param key La clé d'accés de la commande.<br>
	 * <br>
	 * The command's access key.
	 * @return La commande.<br>
	 * <br>
	 * The command.
	 * @see list
	 */
	public static Command removeCmd(String key){
		
		return list.remove(key);
		
	}
	
	/**
	 * Cette méthode permet d'accéder à toutes les commandes.<br>
	 * <br>
	 * This method allows to access to all the commands.
	 * @return Un tableau contenant toutes les commandes.<br>
	 * <br>
	 * An array containing all the commands.
	 */
	public static Command[] getAll(){
		
		return list.values().toArray(new Command[list.size()]);
		
	}
	
	/**
	 * Cette méthode supprime tous les éléments dont la clé commence 
	 * par la chaîne donnée.<br>
	 * <br>
	 * This method deletes all the elements having key starting with the given string.
	 * @param from Le début de la clé des éléments à supprimer.<br>
	 * <br>
	 * The elements to delete's key start.
	 */
	public static void removeCMD(String from){
		
		String[] names = list.keySet().toArray(new String[list.size()]);
		
		for(int i = 0;  i < names.length; i++){
			
			if(names[i].startsWith(from))
				list.remove(names[i]);
			
		}
		
	}
	
	/**
	 * Cette méthode permet de vider <code>list</code>.<br>
	 * <be>
	 * This mehod allows to clear <code>list</code>.
	 * @see list
	 * @see HashMap#clear()
	 */
	public static void clearVars(){
		
		list.clear();
		
	}
	
}
