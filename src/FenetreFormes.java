/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: FenetreFormes.java
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
Nom du fichier: FenetreFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import Formes.Formes;

import javax.swing.*;

import java.awt.*;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 250;
	public static final int HEIGHT = 250;
	public static final Dimension dimension = new Dimension(500,500);
	
    private ListePerso liste= new ListePerso();// Liste qui va recopier la liste de base
    
    boolean actif=false; //Boolean qui permet de r�afficher des que l'on recoit une nouvelle formes sinon boucle tout le temps
		
	/**
	 * Constructeur : FenetreFormes
	 * Constructeur par defaut
	 * Classe FenetreFormes
	 */
	
	public FenetreFormes(){}
	
	/*
	 * Methode : paintComponent()
	 * Proc�dure : qui permet de dessiner les formes dans la zone appropri�e
	 * Affiche la liste de formes 
	 * Consequent:
	 * 			le composant javax.swing.JComponent#paintComponent(java.awt.Graphics) est utiliser pour dessiner
	 */
	public void paintComponent(Graphics g) {
		
		//R�f�rence temporaire pour parourir la liste du debut a la fin
		
			if (actif){
				for(int i=0;i<liste.getNbElementListe();i++){
					
					liste.retournerUnTableauDobjet()[i].draw(g);
				}
			}
	}
		
	/**
	 * Methode : setListe()
	 * Permet de recupere la liste a dessiner
	 * @param listeRecu
	 * @throws Exception
	 */
	public void setListe(ListePerso listeRecu) throws Exception{
		
		liste = new ListePerso(listeRecu);
		actif=true;
	}

	
	
	/*
	 * Methode : getPreferredSize()
	 * Methode: Qui retourne la dimension preferee
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	
	public Dimension getPreferredSize(){
		return dimension;
	}
}
