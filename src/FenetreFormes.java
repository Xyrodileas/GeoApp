/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: FenetreFormes.java
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
Nom du fichier: FenetreFormes.java
Date crÃ©Ã©: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Cette fenÃªtre gÃ¨re l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent {
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(800,500);
	private Formes[] tabRecu= new Formes[10];
		
	/**
	 * Constructeur par defaut
	 * Classe FenetreFormes
	 */
	
	public FenetreFormes(){}
	
	/*
	 * Procédure : qui permet de dessiner les formes dans la zone appropriée
	 * Affiche la liste de formes 
	 * Consequent:
	 * 			le composant javax.swing.JComponent#paintComponent(java.awt.Graphics) est utiliser pour dessiner
	 */
	public void paintComponent(Graphics g){
		
			for (int i=9 ; i>=0 ; i--){
			
					if (tabRecu[i] != null ){
							
							//permet de parcourir le tableau recu de la methode setTab afin d'afficher les formes selon leur type 	
				
							//application de la couleur de l'objet Formes
							g.setColor(tabRecu[i].getCouleur());
				
							// Si c'est un Ovale on dessine l'objet Ovale
							if((tabRecu[i].getNom()).equals("Ovale")){
								g.fillOval(((Formes.Ovale)(tabRecu[i])).getCentreX(), ((Formes.Ovale)(tabRecu[i])).getCentreY(), ((Formes.Ovale)(tabRecu[i])).getRayonH(), ((Formes.Ovale)(tabRecu[i])).getRayonV());
							}
				
							// Si c'est un Carre on dessine l'objet carre
							else if ((tabRecu[i].getNom()).equals("Carre")){
									g.fillRect(((Formes.Carre)(tabRecu[i])).getX1(), ((Formes.Carre)(tabRecu[i])).getX1(), ((Formes.Carre)(tabRecu[i])).getY1(),((Formes.Carre)(tabRecu[i])).getY1());

							}
				
							// Si c'est une Ligne on dessine l'objet Ligne
							else if ((tabRecu[i].getNom()).equals("Ligne")){
									g.drawLine(((Formes.Ligne)(tabRecu[i])).getX1(), ((Formes.Ligne)(tabRecu[i])).getY1(), ((Formes.Ligne)(tabRecu[i])).getX2(), ((Formes.Ligne)(tabRecu[i])).getY2());
							}
							// Si c'est un Cercle on dessine l'objet Cercle
							else if ((tabRecu[i].getNom()).equals("Cercle")){
									g.fillOval(((Formes.Cercle)(tabRecu[i])).getCentreX(), (((Formes.Cercle)(tabRecu[i])).getCentreY()), ((Formes.Cercle)(tabRecu[i])).getRayon(),((Formes.Cercle)(tabRecu[i])).getRayon());
					
							}
				
							// Si c'est une Rectangle on dessine l'objet Rectangle
							else if ((tabRecu[i].getNom()).equals("Rectangle")){
									g.fillRect(((Formes.Rectangle)(tabRecu[i])).getX1(), ((Formes.Rectangle)(tabRecu[i])).getY1(), ((Formes.Rectangle)(tabRecu[i])).getX2(), ((Formes.Rectangle)(tabRecu[i])).getY2());


							}
						
					}
					
			}
				
	}
		
	
	/**Procédure : qui permet de recevoir le tableau de Formes
	 * Consequent :
	 * 				On affecte ce tableau recu a l'attribut tabRecu de FenetreFormes
	 * @param tab [] Formes
	 */
	public void setTab(Formes[] tab){
		this.tabRecu = tab.clone();
		
	}
	
	
	/*
	 * Methode: Qui retourne la dimension préférée
	 * Le Layout qui utilise (contient) FenetreFormes doit rÃ©server 
	 * l'espace nÃ©cessaire Ã  son affichage
	 */
	
	public Dimension getPreferredSize(){
		return dimension;
	}
}
