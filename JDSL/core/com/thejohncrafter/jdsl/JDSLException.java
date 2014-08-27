package com.thejohncrafter.jdsl;

/**
 * Cette exception est lancée par le programme lorsqu'une erreur se produit.<br>
 * <br>
 * This exception is thrown by the programm when an error occurates.
 * 
 * @author thejohncrafter
 *
 */
public class JDSLException extends Exception {
	
	private static final long serialVersionUID = -6208141446946377195L;
	
	/**
	 * Cette chaîne stocke le message.<br>
	 * <br>
	 * This string keeps the message.
	 */
	private String message;
	
	/**
	 * Simple constructeur.<br>
	 * <br>
	 * Simple constructor.
	 */
	public JDSLException() { super(); }
	
	/**
	 * Constructeur utilisant un message.<br>
	 * <br>
	 * Constructor using a message.
	 * @param message Le message.<br>
	 * <br>
	 * The message.
	 */
	public JDSLException(String message) { super(); setMessage(message); }
	
	/**
	 * Constructeur utilisant un message et une cause.<br>
	 * <br>
	 * Constructor using a message and a cause.
	 * @param message Le message.<br>
	 * <br>
	 * The message.
	 * @param cause La cause.<br>
	 * <br>
	 * The cause.
	 */
	public JDSLException(String message, Throwable cause) { super(cause); setMessage(message); }
	
	/**
	 * Constructeur utilisant une cause.<br>
	 * <br>
	 * Constrcutor using a cause.
	 * @param cause La cause.<br>
	 * <br>
	 * The cause.
	 */
	public JDSLException(Throwable cause) { super(cause); }
	
	public String getMessage() {return message;}
	
	/**
	 * @param message Le message de l'exception.<br>
	 * <br>
	 * Exception's message.
	 */
	public void setMessage(String message) {this.message = message;}
	
}
