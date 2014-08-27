package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe stocke les propriétés du DSL.<br>
 * <br>
 * This class stores the DSL's properties.
 * 
 * @author thejohncrafter
 *
 */
public class Properties {

	/**
	 * Cette liste permet de sauvegarder les propriétés.<br>
	 * <br>
	 * This list allows to saves the proeprties. 
	 */
	private static final HashMap<String, String> list = new HashMap<String, String>();
	
	/**
	 * Cette méthode permet d'ajouter une propriété dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a property in <code>list</code>.
	 * @param key La clé d'accés à la propriété.<br>
	 * <br>
	 * The property's access key.
	 * @param content La propriété.<br>
	 * <br>
	 * The property.
	 * @see list
	 */
	public static void putProp(String key, String content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher la propriété stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si la propriété est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the property stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the property is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à la propriété.<br>
	 * <br>
	 * The property's access key.
	 * @return La propriété correspondant à la clé d'accés.<br>
	 * <br>
	 * The property matching to the access key.
	 * @see list
	 */
	public static String getProp(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode supprime la propriété à la clé donnée dans instance 
	 * et la retourne.<br>
	 * <br>
	 * This method deletes the property at the given key and returns it.
	 * @param key La clé d'accés de la propriété.<br>
	 * <br>
	 * The property's access key.
	 * @return La propriété.<br>
	 * <br>
	 * The property.
	 * @see list
	 */
	public static String removeProp(String key){
		
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
	public static void removeProps(String from){
		
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
	public static void clearProps(){
		
		list.clear();
		
	}
	
}
