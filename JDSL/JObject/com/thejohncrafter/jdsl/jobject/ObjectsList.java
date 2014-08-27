package com.thejohncrafter.jdsl.jobject;

import java.util.HashMap;

/**
 * Cette classe contient tous les objets du DSL.<br>
 * <br>
 * This class contains all the DSL's objects.
 * 
 * @author thejohncrafter
 *
 */
public class ObjectsList {
	
	/**
	 * Cette ArrayList permet de sauvegarder les objets.<br>
	 * <br>
	 * This ArrayList allows to save all the objects.
	 */
	private static final HashMap<String, Object> list
		= new HashMap<String, Object>();
	
	/**
	 * Cette méthode permet d'ajouter un objet dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add an object in <code>list</code>.
	 * @param key La clé d'accés à l'objet.<br>
	 * <br>
	 * The object's access key.
	 * @param content L'objet.<br>
	 * <br>
	 * The object.
	 * @see list
	 */
	public static void putObj(String key, Object content){
		
		list.put(key, content);
		
	}
	
	/**
	 * Cette méthode permet de chercher l'objet stockée dans <code>list</code> 
	 * correspondant à la clé donnée.<br>
	 * Si l'objet est introuvable, la méthode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the object stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the object is unreachable, the method returns <code>null</code>.
	 * @param key La clé d'accés à l'objet.<br>
	 * <br>
	 * The object's access key.
	 * @return L'objet correspondant à la clé d'accés.<br>
	 * <br>
	 * The object corresponding to the access key.
	 * @see list
	 */
	public static Object getObj(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette méthode cherche la clé de l'objet du nom donné.<br>
	 * <br>
	 * This method finds the key of the object with the given name.
	 * @param name Le nom de l'objet.<br>
	 * <br>
	 * The object name.
	 * @return La clé de l'objet si elle a été trouvée, sinon null.<br>
	 * <br>
	 * The object key if found, else null.
	 */
	public static String getObjectKey(String name){
		
		String key = null;
		
		String[] names = list.values().toArray(new String[list.size()]);
		
		for(int i = 0; i < names.length; i++){
			
			if(names[i].endsWith(name))
				name = names[i];
			
		}
		
		return key;
		
	}
	
	/**
	 * Cette méthode supprime l'objet à la clé donnée dans instance 
	 * et le retourne.<br>
	 * <br>
	 * This method deletes the object at the given key and returns it.
	 * @param key La clé d'accés de l'objet.<br>
	 * <br>
	 * The object's access key.
	 * @return L'objet.<br>
	 * <br>
	 * The object.
	 * @see list
	 */
	public static Object removeObj(String key){
		
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
	public static void removeObjs(String from){
		
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
	public static void clearObjs(){
		
		list.clear();
		
	}
	
}
