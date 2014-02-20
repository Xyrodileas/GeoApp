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
<<<<<<< HEAD
     * @param ordre
     * @param id
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @param x1Recu
     * @param y1Recu
     * @param x2Recu
     * @param y2Recu
<<<<<<< HEAD
     * Consequent :
     * 				affecte les elements recu aux attributs de Rectangle
     */
=======
     *  Consequent :
     * 				affecte les elements recu aux attributs de Rectangle
     */

>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public Rectangle (int ordre,int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(ordre,id, Math.abs(((x2Recu)-(x1Recu))*((y2Recu)-(y1Recu))), Color.ORANGE,"Rectangle",1);
        x1 = x1Recu;
        y1 = y1Recu;
        x2 = x2Recu;
        y2 = y2Recu;

    }

    // ACCESSEURS
    /**
<<<<<<< HEAD
     * MEthode : getX1()
     * Methode qui permet de 
     * retourner le x1 de Rectangle
=======
     * Methode qui permet de retourner le x1 de Rectangle
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) x1
     */
    public int getX1() {
        return x1;
    }

    /**
<<<<<<< HEAD
     * MEthode : getY1()
     * Methode qui permet de
     * retourner le y1 de  Rectangle
=======
     * Methode qui permet de retourner le y1 de  Rectangle
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) y1
     */
    public int getY1() {
        return y1;
    }

    /**
<<<<<<< HEAD
     * MEthode : getX2()
     * Methode qui permet de
     *  retourner le x2 de  Rectangle
=======
     * Methode qui permet de retourner le x2 de  Rectangle
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) x2
     */
    public int getX2() {
        return x2;
    }

    /**
<<<<<<< HEAD
     * MEthode : getY2()
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * Methode qui permet de retourner le y2 de  Rectangle
     * @return (int) y2
     */
    public int getY2() {
        return y2;
    }

<<<<<<< HEAD
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
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public void draw(Graphics g){
        g.setColor(this.couleur);
        g.fillRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
    }
<<<<<<< HEAD

    /**
     * Methode : firstx()
     * Permet de retourner la 
     * premier coordonÈe x 
     * @return (int) x
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
     * Methode : firsty()
     * Permet de retourner la 
     * premier coordonÈe y 
     * @return (int) y
     */
    public int firsty(){
        return y1;
    }
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonÈe y
     * @return: (int) y
     */
=======
    public double getAir(){

        return Math.abs((x2-x1)*(y2-y1));
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
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int lasty(){
        return y2;
    }

<<<<<<< HEAD
    /**
     *  Methode : getHauteur()
     *  Permet de retourner la hauteur
     *  @return (int) hauteur
     */
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int getHauteur() {
        return x2-x1;
    }

<<<<<<< HEAD
    /**
     *  Methode :getLargeur()
     *  Permet de retourner la largeur
     *  @return (int) largeur
     */
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int getLargeur(){
        return y2-y1;
    }

<<<<<<< HEAD
    /**
     * Methode : newPosition
     * Permet de corriger l'affichage des formes sur le panneau
     * modification des coordonne de la formes selon celle d'avant
     * @param x2 formes precedente
     * @param y2 formes precedente
     */
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public void newPosition(int x2, int y2){
        // On calcul les longueurs du rectangle
        int tmp1 = this.x2-this.x1;
        int tmp2 = this.y2-this.y1;
        // On attribut les coordonn√©es de d√©part
        this.x1 = x2;
        this.y1 = y2;
        // On ajoute les longueur du rectangle aux points de d√©part
        this.x2 = this.x1+tmp1;
        this.y2 = this.y1+tmp2;
    }

<<<<<<< HEAD
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public double getDistanceMax(){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}

