package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Sous classe de Formes.Formes : classe Rectangle
 * @author Aissou Idriss
 *
 */
public class Rectangle extends Formes{

    // ATTRIBUTS DE RECTANGLE
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    /**
     * Constructeur de la classe Carre
     * Constructeur par copie d'attributs
     * @param ordre
     * @param id
     * @param x1Recu
     * @param y1Recu
     * @param x2Recu
     * @param y2Recu
     * Consequent :
     * 				affecte les elements recu aux attributs de Rectangle
     */
    public Rectangle (int ordre,int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(ordre,id, Math.abs(((x2Recu)-(x1Recu))*((y2Recu)-(y1Recu))), Color.ORANGE,"Rectangle",1);
        x1 = x1Recu;
        y1 = y1Recu;
        x2 = x2Recu;
        y2 = y2Recu;

    }

    // ACCESSEURS
    /**
     * MEthode : getX1()
     * Methode qui permet de 
     * retourner le x1 de Rectangle
     * @return (int) x1
     */
    public int getX1() {
        return x1;
    }

    /**
     * MEthode : getY1()
     * Methode qui permet de
     * retourner le y1 de  Rectangle
     * @return (int) y1
     */
    public int getY1() {
        return y1;
    }

    /**
     * MEthode : getX2()
     * Methode qui permet de
     *  retourner le x2 de  Rectangle
     * @return (int) x2
     */
    public int getX2() {
        return x2;
    }

    /**
     * MEthode : getY2()
     * Methode qui permet de retourner le y2 de  Rectangle
     * @return (int) y2
     */
    public int getY2() {
        return y2;
    }

    /**
     * Methode : getIDLogger
     * Retourne int idlogger
     * @return : (int) id
     */
    public int getIDLogger(){
        return super.getIDLogger();
    }
    
    
    /**
	 * Methode : draw()
	 * (abstract) draw
	 * Elle va permettre de 
	 * dessiner la forme
	 * @param g
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
     * Methode : firstx()
     * Permet de retourner la 
     * premier coordonée x 
     * @return (int) x
     */
    public int firstx(){
        return x1;
    }
    
    /**
     * Methode : lastx()
     * Permet de retourner la 
     * dernière coordonée x
     * @return (int) x2
     */
    public int lastx(){
        return x2;
    }
    
    /**
     * Methode : firsty()
     * Permet de retourner la 
     * premier coordonée y 
     * @return (int) y
     */
    public int firsty(){
        return y1;
    }
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonée y
     * @return: (int) y
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
    public void newPosition(int x2, int y2){
        // On calcul les longueurs du rectangle
        int tmp1 = this.x2-this.x1;
        int tmp2 = this.y2-this.y1;
        // On attribut les coordonnÃ©es de dÃ©part
        this.x1 = x2;
        this.y1 = y2;
        // On ajoute les longueur du rectangle aux points de dÃ©part
        this.x2 = this.x1+tmp1;
        this.y2 = this.y1+tmp2;
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

