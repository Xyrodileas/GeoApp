/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: CommBase.java
Date cr√©√©: 20/01/1014
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
Date cr√©√©: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import java.net.Socket;
import java.io.*;
import java.net.*;
import java.util.Observable;
import java.lang.IllegalArgumentException;

/**
 * STRATEGIE :
 * 				Permet d'Ètablir la connexion avec le serveur gr‚ce  
 * 				‡ la rÈception des identifiants de la part de l'onglet Demarrer du menu
 * 
 * Base d'une communication via un fil d'ex√©cution parall√®le.
 */

/**
 * Classe CommBase qui permet
 * d'Ètablir la connection avec le serveur
 * mais aussi d'envoyer les lignes de commande recu
 * au DecodeurDeChaine
 * @author Aissou Idriss
 * 
 *
 */
public class CommBase extends Observable{
	
	//CONSTANTES
	private final int DELAI = 1500;
	static final String ip ="127.0.0.1";
	static final int port  = 10000;
	
	//ATTRIBUTS DE LA  CLASSE COMMBASE
	@SuppressWarnings("rawtypes")
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private int nbElement=0;
	
	//SOCKET ELEMENTS
	private Socket          socketDeConnection;	
    private PrintStream    fluxEnvoyeVersServeur ;
    private BufferedReader  fluxRecuSurClient;
	
    private JFrame fenetrePrincipale;
	
	/**
	 * Constructeur par dÈfaut vide
	 */
	public CommBase(){
	}
	
	/**
	 * DÈfinir le rÈcepteur de l'information reÁue dans la communication avec le serveur
	 * @param listener sera alert√© lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	

	/**
	 * D√©marre la communication avec le serveur
	 * 
	 * @param ipRecu   (Adresse ip recu du menu Demarrer)
	 * @param portRecu  (Port de l'hote recu du menu Demarrer)
	 * @throws UnknownHostException     Hote Inconnu
	 * @throws ConnectException			Erreur De Connection
	 * @throws IOException				Autres Erreurs
	 * 
	 * ConsÈquent :
	 * 			La connexion est Ètablie avec mise en place de gestion d'exceptions
	 */
	public void start(String ipRecu, int portRecu) throws IOException{
		
	    //DEBUT DU TEST DE VALIDATION IP
    	Boolean connexion= true;
	    	
	    		try { 
	    			
	    			//TENTATIVE D'OUVERTURE DE LA CONNECTION...
	    			
	    			//Creation de la socket selon les parametres recus
	    			socketDeConnection = new Socket(ipRecu, portRecu);	
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
		    			warningMessage("Il y a une erreur :" + "\n"+ e.toString() + "\n"+e.getLocalizedMessage(), " Information d'erreur");
		    			connexion= false;
		    			}
	 
	    	
	    		if (ipRecu.equals(ip) && portRecu== port && connexion==true) {
			
		 			JOptionPane.showMessageDialog(fenetrePrincipale, "Vous Ítes connectÈ"); 
		 			creerCommunication();
		 			}
	    			
	    	
	}
	    		
	   
	    

	
	/**
	 * ProcÈdure qui permet de stopper la connexion avec le serveur
	 * 
	 * ConsÈquent :
	 * 				La connexion se voit stopper
	 * 				le (int) nbElement se voit revenir a zÈro
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
	 * ProcÈdure qui permet de communiquer avec le serveur de formes
	 * 
	 * ConsÈquent :
	 * 				Creation du fil d'execution parallele
	 * 				Communication avec le serveur : commande Get
	 * 				Reception des requetes entrantes
	 * 				Transmission des requetes recus a la fenetre principale
	 */

	@SuppressWarnings("rawtypes")
	protected void creerCommunication(){		
		// Cr√©e un fil d'ex√©cusion parall√®le au fil courant,
		threadComm = new SwingWorker(){
			
			protected Object doInBackground() throws Exception {
				
				while(true){
					Thread.sleep(DELAI);
					
					// C'EST DANS CETTE BOUCLE QU'ON COMMUNIQUE AVEC LE SERVEUR
					fluxEnvoyeVersServeur.println("GET");
					
 					//La m√©thode suivante alerte l'observateur 
					if(listener!=null)
						if(fluxRecuSurClient.readLine().length() !=9){
							
							nbElement++; //IncrÈmentation du nombre de formes ‡ chaque nouvelle forme recu
							//Permet de notifier le nombre de formes totale au JPanel PanneauNbItems
							setChanged();
							notifyObservers(nbElement);
							
							//Envoie a ligne de commande recu (Formes) ‡ la fenetre principale (fenetrePrincipale)
							firePropertyChange("ENVOIE-FORME-RECU", null, fluxRecuSurClient.readLine());
							
							//Condition d'arret
							if(nbElement==10){
								stop();
								
							}
						}
				}
			}
		};
		
		
		if(listener!=null)
			   threadComm.addPropertyChangeListener(listener); // La m√©thode "propertyChange" de ApplicationFormes sera donc appel√©e lorsque le SwinkWorker invoquera la m√©thode "firePropertyChanger" 
				nbElement=0;  //Remise a zero du nombre d'ÈlÈments
				setChanged();	//on applique les changements
				notifyObservers(nbElement);//On avise l'observeur
			threadComm.execute(); // Lance le fil d'ex√©cution parall√®le.
			isActif = true;
	}
	
	/**
	 * Procedure qui recupere la JFrame principale
	 * @param frame JFrame
	 */
	public void recupereJFrame(JFrame frame){
		fenetrePrincipale=frame;
		
	}
	
	/**
	 * Permet de savoir si le fil d'ex√©cution parall√®le est actif
	 * @return isActif boolean
	 */
	public boolean isActif(){
		return isActif;
	}
	
	/**
	 * Permet d'afficher le message d'erreur concernant la connexion
	 * @param information	String
	 * @param entete		String
	 */
	public void warningMessage(String information, String entete){
		JOptionPane.showMessageDialog(fenetrePrincipale,information,entete,JOptionPane.WARNING_MESSAGE);

	}
	/**
	 * Permet de retourner le nombre total de formes
	 * @return nbElement
	 */
	public int getNbElements(){
		return nbElement;
	}
}
