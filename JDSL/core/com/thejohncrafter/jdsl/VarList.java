package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe stocke les variables du DSL.<br>
 * <br>
 * This class stores the DSL's variables.
 * 
 * @author thejohncrafter
 *
 */
public class VarList {
	
	/**
	 * Cette liste permet de sauvegarder les variables.<br>
	 * <br>
	 * This list allows to save variables. 
	 */
	private static final HashMap<String, String> list = new HashMap<String, String>();
	
	/**
	 * Cette méthode permet d'ajouter une variable dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a variable in <code>list</code>.
	 * @param key La clé d'accés à la méthode.<br>
	 * <br>
	 * The variable's access key.
	 * @param content La variable.<br>
	 * <br>
	 * The variable.
	 * @see list
	 */
	public static void putVar(String key, String content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher la variable stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si la variable est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the variable stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the variable is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à la variable.<br>
	 * <br>
	 * The variable's access key.
	 * @return La variable correspondant à la clé d'accés.<br>
	 * <br>
	 * The variable matching to the access key.
	 * @see list
	 */
	public static String getVar(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode supprime la variable à la clé donnée dans instance 
	 * et la retourne (si elle existe).<br>
	 * <br>
	 * This method deletes the variable at the given key and returns it 
	 * (if it exists).
	 * @param key La clé d'accés de la variable.<br>
	 * <br>
	 * The variable's access key.
	 * @return La variable si elle existe, sinon "%".<br>
	 * <br>
	 * The variable if it exists, else "%".
	 * @see list
	 */
	public static String removeVar(String key){
		
		if(!list.containsKey(key))
			return "%";
		
		return list.remove(key);
		
	}
	
	/**
	 * Cette méthode permet d'accéder à toutes les variables.<br>
	 * <br>
	 * This method allows to access to all the variables.
	 * @return Un tableau contenant toutes les variables.<br>
	 * <br>
	 * An array containing all the variables.
	 */
	public static String[] getAll(){
		
		return list.values().toArray(new String[list.size()]);
		
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
	public static void removeVars(String from){
		
		String[] names = list.values().toArray(new String[list.size()]);
		
		for(int i = 0;  i < names.length; i++){
			
			if(names[i].startsWith(from))
				list.remove(names[i]);
			
		}
		
	}
	
	/**
	 * Cette méthode permet de vider <code>list</code>.<br>
	 * <br>
	 * This method allows to clear <code>list</code>.<br>
	 * @see list
	 * @see HashMap#clear()
	 */
	public static void clearVars(){
		
		list.clear();
		
	}
	
}
