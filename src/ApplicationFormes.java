/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: ApplicationFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  
 

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Cette classe représente x2'application dans son ensemble.
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class ApplicationFormes{
	
	/**
	 * main de x2'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationFormes application = new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 */
	public ApplicationFormes(){
		CommBase comm = new CommBase();
		FenetrePrincipale fenetre = new FenetrePrincipale(comm);
		comm.setPropertyChangeListener(fenetre);
	}
}
