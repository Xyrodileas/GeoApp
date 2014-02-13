/**
 *Exception levée si on essaie de retirer dans une liste vide
 *@author <a href="mailto:Pierre.Belisle@etsmtl.ca">Pierre Belisle</a>
 *@version novembre 2005
 */
public class ListeVideException extends Exception{
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  ListeVideException(){}
	
	//le message est récupérable par getMessage()
	public  ListeVideException(String message){
		super(message);
	}
	
}
