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

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;
import LaFabrique.FabriqueForme;
import java.awt.Composite;
import java.awt.AlphaComposite;

/**
 * Cette fenêtre gère x2'affichage des formes
 * @author Patrice Boucher
 * @date 2013/05/04
 */
import Formes.*;
public class FenetreFormes extends JComponent{

	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(500,500);
    private Forme affichage[] = new Forme[10];
    private int counter;
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
		for(int x=0; x<10; x++){
            affichage[x] = null;
        }
        counter=9;
	}
	
	/*
	 * Affiche la liste de formes 
	 */
	@Override 
	public void paintComponent(Graphics g){
        for(int y=0; y<10; y++){
            if(affichage[y] != null){ // On parcours le tableau pour afficher les composant dans l'ordre, du plus recent au plus ancien
                affichage[y].draw(g);
            }
        }
	}

    /**
     * Fonction permettant d'ajouter une forme, et d'en retirer la plus ancienne si le tableau est complet
     * @param forme
     */
    public void addForme(Forme forme){
        if(counter >0){ // Si le tableau n'est pas complet, on ajoute simplement la forme au tableau
            affichage[counter] = forme;
            counter -= 1;

        }
        else{
            for(int x=9; x>=0; x--){ // On permute tous les éléments pour les faires monter d'un rang.
                Forme tmp;           // Le plus ancien est redescendu au rang 0
                tmp = affichage[x];
                if(x > 0){
                    affichage[x] = affichage[x-1]; // Permutation
                    affichage[x-1] = tmp;
                }
                else // Si on est au premier rang (0), on remplace l'élément
                    affichage[x] = forme;
            }
        }

    }
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * x2'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
}
