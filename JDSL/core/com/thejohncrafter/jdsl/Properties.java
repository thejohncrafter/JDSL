package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe stocke les propri�t�s du DSL.<br>
 * <br>
 * This class stores the DSL's properties.
 * 
 * @author thejohncrafter
 *
 */
public class Properties {

	/**
	 * Cette liste permet de sauvegarder les propri�t�s.<br>
	 * <br>
	 * This list allows to saves the proeprties. 
	 */
	private static final HashMap<String, String> list = new HashMap<String, String>();
	
	/**
	 * Cette m�thode permet d'ajouter une propri�t� dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a property in <code>list</code>.
	 * @param key La cl� d'acc�s � la propri�t�.<br>
	 * <br>
	 * The property's access key.
	 * @param content La propri�t�.<br>
	 * <br>
	 * The property.
	 * @see list
	 */
	public static void putProp(String key, String content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette m�thode permet de chercher la propri�t� stock�e dans <code>list</code> 
	 * correspondant � la cl� donn�e.<br>
	 * Si la propri�t� est introuvable, la m�thode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the property stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the property is unreachable, the method returns <code>null</code>.
	 * @param key La cl� d'acc�s � la propri�t�.<br>
	 * <br>
	 * The property's access key.
	 * @return La propri�t� correspondant � la cl� d'acc�s.<br>
	 * <br>
	 * The property matching to the access key.
	 * @see list
	 */
	public static String getProp(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette m�thode supprime la propri�t� � la cl� donn�e dans instance 
	 * et la retourne.<br>
	 * <br>
	 * This method deletes the property at the given key and returns it.
	 * @param key La cl� d'acc�s de la propri�t�.<br>
	 * <br>
	 * The property's access key.
	 * @return La propri�t�.<br>
	 * <br>
	 * The property.
	 * @see list
	 */
	public static String removeProp(String key){
		
		return list.remove(key);
		
	}
	
	/**
	 * Cette m�thode supprime tous les �l�ments dont la cl� commence 
	 * par la cha�ne donn�e.<br>
	 * <br>
	 * This method deletes all the elements having key starting with the given string.
	 * @param from Le d�but de la cl� des �l�ments � supprimer.<br>
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
	 * Cette m�thode permet de vider <code>list</code>.<br>
	 * <br>
	 * This method allows to clear <code>list</code>.<br>
	 * @see list
	 * @see HashMap#clear()
	 */
	public static void clearProps(){
		
		list.clear();
		
	}
	
}
