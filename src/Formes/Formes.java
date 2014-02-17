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
	
		//ATTRIBUTS
		protected Color couleur;
		protected String nomForme;
		private int idlog;
		private double aire;
		private int classement1;
		/**
		 * Constructeur de Formes.Formes
		 * Constructeur par copie d'attributs
         * @param couleurRecu  (une couleur)
         *
         * Consequent:
         * 			la couleur recu est affect�e a l'attribut couleur
         */
		public Formes(int id,double aireRecu, Color couleurRecu, String nomRecu,int classRecu){
			couleur=couleurRecu;
			nomForme=nomRecu;
			idlog=id;
			aire=aireRecu;
			classement1=classRecu;
			
			
		}
		
		// ACCESSEURS
		/**
		 * Methode qui permet de retourner la couleur de l'objet
		 * @return (Color) couleur
		 */
		public Color getCouleur() {
			return couleur;
		}
		
		/**
		 * Methode qui permet de retourner le nom de la forme
		 * @return (String) nom Forme
		 */
		public String getNom(){
			return nomForme;
		}
		/**
		 * Retourne l'Id de la Forme
		 * @return int
		 */
		public int getIDLogger(){
			return idlog;
		}
		/**
		 * Retourne l'aire de la Forme
		 * @return double
		 */
		public double getAire(){
			return aire;
		}
		public int getNumeroClassement1(){
			return classement1;
		}
		
		
		
        public abstract void draw(Graphics g);
        public abstract double getAir();
        public abstract int firstx();
        public abstract int lastx();
        public abstract int firsty();
        public abstract int lasty();
        public abstract void newPosition(int x2, int y2);
        public abstract double getDistanceMax();




	

	
	
	

	
	
	

}