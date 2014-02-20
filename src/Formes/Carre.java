package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Classe : Carre
 * Heritage : Formes
 *
 */
public class Carre extends Formes {

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
    public Carre(int ordre,int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(ordre,id,Math.abs(((x2Recu)-(x1Recu))*((y2Recu)-(y1Recu))), Color.green,"Carre",0);
        x1 = x1Recu;
        y1 = y1Recu;
        x2 = x2Recu;
        y2 = y2Recu;

    }

    // ACCESSEURS
    /**
     * Methode :  getX1()
     * Methode qui permet 
     * de retourner le x1 de Carre
     * @return (int) x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * Methode :  gety1()
     * Methode qui permet de 
     * retourner le y1 de Carre
     * @return (int) y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * Methode :  getX2()
     * Methode qui permet 
     * de retourner le x2 de Carre
     * @return (int) x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * Methode :  getY2
     * Methode qui permet de 
     * retourner le y2 de Carre
     * @return (int) y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * Methode : getIDLogger()
     * permet de Retourner
     * le int idlogger
     * @return : (int) id
     */
    public int getIDLogger(){
        return super.getIDLogger();
    }

	/**
	 * Methode : draw()
	 * (abstract) draw
	 * Elle va permettre de dessiner la forme
	 * @param (g) graphics
	 */
    public void draw(Graphics g){
        g.setColor(this.couleur);
        g.fillRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
    }
    
    /**
     * Methode :  getAir()
     * Permet de retourner l'aire
     * de la forme
     * @return (int) aire
      */
    public double getAir(){
        return Math.abs((x2-x1)*(y2-y1));
    }
    
    /**
     * Methode : firstx()
     * Permet de retourner la 
     * premier coordonÈe x 
     * @return (int) x1
      */
    public int firstx(){
        return x1;
    }
    
    /**
     * Methode : lastx()
     * Permet de retourner la 
     * derniËre coordonÈe x
     * @return (int) x2
     */
    public int lastx(){
        return x2;
    }
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * premiere coordonÈe y
     * @return: (int) y1
     */
    public int firsty(){
        return y1;
    }
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonÈe y
     * @return: (int) y1
     */
    public int lasty(){
        return y2;
    }

    /**
     *  Methode : getHauteur()
     *  Permet de retourner la hauteur
     *  @return (int) hauteur
     */
    public int getHauteur() {
        return x2-x1;
    }
    
    /**
     *  Methode :getLargeur()
     *  Permet de retourner la largeur
     *  @return (int) largeur
     */
    public int getLargeur(){
        return y2-y1;
    }

    /**
     * Methode : newPosition
     * Permet de corriger l'affichage des formes sur le panneau
     * modification des coordonne de la formes selon celle d'avant
     * @param x2 formes precedente
     * @param y2 formes precedente
     */
    public void newPosition(int x2Recu, int y2Recu){
        // On calcul la longueur du carr√©
        int tmp = this.x2-this.x1;
        // On attribut les nouvelles coordonn√©es de d√©part
        this.x1 = x2Recu;
        this.y1 = y2Recu;
        // On attribut les coordonn√©e de d√©part + la longueur du carr√©
        this.x2 = this.x1+tmp;
        this.y2 = this.y1+tmp;
    }
    
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
    public double getDistanceMax(){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}