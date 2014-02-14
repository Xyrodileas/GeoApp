/******************************************************
Cours:  LOG121
Projet: Laboratoire1 
Nom du fichier: Formes.java
Date créé: 20/01/1014
*******************************************************
Historique des modifications
*******************************************************
*@author Aissou Idriss
30/01/2014 Version personnelle
*******************************************************/  
import java.awt.*;


/**
 * Classe m�re : Formes
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
		
		/**
		 * Constructeur de Formes
		 * Constructeur par copie d'attributs
		 * @param couleurRecu  (une couleur)
		 * 
		 * Consequent:
		 * 			la couleur recu est affect�e a l'attribut couleur
		 */
		public Formes(int id,Color couleurRecu,String nomRecu){
			couleur=couleurRecu;
			nomForme=nomRecu;
			idlog=id;
			
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
		public int getIDLogger(){
			return idlog;
		}
        public abstract void draw(Graphics g);
        public abstract double getAir();
        public abstract int firstx();
        public abstract int lastx();
        public abstract int firsty();
        public abstract int lasty();
        public abstract void newPosition(int x2, int y2);


//*************************************************************
	/**
	 * Sous classe de Formes : classe Ovale	
	 * @author Aissou Idriss
	 *
	 */
	public static class Ovale extends Formes  {
		
		//ATTRIBUTS DE LA CLASSE OVALE permet par la suite de dessiner la forme
		private int centreX; 
		private int centreY; 
		private int rayonH; 
		private int rayonV;
		
		/**
		 * Constructeur de Ovale
		 * Constructeur par copie d'attributs de Oval
		 * @param xRecu
		 * @param yRecu
		 * @param rayonhRecu
		 * @param rayonVRecu
		 * 
		 * Consequent:
		 * 				Les elements recus seront affecter aux attributs de l'objet
		 */
		public Ovale(int id,int xRecu, int yRecu, int rayonhRecu,int rayonVRecu){
			
			super(id,Color.red,"Ovale"); //fait appel a la classe mere
			
			centreX = xRecu;
			centreY = yRecu;
			rayonH = rayonhRecu;
			rayonV = rayonVRecu;
			
		}

		// ACCESSEURS
		/**
		 * Methode qui retourne le centre X de Ovale
		 * @return (int) centreX
		 */
		public int getCentreX() {
			return centreX;
		}
		/**
		 * Methode qui retourne le centre Y de Ovale
		 * @return (int) centreY
		 */
		public int getCentreY() {
			return centreY;
		}
		/**
		 *  Methode qui retourne le rayonH de Ovale
		 * @return (int) rayonH
		 */
		public int getRayonH() {
			return rayonH;
		}
		
		/**
		 * Methode qui retourne le rayonV de Ovale
		 * @return (int) rayonV
		 */
		public int getRayonV() {
			return rayonV;
		}

		/**
		 * Retourne int idlogger
		 * @return : int id
		 */
		public int getIDLogger(){
			return super.getIDLogger();
		}
        public void draw(Graphics g){
            g.fillOval(centreX, centreY, rayonH, rayonV);
            g.setColor(Color.BLACK);
            g.fillOval(centreX, centreY, rayonH, rayonV);
            g.setColor(Color.GREEN);
            g.drawLine(centreX, centreY, centreX+rayonH, centreY+rayonV);
            g.setColor(Color.CYAN);
            g.drawRect(centreX, centreY, centreX+rayonH-centreX, centreY+rayonV-centreY);
        }
        public double getAir(){

            return Math.PI*rayonH*rayonV;
        }
        public int firstx(){
            return centreX;
        }
        public int lastx(){
            return centreX+rayonH;
        }
        public int firsty(){
            return centreY;
        }
        public int lasty(){
            return centreY+rayonV;
        }
        public void newPosition(int x2, int y2){
            this.centreX = x2;
            this.centreY = y2;
        }
	}

	
	
//*************************************************************	
	/**
	 * Sous classe de Formes : classe Cercle
	 * @author Aissou Idriss
	 *
	 */
	public static class Cercle extends Formes {
		
		//ATTRIBUTS DE CERCLE
		private int centreX; 
		private int centreY; 
		private int rayon;
		
		/**
		 * Constructeur de la classe Cercle
		 * Constructeur par copie d'attributs
		 * @param centreXRecu (int)
		 * @param centreYRecu	(int)
		 * @param rayonREcu		(int)
		 * 
		 * Consequent :
		 * 				affecte les elements recu aux attributs 
		 */
		public Cercle(int id,int centreXRecu,int centreYRecu,int rayonREcu){
			super(id,Color.blue,"Cercle");
			centreX=centreXRecu;
			centreY=centreYRecu;
			rayon=rayonREcu;
		}

		// ACCESSEURS
		/**
		 * Methode qui retourne le centreX de Cercle
		 * @return (int) centreX
		 */
		public int getCentreX() {
			return centreX;
		}
		
		/**
		 * Methode qui retourne le centreY de Cercle
		 * @return (int) centreY
		 */
		public int getCentreY() {
			return centreY;
		}
		
		/**
		 * methode qui retourne le rayon de Cercle
		 * @return (int) rayon
		 */
		public int getRayon() {
			return rayon;
		}
		
		/**
		 * Retourne int idlogger
		 * @return : int id
		 */
		public int getIDLogger(){
			return super.getIDLogger();
		}

        public void draw(Graphics g){
            g.setColor(this.couleur);
            g.fillOval(centreX, centreY, rayon, rayon);
            g.setColor(Color.BLACK);
            g.drawOval(centreX, centreY, rayon, rayon);
            g.setColor(Color.GREEN);
            g.drawLine(centreX, centreY, centreX+rayon, centreY+rayon);
            g.setColor(Color.CYAN);
            g.drawRect(centreX, centreY, centreX+rayon-centreX, centreY+rayon-centreY);

        }
        public double getAir(){

            return Math.PI*rayon*rayon;
        }
        public int firstx(){
            return centreX;
        }
        public int lastx(){
            return centreX+rayon;
        }
        public int firsty(){
            return centreY;
        }
        public int lasty(){
            return centreY+rayon;
        }
        public void newPosition(int x2, int y2){
            this.centreX = x2;
            this.centreY = y2;
        }
	}
	
	
	
	
//*************************************************************	
	/**
	 * Sous classe de Formes : classe Carre
	 * @author Aissou Idriss
	 *
	 */
	public static class Carre extends Formes {
		
		// ATTRIBUTS DE LA CLASSE CARRE
		private int x1; 
		private int y1; 
		private int x2; 
		private int y2;
		
		/**
		 * Constructeur de la classe Carre
		 * Constructeur par copie d'attributs
		 * @param x1Recu
		 * @param y1Recu
		 * @param x2Recu
		 * @param y2Recu
		 * 
		 *  Consequent :
		 * 				affecte les elements recu aux attributs de Carre
		 */
		public Carre(int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
			super(id,Color.green,"Carre");
			x1 = x1Recu;
			y1 = y1Recu;
			x2 = x2Recu;
			y2 = y2Recu;
			
		}
		
		// ACCESSEURS
		/**
		 * Methode qui permet de retourner le x1 de Carre
		 * @return (int) x1
		 */
		public int getX1() {
			return x1;
		}
		
		/**
		 * Methode qui permet de retourner le y1 de Carre
		 * @return (int) y1
		 */
		public int getY1() {
			return y1;
		}
		
		/**
		 * Methode qui permet de retourner le x2 de Carre
		 * @return (int) x2
		 */
		public int getX2() {
			return x2;
		}
	
		/**
		 * Methode qui permet de retourner le y2 de Carre
		 * @return (int) y2
		 */
		public int getY2() {
			return y2;
		}
		
		/**
		 * Retourne int idlogger
		 * @return : int id
		 */
		public int getIDLogger(){
			return super.getIDLogger();
		}

        public void draw(Graphics g){
            g.setColor(this.couleur);
            g.fillRect(x1, y1, x2, y2);
            g.setColor(Color.BLACK);
            g.drawRect(x1, y1, x2, y2);
            g.setColor(Color.GREEN);
            g.drawLine(x1, y1, x2, y2);
        }
        public double getAir(){

            return Math.PI*(x2-x1)*(x2-x1);
        }
        public int firstx(){
            return x1;
        }
        public int lastx(){
            return x2;
        }
        public int firsty(){
            return y1;
        }
        public int lasty(){
            return y2;
        }
        public void newPosition(int x2, int y2){
            this.x2 = x2+(this.x2-this.x1);
            this.y2 = y2+(this.y2-this.y1);
            this.x1 = x2;
            this.y1 = y2;
        }
	}	
	
	
	
	
//*************************************************************	
	/**
	 * Sous classe de Formes : classe Rectangle
	 * @author Aissou Idriss
	 *
	 */
	public static class Rectangle extends Formes{
		
		// ATTRIBUTS DE RECTANGLE
		private int x1;
		private int y1;
		private int x2; 
		private int y2;
		
		/**
		 * Constructeur de la classe Carre
		 * Constructeur par copie d'attributs
		 * @param x1Recu
		 * @param y1Recu
		 * @param x2Recu
		 * @param y2Recu
		 *  Consequent :
		 * 				affecte les elements recu aux attributs de Rectangle
		 */
	
		public Rectangle (int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
			super(id,Color.ORANGE,"Rectangle");
			x1 = x1Recu;
			y1 = y1Recu;
			x2 = x2Recu;
			y2 = y2Recu;
			
		}

		// ACCESSEURS
		/**
		 * Methode qui permet de retourner le x1 de Rectangle
		 * @return (int) x1
		 */
		public int getX1() {
				return x1;
			}
				
		/**
		 * Methode qui permet de retourner le y1 de  Rectangle
		 * @return (int) y1
		 */
		public int getY1() {
				return y1;
				}
				
		/**
		 * Methode qui permet de retourner le x2 de  Rectangle
		 * @return (int) x2
		 */
		public int getX2() {
				return x2;
				}
			
		/**
		* Methode qui permet de retourner le y2 de  Rectangle
		* @return (int) y2
		*/
		public int getY2() {
				return y2;
			}
		
		/**
		 * Retourne int idlogger
		 * @return : int id
		 */
		public int getIDLogger(){
			return super.getIDLogger();
		}

        public void draw(Graphics g){
            g.setColor(this.couleur);
            g.fillRect(x1, y1, x2, y2);
            g.setColor(Color.BLACK);
            g.drawRect(x1, y1, x2, y2);
            g.setColor(Color.GREEN);
            g.drawLine(x1, y1, x2, y2);
        }
        public double getAir(){

            return Math.PI*(x2-x1)*(y2-y1);
        }
        public int firstx(){
            return x1;
        }
        public int lastx(){
            return x2;
        }
        public int firsty(){
            return y1;
        }
        public int lasty(){
            return y2;
        }
        public void newPosition(int x2, int y2){
            this.x2 = x2+(this.x2-this.x1);
            this.y2 = y2+(this.y2-this.y1);
            this.x1 = x2;
            this.y1 = y2;
        }

	}
	
	
	
//*************************************************************	
	/**
	 * Sous classe de Formes : classe Ligne
	 * @author Aissou Idriss
	 *
	 */
	public static class Ligne extends Formes {
		
		//ATTRIBUTS DE LA CLASSE LIGNE
		private int x1;
		private int y1; 
		private int x2; 
		private int y2;
		
		/**
		 * Constructeur de la classe Carre
		 * Constructeur par copie d'attributs
		 * @param x1Recu
		 * @param y1Recu
		 * @param x2Recu
		 * @param y2Recu
		 * Consequent :
		 * 				affecte les elements recu aux attributs de Ligne
		 */
		public  Ligne(int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
			super(id,Color.BLACK,"Ligne");
			x1 = x1Recu;
			y1 = y1Recu;
			x2 = x2Recu;
			y2 = y2Recu;
			
		}
		
		// ACCESSEURS
		/**
		 * Methode qui permet de retourner le x1 de Ligne
		 * @return (int) x1
		 */
		public int getX1() {
				return x1;
			}
				
		/**
		 * Methode qui permet de retourner le y1 de Ligne
		 * @return (int) y1
		 */
		public int getY1() {
				return y1;
				}
				
		/**
		 * Methode qui permet de retourner le x2 de  Ligne
		 * @return (int) x2
		 */
		public int getX2() {
				return x2;
				}
			
		/**
		* Methode qui permet de retourner le y2 de  Ligne
		* @return (int) y2
		*/
		public int getY2() {
				return y2;
			}
		
		/**
		 * Retourne int idlogger
		 * @return : int id
		 */
		public int getIDLogger(){
			return super.getIDLogger();
		}

        public void draw(Graphics g){
            g.setColor(this.couleur);
            g.drawLine(x1, y1, x2, y2);
            g.setColor(Color.BLACK);
            g.setColor(Color.GREEN);
            g.drawRect(x1, y1, x2-x1, y2-y1);
        }


        public double getAir(){

            return x2-x1;
        }
        public int firstx(){
            return x1;
        }
        public int lastx(){
            return x2;
        }
        public int firsty(){
            return y1;
        }
        public int lasty(){
            return y2;
        }
        public void newPosition(int x2, int y2){
            this.x2 = x2+(this.x2-this.x1);
            this.y2 = y2+(this.y2-this.y1);
            this.x1 = x2;
            this.y1 = y2;
        }
	}

	
}

