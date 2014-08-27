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
	 * Cette m�thode permet d'ajouter un objet dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add an object in <code>list</code>.
	 * @param key La cl� d'acc�s � l'objet.<br>
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
	 * Cette m�thode permet de chercher l'objet stock�e dans <code>list</code> 
	 * correspondant � la cl� donn�e.<br>
	 * Si l'objet est introuvable, la m�thode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the object stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the object is unreachable, the method returns <code>null</code>.
	 * @param key La cl� d'acc�s � l'objet.<br>
	 * <br>
	 * The object's access key.
	 * @return L'objet correspondant � la cl� d'acc�s.<br>
	 * <br>
	 * The object corresponding to the access key.
	 * @see list
	 */
	public static Object getObj(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette m�thode cherche la cl� de l'objet du nom donn�.<br>
	 * <br>
	 * This method finds the key of the object with the given name.
	 * @param name Le nom de l'objet.<br>
	 * <br>
	 * The object name.
	 * @return La cl� de l'objet si elle a �t� trouv�e, sinon null.<br>
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
	 * Cette m�thode supprime l'objet � la cl� donn�e dans instance 
	 * et le retourne.<br>
	 * <br>
	 * This method deletes the object at the given key and returns it.
	 * @param key La cl� d'acc�s de l'objet.<br>
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
	 * Cette m�thode supprime tous les �l�ments dont la cl� commence 
	 * par la cha�ne donn�e.<br>
	 * <br>
	 * This method deletes all the elements having key starting with the given string.
	 * @param from Le d�but de la cl� des �l�ments � supprimer.<br>
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
	 * Cette m�thode permet de vider <code>list</code>.<br>
	 * <be>
	 * This mehod allows to clear <code>list</code>.
	 * @see list
	 * @see HashMap#clear()
	 */
	public static void clearObjs(){
		
		list.clear();
		
	}
	
}
