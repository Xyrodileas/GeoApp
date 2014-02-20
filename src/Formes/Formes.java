package Formes; /******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: Formes.Formes.java
Date créé: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/  
import java.awt.*;


/**
 * Classe m�re : Formes.Formes
 * 
 * @author Aissou Idriss
 * @author AISI01088901
 *
 */
public abstract class Formes {
	
		//ATTRIBUTS DE LA CLASSE FORME
	
		protected Color couleur;	//chaque couleur est affecte a un type de forme particulier
		protected String nomForme;	//retient le nom de la forme
		private int idlog;			//retient l'id de la forme
		private double aire;		//permet de retenir l'aire de la forme
		private int classement1;	//Les formes ont un code selon leur type
		private int ordreArrive;  	//Permet de savoir l'ordre d'arrive des formes
		
		/**
		 * Constructeur de Formes.Formes
		 * Constructeur par copie d'attributs
		 * 
		 * @param ordreDarriveRecu
		 * @param id
		 * @param aireRecu
		 * @param couleurRecu
		 * @param nomRecu
		 * @param classRecu
		 *     Consequent:
         * 			la couleur recu est affectee a l'attribut couleur de la forme
         * 			ordreDarriveRecu recu est affecte a l'attribut ordreArrive
         * 			id recu est affectee a l'attribut id de la forme
         * 			aire recu est affectee a l'attribut aire de la forme
         *			classement1 recu est affectee a l'attribut classement1 de la forme
         * 
		 */
		public Formes(int ordreDarriveRecu,int id,double aireRecu, Color couleurRecu, String nomRecu,int classRecu){
			couleur=couleurRecu;
			nomForme=nomRecu;
			idlog=id;
			aire=aireRecu;
			classement1=classRecu;
			ordreArrive=ordreDarriveRecu;
			
			
		}
		
		// ACCESSEURS
		/**
		 * Methode : getNom()
		 * Elle permet de retourner 
		 * la couleur de l'objet
		 * @return (Color) couleur
		 */
		public Color getCouleur() {
			return couleur;
		}
		
		/**
		 * Methode: getNom()
		 * Elle permet de retourner 
		 * le nom de la forme
		 * @return (String) nom de la Forme
		 */
		public String getNom(){
			return nomForme;
		}
		
		/**
		 * Methode: getIDLogger()
		 * Retourne l'Id de la Forme
		 * @return (int)
		 */
		public int getIDLogger(){

			return idlog;

		}
		
		/**
		 * Methode: getAire()
		 * Retourne l'aire de la Forme
		 * @return double
		 */
		public double getAire(){
			return aire;
		}
		
		/**
		 * Methode: getNumeroClassement1()
		 * Permet de retourner le type de la forme
		 * selon sa codification
		 * @return (int) classement1
		 */
		public int getNumeroClassement1(){
			return classement1;
		}
		
		/**
		 * Methode : getOrdreArriveForme()
		 * Retourne le num�ro d'arrive de la forme
		 * @return (int) ordre
		 */
		public int getOrdreArriveForme(){
			return ordreArrive;
		}
		
		
		
//******************************************************************************************
		//LES METHODES ABSTRAITES COMMUNES A TOUTES LES FORMES
		
		/**
		 * (abstract) draw
		 * Elle va permettre de dessiner la forme
		 * @param g
		 */
        public abstract void draw(Graphics g);
        
        /*
         *(abstract) Methode : firstx()
         * Permet de retourner la
         * premier coordon�e x
         */
        public abstract int firstx();
        
        /*
         * (abstract)Methode : lastx()
         * Permet de retourner la
         * derni�re coordon�e x
         */
        public abstract int lastx();
        
        /*
         * (abstract)Methode : firsty()
         * Permet de retourner la
         * premiere coordon�e
         */
        public abstract int firsty();
        /*
         * (abstract)Methode : lasty()
         * Permet de retourner la
         * derniere coordon�e y
         */
        public abstract int lasty();
        
        /**
         *   * (abstract)Methode : newPosition
         * Permet de corriger l'affichage des formes sur le panneau
         * modification des coordonne de la formes selon celle d'avant
         * @param x2 formes precedente
         * @param y2 formes precedente
         */
        public abstract void newPosition(int x2Recu, int y2Recu);
        
        /*
         * (abstract)Methode : getDistanceMax()
         * Permet de retourner la distance la plus grande de la forme 
         *
         */
        public abstract double getDistanceMax();
        
        /*
         * (abstract)Methode : getHauteur()
         * Permet de retourner la hauteur de la forme 
         *
         */
        public abstract int getHauteur();
        
        /*
         * (abstract)Methode :  getLargeur()
         * Permet de retourner la largeur de la forme 
         *
         */
    	public abstract int getLargeur();




	

	
	
	

	
	
	

}