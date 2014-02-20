/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: CommBase.java
Date créé: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/ 

/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.*;
import java.util.Observable;

/**
 * STRATEGIE :
 * 				Permet d'etablir la connexion avec le serveur grace  
 * 				a la reception des identifiants de la part de l'onglet Demarrer du menu
 * 
 * Base d'une communication via un fil d'execution parallele.
 */

/**
 * Classe CommBase qui permet
 * d'etablir la connection avec le serveur
 * mais aussi d'envoyer les lignes de commande recu
 * au DecodeurDeChaine
 * 
 *
 */
public class CommBase extends Observable{
	
	//CONSTANTES
	private final int DELAI = 200;

	
	//ATTRIBUTS DE LA  CLASSE COMMBASE
	@SuppressWarnings("rawtypes")
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;


	
	private int nbElement;

    private PrintStream    fluxEnvoyeVersServeur ;
    private BufferedReader  fluxRecuSurClient;
	
    private JFrame fenetrePrincipale;
	
	/**
	 * Constructeur par d�faut vide
	 */
	public CommBase(){
	}
	
	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	
	/**
	 * Methode : setNbElement()
<<<<<<< HEAD
	 * Permet de mettre a z�ro le nombre d lement
=======
	 * Permet de mettre a z�ro le nombre d lement
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 */
	public void setNbElementZero(){
		this.nbElement=0;
	}
	
	
	

	/**
	 * Methode : start()
	 * Démarre la communication avec le serveur
	 * 
	 * @param ipRecu   (Adresse ip recu du menu Demarrer)
	 * @param portRecu  (Port de l'hote recu du menu Demarrer)
	 * @throws UnknownHostException     Hote Inconnu
	 * @throws ConnectException			Erreur De Connection
	 * @throws IOException				Autres Erreurs
	 * 
	 * Cons�quent :
	 * 			La connexion est �tablie avec mise en place de gestion d'exceptions
	 */
	public void start(String ipRecu, int portRecu) throws IOException{
		
	    //DEBUT DU TEST DE VALIDATION IP
    	Boolean connexion= true;

	    		try {

	    			//TENTATIVE D'OUVERTURE DE LA CONNECTION...

	    			//Creation de la socket selon les parametres recus
                    Socket socketDeConnection = new Socket(ipRecu, portRecu);
	    			//creation du flux sortant
	    			fluxEnvoyeVersServeur= new PrintStream(socketDeConnection.getOutputStream());
	    			//creation du flux entrant
	    			fluxRecuSurClient= new BufferedReader(new InputStreamReader(socketDeConnection.getInputStream()));

				 	}

	    		/*gestion des exceptions
    			 * Erreur de connexion
    			 * Temps de connexion a la socket depasser
    			 * Erreur d'arguments
    			 * probleme de port
    			 * port injoignable
    			 *
    			 */
	    			//LES EXEPTIONS DE CONNECTION
	    			//Hote inconnu
		    		catch (UnknownHostException | ConnectException |
		    				SocketTimeoutException | BindException | NoRouteToHostException |
		    				PortUnreachableException |IllegalArgumentException  e)
		    			{
		    			// Envoie les parametre de texte a la methode warningMessage qui affiche le message d'erreur
		    			warningMessage("Il y a une erreur :","\n"+ e.toString() + "\n"+e.getLocalizedMessage());
		    			connexion= false;
		    			}


	    		//On va vers Connection 
	    		if (connexion) {
			
		 			JOptionPane.showMessageDialog(fenetrePrincipale, "Vous etes connecte"); 
		 			creerCommunication();
		 			}
	    			
	    	
	}
	    		
	   

	
	/**
<<<<<<< HEAD
	 * Methode : stop()
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 * Procedure qui permet de stopper la connexion avec le serveur
	 * 
	 * Consequent :
	 * 				La connexion se voit stopper
	 * 				le (int) nbElement se voit revenir a zero
	 * 				Affiche un message de signalement de fin de connexion
	 */
	public void stop(){

		if(isActif){
			//Envoie de la commande de Fin du client vers le serveur
			
			fluxEnvoyeVersServeur.println("END");
			//Mise en place de la fenetre de signalement de fin
			JOptionPane.showMessageDialog(fenetrePrincipale, 
					"Fin de la connexion", 
					"Fin",
					JOptionPane.INFORMATION_MESSAGE); 
		
		}
		//si le thread est different de null (est actif)
		if(threadComm!=null)
			// si le fil de communication n'est pas nul on le stop
			threadComm.cancel(true); 
		isActif = false;
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Methode : creerCommunication()
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
	 * Procedure qui permet de communiquer avec le serveur de formes
	 * 
	 * Consequent :
	 * 				Creation du fil d'execution parallele
	 * 				Communication avec le serveur : commande Get
	 * 				Reception des requetes entrantes
	 * 				Transmission des requetes recus a la fenetre principale
	 */

	
	@SuppressWarnings("rawtypes")
	protected void creerCommunication(){		
		// Cree un fil d'execusion parallele au fil courant,
		threadComm = new SwingWorker(){
			
			protected Object doInBackground() throws Exception {
				
				while(true){
					Thread.sleep(DELAI);
					
					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
					fluxEnvoyeVersServeur.println("GET");
					
 					//La méthode suivante alerte l'observateur 
					if(listener!=null)
						
					
						if(fluxRecuSurClient.readLine().length() !=9 && nbElement <10){
							//Envoie a ligne de commande recu (Formes.Formes) a la fenetre principale (fenetrePrincipale)
							firePropertyChange("ENVOIE-FORME-RECU", null, fluxRecuSurClient.readLine());
							

							nbElement++; //Incrementation du nombre de formes a chaque nouvelle forme recu
							//Permet de notifier le nombre de formes totale au JPanel PanneauNbItems
							setChanged();
							notifyObservers(nbElement);
							
						}
						//Nous avons attend 10 formes on arrete le threadComm
						if(nbElement==10){
							threadComm.cancel(true);
						}
				}
			}
		};
		
		
		/**
		 * si l'ecouteur n'est pas null
		 */
		if(listener!=null)
			   threadComm.addPropertyChangeListener(listener); // La methode "propertyChange" de ApplicationFormes sera donc appelee lorsque le SwinkWorker invoquera la methode "firePropertyChanger" 
				nbElement=0;  //Remise a zero du nombre d'elements
				setChanged();	//on applique les changements
				notifyObservers(nbElement);//On avise l'observeur
			threadComm.execute(); // Lance le fil d'exécution parallele.
			isActif = true;
	}
	
	/**
	 * MEthode : recupereJFrame()
	 * Procedure qui recupere la JFrame principale
	 * @param frame JFrame
	 */
	public void recupereJFrame(FenetrePrincipale frame){
		fenetrePrincipale=frame;
		
	}
	
	/**
	 * Methode : isActif()
	 * Permet de savoir si 
	 * le fil d'exécution parallèle est actif
	 * @return isActif boolean
	 */
	public boolean isActif(){
		return isActif;
	}
	
	/**
	 * Methode : warningMessage()
	 * Permet d'afficher le message
	 *  d'erreur concernant la connexion
	 * @param information	String
	 * @param entete		String
	 */
	public void warningMessage(String information, String entete){
		JOptionPane.showMessageDialog(fenetrePrincipale,information,entete,JOptionPane.WARNING_MESSAGE);


	}
	
}
