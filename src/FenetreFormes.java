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

import javax.swing.*;
import java.awt.*;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(800,500);
	private Formes[] tabRecu= new Formes[10];
    private ListePerso liste = new ListePerso();
		
	/**
	 * Constructeur par defaut
	 * Classe FenetreFormes
	 */
	
	public FenetreFormes(){}
	
	/*
	 * Proc�dure : qui permet de dessiner les formes dans la zone appropri�e
	 * Affiche la liste de formes 
	 * Consequent:
	 * 			le composant javax.swing.JComponent#paintComponent(java.awt.Graphics) est utiliser pour dessiner
	 */
	public void paintComponent(Graphics g) throws Exception{

        liste.premier();

        //R�f�rence temporaire pour parourir la liste du debut a la fin
       liste.getElement() = debut;

        while(tmp != null){

            //aFFICHE
            System.out.println((tmp.element).getNom());

            //On passe � l'�l�ment suivant dans la pile
            tmp = tmp.suivant;

        }
		
	
	/**Proc�dure : qui permet de recevoir le tableau de Formes
	 * Consequent :
	 * 				On affecte ce tableau recu a l'attribut tabRecu de FenetreFormes
	 * @param tab [] Formes
	 */
	public void setTab(Formes[] tab){
		this.tabRecu = tab.clone();
		
	}
	
	
	/*
	 * Methode: Qui retourne la dimension pr�f�r�e
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	
	public Dimension getPreferredSize(){
		return dimension;
	}
}
