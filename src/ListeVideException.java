
@SuppressWarnings("serial")
/**
 * Classe ListeVideException qui permet
 * de Lever des exceptions aves des messages
 * différent selon le comportement de la liste personnel
 *
 */
public class ListeVideException extends Exception{
  
	public  ListeVideException(){}
	
	/**
	 *  Permet de lever une exception
	 * Constructeur de par copie d'attribut
	 * Fait appel à la méthode de la classe mère
	 * @param message (String)
	 */
	public  ListeVideException(String message){
		super(message);
	}
	
}
