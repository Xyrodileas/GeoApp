/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: FenetrePrincipale.java
Date crÃ©Ã©: 20/01/1014
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
Date crÃ©Ã©: 2013-05-03
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
 * Cette classe reprÃ©sente la fenÃªtre principale de l'application 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	
	private static final long serialVersionUID = -1210804336046370508L;
	
	//ATTRIBUTS DE FENETREPRINCIPALE
	FenetreFormes fenetreFormes;
	private ListePerso listeChaineFormes=new ListePerso();
	
	
	/**
	 * Constructeur : FenetrePrincipale
	 * Constructeur par copie d'attributs 
	 * de la classe FenetrePrincipale
	 * il recoit en paramètre le Commbase (comnunication avec le serveur)
	 * pour pouvoir l'envoyé en paramètre au panneau de menu
	 * @param comm (CommBase)
	 */
	public FenetrePrincipale(CommBase comm){
		
		MenuFenetre menu = new MenuFenetre(comm); //creation d'une instanciation de la classe menu
		menu.setJFrame(this);						//affectation du menu au JFrame
		
		PanneauNbItems comptageItems = new PanneauNbItems();		//Creation d'un instanciation du panneauNbItems
		comm.addObserver(comptageItems);							//Affecte un observateur a comm
		
		this.setLayout(new BorderLayout());							//Definit le style de Layout
		this.add(menu, BorderLayout.NORTH);							//Positionnement du menu cote haut
		this.add(comptageItems,BorderLayout.SOUTH );				//Positionnement du panneauNbItems vers le bas
		
		fenetreFormes = new FenetreFormes();			//Creer une instance de FenetreFormes
		this.add(fenetreFormes, BorderLayout.CENTER); 	// Ajoute la fenÃªtre de forme Ã  la fenÃ¨tre principale
		this.pack(); 									// Ajuste la dimension de la fenÃªtre principale selon celle de ses composants
		this.setVisible(true);							 // Rend la fenÃªtre principale visible.
		this.setLocationRelativeTo(null);
        this.setTitle("Client forme");
		
		//ajout de l'Ecouteur d'evenenement sur la fenetre Qui gere ouverture et fermeture de la fenetre
	    addWindowListener(new OuvertureFermetureFenetreEcouteur(comm,this));
	}
	
	
	// AppelÃ© lorsque le sujet lance "firePropertyChanger" 
	/*
	 * Permet d'ajouter à la liste de Formes chainée les formes
	 * qui seront crées au fur et à mesure de la réception des
	 * lignes de commandes de la part du serveur
	 * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
	 */
	public void propertyChange(PropertyChangeEvent arg0) {
		
		if(arg0.getPropertyName().equals("ENVOIE-FORME-RECU")){

			//CHAQUE NOUVELLE FORMES EST STOCKER DANS LA LISTE APRES CREATION DE LA FORMES
			try {
				listeChaineFormes.ajoute(DecodeurChaineFormes.creerForme((String) arg0.getNewValue()),1);
				
				//listeChaineFormes.afficheElementDeListe();
			} catch (Exception e) {listeChaineFormes=new ListePerso();	}
			
			
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
	 * Methode : videListeEtRedemarre()
	 * permet de Vider la liste 
	 * pour ajouter dix nouvele formes
	 * @throws ListeVideException 
	 */
	public void videListeEtRedemarre() throws ListeVideException{

		listeChaineFormes.videLaListeAuComplet();
	}
	
	/**
	 * Methode : nouvelleListe()
	 * Permet de creer une nouvelle liste 
	 * en cas de bug
	 */
	public void nouvelleListe(){
		this.listeChaineFormes= new ListePerso();
	}
	
	
	/**
	 * Permet d'indiquer au trieur le type de triage
	 * selon le boutons du menu activé
	 * @param int modeDeTriage
	 */
	
	public void aiguilleurDeTraitement(int modeDeTriage) throws Exception{
	
		switch(modeDeTriage){
		 /*
		  * (sequenceCroissant = 0)			(sequenceDecroissant = 1)
		  * (aireFormeCroissante = 2)		(aireFormeDecroissante = 3)
		  * (parTypeDeFormes = 4)			(parTypeDeFormesInverse = 5)
		  * (triParDistanceMax2points = 6)	(triLargeurCroissante = 7)
		  * (triLargeuDeroissante = 8)		(triParhauteurCroissante = 9)
		  * (triParhauteurCroissante = 10)	(triParOrdreOriginal = 11)
		  */
		case 0 :
            Triage.triBulleIDLoggerCroissant(listeChaineFormes);
			break;
		case 1 :
            Triage.triBulleIDLoggerDecroissant(listeChaineFormes);
			break;
		case 2 :
            Triage.triBulleAireCroissant(listeChaineFormes);
			break;
		case 3 :
            Triage.triBulleAireDecroissant(listeChaineFormes);
			break;
		case 4 :	
			Triage.triParFormes(listeChaineFormes);
			break;
		case 5 :
			Triage.triParFormesInverse(listeChaineFormes);
			break;
		case 6 :
			Triage.triParDistanceMax2points(listeChaineFormes);	
			break;
		case 7 :
			Triage.triLargeurCroissante(listeChaineFormes);
			break;
		case 8 :
			Triage.triLargeurDecroissante(listeChaineFormes);
			break;
		case 9 :
			Triage.triParhauteurCroissante(listeChaineFormes);
			break;
		case 10 :
			Triage.triParHauteurDecroissante(listeChaineFormes);
			break;
		case 11 :
			Triage.triParOrdreOriginal(listeChaineFormes);
			break;

		}
		
		//ON ORGANISE LA LISTE
        Triage.reorganize(listeChaineFormes);
        //ON REENVOIE LA NOUVeLLE LISTE TRIER
        fenetreFormes.setListe(listeChaineFormes);
        //ON RAFFRAICHT LE PANNEAU
        fenetreFormes.repaint();
		
	}

	
	
	/**
	 * Classe : OuvertureFermetureFenetreEcouteur()
	 * Permet d'ajouter des actions a l'ouverture 
	 * et a la fermeture du programme
	 *
	 */
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

