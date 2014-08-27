package com.thejohncrafter.jdsl;

import java.util.HashMap;

import com.thejohncrafter.jdsl.methods.Method;

/**
 * Cette classe stocke les m�thodes du DSL.<br>
 * <br>
 * This class stores the DSL's methods.
 * 
 * @author thejohncrafter
 * @see Method
 * 
 */

public class MethodsList {
	
	/**
	 * Cette liste permet de sauvegarder les m�thodes.<br>
	 * <br>
	 * This list allows to save methods. 
	 */
	private static final HashMap<String, Method> list = new HashMap<String, Method>();
	
	/**
	 * Cette m�thode permet d'ajouter une m�thode dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add a method in <code>list</code>.
	 * @param key La cl� d'acc�s � la m�thode.<br>
	 * <br>
	 * The method's access key.
	 * @param content La m�thode.<br>
	 * <br>
	 * The method.
	 * @see list
	 */
	public static void putMethod(String key, Method content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette m�thode permet de chercher la m�thode stock�e dans <code>list</code> 
	 * correspondant � la cl� donn�e.<br>
	 * Si la m�thode est introuvable, la m�thode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the method stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the method is unreachable, the method returns <code>null</code>.
	 * @param key La cl� d'acc�s � la m�thode.<br>
	 * <br>
	 * The method's access key.
	 * @return La m�thode correspondant � la cl� d'acc�s.<br>
	 * <br>
	 * The method matching to the access key.
	 * @see list
	 */
	public static Method getMethod(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette m�thode supprime la m�thode � la cl� donn�e dans instance 
	 * et la retourne (si elle existe).<br>
	 * <br>
	 * This method deletes the method at the given key and returns it 
	 * (if it exists).
	 * @param key La cl� d'acc�s de la m�thode.<br>
	 * <br>
	 * The method's access key.
	 * @return La m�thode si elle existe, sinon null.<br>
	 * <br>
	 * The method if it exists, else null.
	 * @see list
	 */
	public static Method removeMethod(String key){
		
		return list.remove(key);
		
	}
	
	/**
	 * Cette m�thode permet d'acc�der � toutes les m�thodes.<br>
	 * <br>
	 * This method allows to access to all the methods.
	 * @return Un tableau contenant toutes les m�thodes.<br>
	 * <br>
	 * An array containing all the methods.
	 */
	public static Method[] getAll(){
		
		return list.values().toArray(new Method[list.size()]);
		
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
	public static void removeMethods(String from){
		
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
	public static void clearMethods(){
		
		list.clear();
		
	}
	
}
