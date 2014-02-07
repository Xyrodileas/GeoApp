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

import java.beans.PropertyChangeListener;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.*;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;

    //Variables contenant les informations de connection
    String ipserveur;
    int portserveur;

    //Variables pour communiquer
    Socket Client = null;
    PrintStream sortie = null;
    DataInputStream reponse = null;
    DataInputStream entree = null;
	
	/**
	 * Constructeur
	 */
	public CommBase(){
        this.ipserveur = "localhost";
        this.portserveur = 10001;
	}

    public void setIpserveur(String ipserveur){
        this.ipserveur = ipserveur;
    }
    public void setPortserveur(int Port){
        this.portserveur = Port;
    }
	
	/**
	 * D�finir le r�cepteur de x2'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de x2'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
		creerCommunication();
	}
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
        try{
        sortie.println("END"); // On envoit la séquence de fin de communication au serveur
        System.out.println("Communication arrêté");
        threadComm.cancel(true); // On ferme le thread
        }catch(NullPointerException e){
            System.err.println("Pas de serveur à arrêter");
        }

        isActif=false;


	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

                // On tente de lier une socket avec le serveur
                try{
                    Client = new Socket(ipserveur,portserveur);
                    sortie = new PrintStream(Client.getOutputStream());
                    reponse = new DataInputStream(Client.getInputStream());
                    entree = new DataInputStream(new BufferedInputStream(System.in));

                }catch(UnknownHostException e){ // Si on reçoit cette exception, on avertit le thread principal que l'hôte n'a pas été trouvé
                    if(listener!=null)
                        firePropertyChange("Err", null, (Object) "Impossible de trouver l'hôte");
                }catch(IOException e){ // Si on reçoit cette exception, on avertit le thread principal que l'hôte n'a pas été trouvé
                    if(listener!=null)
                        firePropertyChange("Err", null, (Object) "Peut être le port n'est pas ouvert ?");
                }
                String reponseserveur = reponse.readLine(); // On récupère la séquence de début
                System.out.println(reponseserveur);
                sortie.println("GET"); // On envoit la première demande de forme
                while(true){

                    reponseserveur= reponse.readLine();

 					//La méthode suivante alerte l'observateur
					if(listener!=null)
					   firePropertyChange("ENVOIE-TEST", null, (Object) reponseserveur);
                    reponseserveur= reponse.readLine();
                    Thread.sleep(DELAI);
                    sortie.println("GET");
				}
				//return null;
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return vrai si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
