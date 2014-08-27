package com.thejohncrafter.jdsl;

import java.util.HashMap;

import com.thejohncrafter.jdsl.methods.Method;

/**
 * Cette classe stocke les méthodes du DSL.<br>
 * <br>
 * This class stores the DSL's methods.
 * 
 * @author thejohncrafter
 * @see Method
 * 
 */

public class MethodsList {
	
	/**
	 * Cette liste permet de sauvegarder les méthodes.<br>
	 * <br>
	 * This list allows to save methods. 
	 */
	private static final HashMap<String, Method> list = new HashMap<String, Method>();
	
	/**
	 * Cette méthode permet d'ajouter une méthode dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a method in <code>list</code>.
	 * @param key La clé d'accés à la méthode.<br>
	 * <br>
	 * The method's access key.
	 * @param content La méthode.<br>
	 * <br>
	 * The method.
	 * @see list
	 */
	public static void putMethod(String key, Method content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher la méthode stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si la méthode est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the method stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the method is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à la méthode.<br>
	 * <br>
	 * The method's access key.
	 * @return La méthode correspondant à la clé d'accés.<br>
	 * <br>
	 * The method matching to the access key.
	 * @see list
	 */
	public static Method getMethod(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode supprime la méthode à la clé donnée dans instance 
	 * et la retourne (si elle existe).<br>
	 * <br>
	 * This method deletes the method at the given key and returns it 
	 * (if it exists).
	 * @param key La clé d'accés de la méthode.<br>
	 * <br>
	 * The method's access key.
	 * @return La méthode si elle existe, sinon null.<br>
	 * <br>
	 * The method if it exists, else null.
	 * @see list
	 */
	public static Method removeMethod(String key){
		
		return list.remove(key);
		
	}
	
	/**
	 * Cette méthode permet d'accéder à toutes les méthodes.<br>
	 * <br>
	 * This method allows to access to all the methods.
	 * @return Un tableau contenant toutes les méthodes.<br>
	 * <br>
	 * An array containing all the methods.
	 */
	public static Method[] getAll(){
		
		return list.values().toArray(new Method[list.size()]);
		
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
	public static void removeMethods(String from){
		
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
	public static void clearMethods(){
		
		list.clear();
		
	}
	
}
