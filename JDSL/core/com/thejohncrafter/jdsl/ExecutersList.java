package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe contient tous les exécuteurs du DSL.<br>
 * <br>
 * This class contains all the DSL's executers.
 * 
 * @author thejohncrafter
 *
 */
public class ExecutersList {
	
	/**
	 * Cette ArrayList permet de sauvegarder les executeurs.<br>
	 * <br>
	 * This ArrayList allows to save all the executers.
	 */
	private static final HashMap<String, CommandsExecuter> list
		= new HashMap<String, CommandsExecuter>();
	
	/**
	 * Cette méthode permet d'ajouter un executeur dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add an executer in <code>list</code>.
	 * @param key La clé d'accés à l'executeur.<br>
	 * <br>
	 * The executer's access key.
	 * @param content L'executeur.<br>
	 * <br>
	 * The executer.
	 * @see list
	 */
	public static void putExecuter(String key, CommandsExecuter content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher l'executeur stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si l'executeur est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the executer stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the executer is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à l'executeur.<br>
	 * <br>
	 * The executers access key.
	 * @return L'executeur correspondant à la clé d'accés.<br>
	 * <br>
	 * The executer corresponding to the access key.
	 * @see list
	 */
	public static CommandsExecuter getExecuter(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode supprime l'executeur à la clé donnée dans instance 
	 * et le retourne.<br>
	 * <br>
	 * This method deletes the executer at the given key and returns it.
	 * @param key La clé d'accés de l'executeur.<br>
	 * <br>
	 * The executer's access key.
	 * @return L'executeur.<br>
	 * <br>
	 * The executer.
	 * @see list
	 */
	public static CommandsExecuter removeExecuter(String key){
		
		return list.remove(key);
		
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
	public static void removeExecuters(String from){
		
		String[] names = list.values().toArray(new String[list.size()]);
		
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
	public static void clearExecuters(){
		
		list.clear();
		
	}
	
}
