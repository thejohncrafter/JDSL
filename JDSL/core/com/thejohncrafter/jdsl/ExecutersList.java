package com.thejohncrafter.jdsl;

import java.util.HashMap;

/**
 * Cette classe contient tous les ex�cuteurs du DSL.<br>
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
	 * Cette m�thode permet d'ajouter un executeur dans <code>list</code>.<br>
	 * <br>
	 * This method allows to add an executer in <code>list</code>.
	 * @param key La cl� d'acc�s � l'executeur.<br>
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
	 * Cette m�thode permet de chercher l'executeur stock�e dans <code>list</code> 
	 * correspondant � la cl� donn�e.<br>
	 * Si l'executeur est introuvable, la m�thode retourne <code>null</code>.<br>
	 * <br>
	 * This method allows to find the executer stored in <code>list</code> matching 
	 * to the given key.<br>
	 * If the executer is unreachable, the method returns <code>null</code>.
	 * @param key La cl� d'acc�s � l'executeur.<br>
	 * <br>
	 * The executers access key.
	 * @return L'executeur correspondant � la cl� d'acc�s.<br>
	 * <br>
	 * The executer corresponding to the access key.
	 * @see list
	 */
	public static CommandsExecuter getExecuter(String key){
		
		return list.get(key);
		
	}
	
	/**
	 * Cette m�thode supprime l'executeur � la cl� donn�e dans instance 
	 * et le retourne.<br>
	 * <br>
	 * This method deletes the executer at the given key and returns it.
	 * @param key La cl� d'acc�s de l'executeur.<br>
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
	 * Cette m�thode supprime tous les �l�ments dont la cl� commence 
	 * par la cha�ne donn�e.<br>
	 * <br>
	 * This method deletes all the elements having key starting with the given string.
	 * @param from Le d�but de la cl� des �l�ments � supprimer.<br>
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
	 * Cette m�thode permet de vider <code>list</code>.<br>
	 * <be>
	 * This mehod allows to clear <code>list</code>.
	 * @see list
	 * @see HashMap#clear()
	 */
	public static void clearExecuters(){
		
		list.clear();
		
	}
	
}
