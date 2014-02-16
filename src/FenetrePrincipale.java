/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: FenetrePrincipale.java
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
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

 
/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	
	private static final long serialVersionUID = -1210804336046370508L;
	
	//ATTRIBUTS DE FENETREPRINCIPALE
	static FenetreFormes fenetreFormes;
	private ListePerso listeChaineFormes=new ListePerso();
	
	
	
	public FenetrePrincipale(CommBase comm){
		
		MenuFenetre menu = new MenuFenetre(comm); //creation d'une instanciation de la classe menu
		menu.setJFrame(this);						//affectation du menu au JFrame
		
		PanneauNbItems comptageItems = new PanneauNbItems();		//Creation d'un instanciation du panneauNbItems
		comm.addObserver(comptageItems);							//Affecte un observateur a comm
		
		this.setLayout(new BorderLayout());							//Definit le style de Layout
		this.add(menu, BorderLayout.NORTH);							//Positionnement du menu cote haut
		this.add(comptageItems,BorderLayout.SOUTH );				//Positionnement du panneauNbItems vers le bas
		
		fenetreFormes = new FenetreFormes();			//Creer une instance de FenetreFormes
		this.add(fenetreFormes, BorderLayout.CENTER); 	// Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); 									// Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true);							 // Rend la fenêtre principale visible.
		this.setLocationRelativeTo(null);
		
		//ajout de l'Ecouteur d'evenenement sur la fenetre Qui gere ouverture et fermeture de la fenetre
	    addWindowListener(new OuvertureFermetureFenetreEcouteur(comm,this));
	}
	
	
	// Appelé lorsque le sujet lance "firePropertyChanger" 
	/*
	 * Permet de creer d'ajouter les formes dans un tableau des la reception d'une nouvelle ligne de commande
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent arg0) {
		
		if(arg0.getPropertyName().equals("ENVOIE-FORME-RECU")){

			//CHAQUE NOUVELLE FORMES EST STOCKER DANS LA LISTE APRES CREATION DE LA FORMES
			try {
				listeChaineFormes.ajoute(DecodeurChaineFormes.creerForme((String) arg0.getNewValue()), 1);
				
				//listeChaineFormes.afficheElementDeListe();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			// ON ENVOIE LA LISTE AU PANNEAU DESSINATEUR
			try {
				fenetreFormes.setListe(listeChaineFormes);
				
			} catch (ListeVideException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//ON RAFRAICHIT LE PANNEAU
			fenetreFormes.repaint();
			
		}
	
		
	}
	/**
	 * Permet d'indiquer au trieur le type de triage
	 * @param int modeDeTriage
	 */
	
	public void aiguilleurDeTraitement(int modeDeTriage) throws Exception{
	
		switch(modeDeTriage){
		 /*
		  * (sequenceCroissant = 0)(sequenceDecroissant = 1)
		  * (aireFormeCroissante=2)(aireFormeDecroissante=3)
		  * (parTypeDeFormes=4)(parTypeDeFormesInverse=5)
		  */
		case 0 :
			System.out.println("Cas 0 Sequence Croissant");
			System.out.println("VoiCI LA LISTE  AVANT TRAITEMENT SEQUENCE CROISSANT d'origine");
			listeChaineFormes.afficheIdDeLaLIste();
            Triage.bubbleSortByIDLogger(listeChaineFormes);
            System.out.println("VoiCI LA LISTE  APRES TRAITEMENT SEQUENCE CROISSANT d'origine");
            listeChaineFormes.afficheIdDeLaLIste();
			break;
		case 1 :
			System.out.println("Cas 1 sequence Deroissant");
			System.out.println("VoiCI LA LISTE  AVANT TRAITEMENT SEQUENCE DECROISSANT d'origine");
			listeChaineFormes.afficheIdDeLaLIste();
            Triage.bubbleSortByIDLoggerInverted(listeChaineFormes);
            System.out.println("VoiCI LA LISTE  APRES TRAITEMENT SEQUENCE DECROISSANT d'origine");
            listeChaineFormes.afficheIdDeLaLIste();
			break;
		case 2 :
			System.out.println("Cas 2 Aire Croissant");
			System.out.println("VoiCI LA LISTE  AVANT TRAITEMENT  AIRE CROISSANT d'origine");
			listeChaineFormes.afficheAireDeLaLIste();
            Triage.AireFormeCroissante(listeChaineFormes);
			break;
		case 3 :
			System.out.println("Cas 3 AIRE Decroissant");
			System.out.println("VoiCI LA LISTE  AVANT TRAITEMENT  AIRE DECROISSANT d'origine");
			listeChaineFormes.afficheAireDeLaLIste();
            Triage.AireFormeDecroissante(listeChaineFormes);;
			break;
		case 4 :
			System.out.println("Cas 4");
			break;
		case 5 :
			System.out.println("Cas 5");
			break;

		}
		
		//ON ORGANISE LA LISTE
        Triage.reorganize(listeChaineFormes);
        //ON REENVOIE LA NOUVeLLE LISTE TRIER
        fenetreFormes.setListe(listeChaineFormes);
        //ON RAFFRAICHT LE PANNEAU
        fenetreFormes.repaint();
		
	}

	 private class OuvertureFermetureFenetreEcouteur implements WindowListener{
  	   private FenetrePrincipale frame;
  	   private CommBase comm;
  	   
  	   private OuvertureFermetureFenetreEcouteur(CommBase commR, FenetrePrincipale frameR){
  		   comm=commR;
  		   frame=frameR;
  		   
  	   
  	   }
  	    public void windowActivated(WindowEvent e){
  	    }
  	    //Action lors de l'ouverture de la fenetre
  		public void windowOpened(WindowEvent arg0) {
  	    	JOptionPane.showMessageDialog(frame,"Veuillez vous connecter avec le serveur" + "\n" +
  	    									"Pour recevoir 10 formes et ensuite les trier","Connexion avec le serveur", JOptionPane.INFORMATION_MESSAGE);

  		}
  		
  		//Action lors de la fermeture de la fenetre
  		public void windowClosing(WindowEvent arg0) {
  			comm.stop();
  			System.exit(0);
  	    		
  	    }
  		
  		//on ne gere pas les autres evenements
  		public void windowClosed(WindowEvent arg0) {
  		}
  		
  		public void windowIconified(WindowEvent arg0) {
  		}
  		
  		public void windowDeiconified(WindowEvent arg0) {
  		}
  		
  		public void windowDeactivated(WindowEvent arg0) {
  		}
     
     }
     
	
}

