package com.thejohncrafter.jdsl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.thejohncrafter.jdsl.methods.Method;

/**
 * Cette classe permet de gérer les commandes d'un fichier de DSL.<br>
 * <br>
 * This class allows you to handle DSL file's commands.
 * 
 * @author thejohncrafter
 *
 */
public class CommandsExecuter {
	
	/**
	 * Cette variable stocke le nom du fichier exécuté.<br>
	 * <br>
	 * This field contains the file's name.
	 */
	private String id;
	
	/**
	 * Cette variable stocke la ligne courante du DSL.<br>
	 * <br>
	 * This field contains the DSL's current line.
	 */
	private int currLine;
	
	/**
	 * Ce tablau de chaînes stocke les lignes de commandes du DSL.<br>
	 * <br>
	 * This String array contains all the DSL's commands.
	 */
	private String[] commands;

	/**
	 * Ce constructeur définit le fichier executé et le charge en mémoire.<br>
	 * Si une erreur se produit lors de la costruction, l'executeur n'est 
	 * pas ajouté à <code>ExecutersList</code>.
	 * <br>
	 * This constructor defines the ran file and load it.<br>
	 * If an error occurates when constructing, executer isn't added to <code>ExecutersList</code>.
	 * @param exeFile Le chemin d'accés au fichier executé.<br>
	 * <br>
	 * The DSL's classpath.
	 * @throws IOException Si une erreur d'entrée-sortie se produit.<br>
	 * <br>
	 * if an IO error occurates.
	 * @see ExecutersList
	 */
	public CommandsExecuter(String exeFile, String uniqueID) throws IOException{
		
		id = uniqueID + "::" + exeFile + "::";
		commands = putInArray(exeFile);
		
		JDSL.out.println("adding new executer with uniqueID " + id);
		ExecutersList.putExecuter(id, this);
		
	}
	
	/**
	 * Ce constructeur définit le fichier executé et le charge en mémoire.<br>
	 * Si une erreur se produit lors de la costruction, l'executeur n'est 
	 * pas ajouté à <code>ExecutersList</code>.
	 * <br>
	 * This constructor defines the ran file and load it.<br>
	 * If an error occurates when constructing, executer isn't added to <code>ExecutersList</code>.
	 * @param exeFile Le chemin d'accés au fichier executé.<br>
	 * <br>
	 * The DSL's classpath.
	 * @throws IOException Si une erreur d'entrée-sortie se produit.<br>
	 * <br>
	 * if an IO error occurates.
	 * @see ExecutersList
	 */
	public CommandsExecuter(String exeFile, String uniqueID, boolean deleteProps) throws IOException{
		
		id = uniqueID + "::" + exeFile + "::";
		commands = putInArray(exeFile);
		
		JDSL.out.println("adding new executer with uniqueID " + id);
		ExecutersList.putExecuter(id, this);
		
	}
	
	/**
	 * Cette méthode permet d'exécuter les commandes du DSL.<br>
	 * <br>
	 * This method handles DSL's commands.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 * @param uniqueID Un ID unique (n'importe le quel) qui permet d'identifier 
	 * ce <code>CommandsExecuter</code>.<br>
	 * <br>
	 * A unique ID (what you want) that allows to identify this <code>CommandsExecuter</code>.
	 */
	public void execute() throws JDSLException{
		
		try{
			
			String ln;
			String cmd;
			
			for(currLine = 0; currLine < commands.length; currLine++){
				
				ln = commands[currLine];
				ln = putVars(ln);
				ln = handleMethods(ln, true);
				
				cmd = extractWord(ln, 1);
				
				if(cmd == null)
					continue;
				
				if(ln.substring(0, 2).equals("//"))
					continue;
				
				JDSL.out.println("command : " + cmd);
				
				ArrayList<String> args = new ArrayList<String>();
				
				// récupération des arguments
				{
					
					int i = 2;
					String arg;
					while(true){
						
						arg = extractWord(ln, i);
						
						if(arg == null)
							break;
						
						args.add(arg);
						
						i++;
						
					}
					
				}
				
				if(cmd.equals("end")){
					
					if(args.size() != 0)
						throw new JDSLException("can't give arguments to \"end\"");
					
					continue;
					
				}
				
				Command command = CommandsList.getCommand(cmd);
				
				if(command == null){
					
					String loc = "";
					
					for(int i = 0; i < id.length(); i++){
						
						if(id.charAt(i) == '/' || id.charAt(i) == ':')
							break;
						
						loc += id.charAt(i);
						
					}
					
					loc += "::";
					
					command = CommandsList.getCommand(loc + cmd);
					
				}
				
				if(command == null)
					throw new JDSLException("can't find command " + cmd);
				
				command.run(id, args.toArray(new String[args.size()]));
				
			}
			
		}catch(JDSLException e){
			
			JDSL.out.println("error caught. Creating StackTrace...");
			
			createStackTrace(e);
			
			throw e;
			
		}
		
		JDSL.out.println("removing executer " + id + " from ExecutersList and "
				+ "deleting all its related content...");
		
		ExecutersList.removeExecuter(id);
		CommandsList.removeCMD(id);
		Properties.removeProps(id);
		VarList.removeVars(id);
		
	}
	
	/**
	 * Cette méthode crée le StackTrace de l'exception donnée en utilisant id.<br>
	 * <br>
	 * This method creates the given exception's StackTrace using id.
	 * @param e L'exception pour laquelle is faut créer le StackTrace.<br>
	 * <br>
	 * The exception where create StackTrace.
	 * @see id
	 */
	private void createStackTrace(JDSLException e){
		
		ArrayList<StackTraceElement> st = new ArrayList<StackTraceElement>();
		
		int lineNumber = -1;
		String fileName = "";
		boolean inNumber = false;
		int prevSpecialChar = -1;
		
		for(int i = 0; i < id.length(); i++){
			
			if(id.charAt(i) == '/'){
				
				inNumber = true;
				
				fileName = id.substring(prevSpecialChar+1, i);
				
				prevSpecialChar = i;
				i++;
				
			}else if(id.charAt(i) == ':'){
				
				if(inNumber){
					
					lineNumber = Integer.parseInt(id.substring(prevSpecialChar, i));
					
				}else{
					
					fileName = id.substring(prevSpecialChar+1, i);
					lineNumber = currLine;
					
				}
				
				prevSpecialChar = i;
				
				JDSL.out.println("new StackTraceElement : file = " + fileName + ", line = " + lineNumber);
				
				// si le nom de fichier est "loader" et le numéro de ligne est 19,
				//on récupère le StackTraceElement suivant :
				// if the file name is "loader" and the line number is 19,
				//we catch the following StackTraceElement :
				// JDSL file : loader.jdsl(line:19)
				if(st.size() == 0)
					st.add(new StackTraceElement("JDSL thread : " + fileName, "", "ignore this perameter", 0));
				else
					st.add(new StackTraceElement("JDSL file : " + fileName.substring(1),
							"", "line", lineNumber+1));
				
				i++;
				
			}
			
		}
		
		e.setStackTrace(st.toArray(new StackTraceElement[st.size()]));
		
	}
	
	/**
	 * Cette méthode met les lignes du fichier donné dans un tableau.<br>
	 * <br>
	 * This method puts all the given file's lines in an array.
	 * @param path Le chamin d'accés au fichier.<br>
	 * <br>
	 * The file's classpath.
	 * @return Le tableau contenant les lignes.<br>
	 * <br>
	 * The array containing all the lines.
	 * @throws IOException Si une erreur d'entrée/sortie se produit.<br>
	 * <br>
	 * If an IO error occurates.
	 */
	public static String[] putInArray(String path) throws IOException{
		
		ArrayList<String> array = new ArrayList<String>();
		
		File file = new File(path);
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		while(in.ready())
			array.add(in.readLine());
		
		in.close();
		
		return array.toArray(new String[array.size()]);
		
	}
	
	/**
	 * Cette méthode permet d'extraire le mot à la position donnée 
	 * de la chaîne donnée.<br>
	 * Si on veut extraire le premier mot de la chaîne, on met <code>loc</code> 
	 * à 1.<br>
	 * Si le mot est introuvable, la fonstion retourne <code>null</code>.<br>
	 * <br>
	 * This method allows you to extract the word at the given location in a giver string.<br>
	 * If you want to extract the string's first word, you must define <code>loc</code> 
	 * to 1.
	 * @param ln La ligne source.<br>
	 * <br>
	 * The source line.
	 * @param loc La position du mot à extraire.<br>
	 * <br>
	 * The word's location.
	 * @return Le mot correspondant, ou null si il est inexistant.<br>
	 * <br>
	 * The matching word, or null if it is unreachable.
	 * @throws IllegalArgumentException si loc est inférieur à 1.<br>
	 * <br>
	 * If loc in under 1.
	 */
	public static String extractWord(String ln, int loc){
		
		ln = ln + ' '; // pour être sur d'avoir un espace à la fin de la ligne.
					   // make sure to have a space at th eline's end.
		
		if(loc < 1)
			throw new IllegalArgumentException("in method \"extractXord\" : pos "
					+ "can't be inferior as 1");
		
		String word = "";
		int index = 0;
		boolean inWord = false;
		
		for(int i = 0; i < ln.length(); i++){
			
			if(ln.charAt(i) == ' ' || ln.charAt(i) == '\t'){
				
				if(inWord){
					
					index++;
					inWord = false;
					
					if(index == loc)
						return word;
					
					word = "";
					
				}
				
				continue;
				
			}
			
			inWord = true;
			word += ln.charAt(i);
		}
		
		return null;
		
	}
	
	/**
	 * Cette méthode remplace toutes les variables de la chaîne donnée par leurs valaurs 
	 * définies dans VarList.<br>
	 * <br>
	 * This method replaces all the variables in the given string by is values defined in VarList.
	 * @param ln La ligne à interpréter.<br>
	 * <br>
	 * The line to handle.
	 * @return La ligne avec les valeurs remplacées.<br>
	 * <br>
	 * The line with replaced values.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 * @see VarList
	 */
	private String putVars(String ln) throws JDSLException{
		
		boolean inVar = false;
		int varStart = 0;
		
		for(int i = 0; i < ln.length(); i++){
			
			if(ln.charAt(i) == '%'){
				
				if(inVar){
					
					i++;
					
					JDSL.out.println("variable to replace : " + ln.substring(varStart, i));
					String replaced = VarList.getVar('%' + id + ln.substring(varStart+1, i));
					
					if(replaced == null)
						throw new JDSLException("can't find variable " + id + ln.substring(varStart+1, i-1));
					
					ln = ln.replace(ln.substring(varStart, i), replaced);
					i = varStart + replaced.length();
					
				}else{
					
					varStart = i;
					
				}
				
				inVar = !inVar;
				
			}
			
		}
		
		return ln;
		
	}
	
	/**
	 * Cette méthode gère les appels de méthode de la chaîne donnée.<br>
	 * <br>
	 * This method handles the given string's method calls.
	 * @param ln La chaîne à gérer.<br>
	 * <br>
	 * The string to handle.
	 * @param first Permet à la méthode de savoir si elle est la première à être appelée.<br>
	 * <br>
	 * Makes the method able to know if it is the first to be called.
	 * @return La chaîne gérée.<br>
	 * <br>
	 * The handled string.
	 * @throws JDSLException Si une erreur se produit.<br>
	 * <br>
	 * If an error occurates.
	 */
	private String handleMethods(String ln, boolean first) throws JDSLException{
		
		for(int i = 0; i < ln.length(); i++){
			
			if(ln.charAt(i) == '('){
				
				int tagsBetween = 1;
				
				for(int index = i+1; index < ln.length(); index++){
					
					if(ln.charAt(index) == '(')
						tagsBetween++;
					else if(ln.charAt(index) == ')')
						tagsBetween--;
					
					if(tagsBetween == 0){
						
						String replaced = handleMethods(ln.substring(i+1, index), false);
						ln = ln.replace(ln.substring(i, index+1), replaced);
						
					}
					
				}
				
				if(tagsBetween != 0)
					throw new JDSLException("bad method call : " + tagsBetween);
				
			}
			
		}
		
		if(first)
			return ln;
		
		String cmd;
		
		cmd = extractWord(ln, 1);
		
		ArrayList<String> args = new ArrayList<String>();
		
		// récupération des arguments
		{
			
			int index = 2;
			String arg;
			while(true){
				
				arg = extractWord(ln, index);
				
				if(arg == null)
					break;
				
				args.add(arg);
				
				index++;
				
			}
			
		}
		
		Method method = MethodsList.getMethod(cmd);
		
		if(method == null){
			
			String loc = "";
			
			for(int index = 0; index < id.length(); index++){
				
				if(id.charAt(index) == '/' || id.charAt(index) == ':')
					break;
				
				loc += id.charAt(index);
				
			}
			
			loc += "::";
			
			method = MethodsList.getMethod(loc + cmd);
			
		}
		
		if(method == null)
			throw new JDSLException("can't find method " + cmd);
		
		ln = method.run(id, args.toArray(new String[args.size()]));
		
		return ln;
		
	}
	
	/**
	 * Cette méthode charche la balise de fin correspondant à la balise de départ donnée.<br>
	 * <br>
	 * This method searches the end tag matching to the given start tag.
	 * @param start L'emplacement de la balise de départ <strong>en comptant à partir de 0</strong>.<br>
	 * <br>
	 * The start tag's place <strong>counting from 0</strong>.
	 * @return L'emplacement de la balise de fin <strong>en comptant à partir de 0</strong>.<br>
	 * <br>
	 * The end tag's place <strong>counting from 0</strong>.
	 */
	public int getMatchingEndTag(int start){
		
		int tagCount = 0;
		start++;
		
		for(; start < commands.length; start++){
			
			String cmd = extractWord(commands[start], 1);
			
			if(cmd == null)
				continue;
			
			if(cmd.equals("if")){
				
				tagCount++;
				
			}else if(cmd.equals("end")){
				
				if(tagCount == 0)
					return start;
				
				tagCount--;
				
			}
			
		}
		
		return -1;
		
	}
	
	/**
	 * Cette méthode permet de trouver l'ID de l'exécuteur racine grâce à un ID unique 
	 * obtenu par exemple dans la méthode <code>run</code> de <code>Command</code>.<br>
	 * <br>
	 * This method allows to get the root executers's ID using a uniqueID obtained for instance 
	 * in the method <code>run</code> of <code>Command</code>.
	 * @param id L'ID unique qui permet de trouver le nom de l'executeur.<br>
	 * <br>
	 * The unique ID that allows to find the executer's name.
	 * @return Le nom de l'executeur racine.<br>
	 * <br>
	 * The root executer's name.
	 */
	public static String getRootExecuterName(String id){
		
		String root = "";
		
		for(int i = 0; i < id.length(); i++){
			
			if(id.charAt(i) == '/' || id.charAt(i) == ':')
				break;
			
			root += id.charAt(i);
			
		}
		
		root += "::";
		
		return root;
		
	}
	
	/**
	 * Cette méthode permet de trouver l'ID de l'exécuteur grâce à un ID unique 
	 * obtenu par exemple dans la méthode <code>run</code> de <code>Command</code>.<br>
	 * <br>
	 * This method allows to get the executers's ID using a uniqueID obtained for instance 
	 * in the method <code>run</code> of <code>Command</code>.
	 * @param id L'ID unique qui permet de trouver le nom de l'executeur.<br>
	 * <br>
	 * The unique ID that allows to find the executer's name.
	 * @return Le nom de l'executeur.<br>
	 * <br>
	 * The executer's name.
	 */
	public static String getExecuterName(String id){
		
		String exeName = "";
		boolean inNumber = false;
		int prevSpecialChar = -1;
		
		for(int i = 0; i < id.length(); i++){
			
			if(id.charAt(i) == '/'){
				
				inNumber = true;
				
				exeName = id.substring(prevSpecialChar+1, i);
				
				prevSpecialChar = i;
				i++;
				
			}else if(id.charAt(i) == ':'){
				
				if(!inNumber){
					
					exeName = id.substring(prevSpecialChar+1, i);
					
				}
				
				prevSpecialChar = i;
				
			}
			
		}
		
		return exeName;
		
	}
	
	/**
	 * @return La ligne en cours d'execution <strong>en comptant de zéro</strong>.<br>
	 * <br>
	 * The current line <strong>counting from zero.
	 */
	public int getCurrLine() {return currLine;}
	
	/**
	 * @param currLine La prochaine ligne à executer <strong>en comptant de zéro</strong>.<br>
	 * <br>
	 * The next line to handle <strong>counting from zero</strong>.
	 */
	public void setCurrLine(int currLine) {this.currLine = currLine;}
	
	/**
	 * @return Le tableau de chaînes qui stocke les lignes de commandes du DSL.<br>
	 * <br>
	 * The String array containing all the DSL's commands.
	 */
	public String[] getCommands() {return commands;}
	
}
