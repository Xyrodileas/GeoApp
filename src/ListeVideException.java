
@SuppressWarnings("serial")
/**
 * Classe ListeVideException qui permet
 * de Lever des exceptions aves des messages
 * diff�rent selon le comportement de la liste personnel
 *
 */
public class ListeVideException extends Exception{
  
	public  ListeVideException(){}
	
	/**
<<<<<<< HEAD
	 * Permet de lever une exception
=======
	 *  Permet de lever une exception
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 * Constructeur de par copie d'attribut
	 * Fait appel � la m�thode de la classe m�re
	 * @param message (String)
	 */
	public  ListeVideException(String message){
		super(message);
	}
	
}
