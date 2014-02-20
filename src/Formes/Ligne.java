package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Sous classe de Formes.Formes : classe Ligne
 * @author Aissou Idriss
 *
 */
public class Ligne extends Formes {

    //ATTRIBUTS DE LA CLASSE LIGNE
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
     * Consequent :
     * 				affecte les elements recu aux attributs de Ligne
     */
    public  Ligne(int ordre,int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(ordre,id,Math.abs((x2Recu)-(x1Recu)) ,Color.BLACK,"Ligne",4);
        if(x1Recu < x2Recu){
            x1 = x1Recu;
            x2 = x2Recu;
            y1 = y1Recu;
            y2 = y2Recu;
        }
        else{
            x2 = x1Recu;
            x1 = x2Recu;
            y2 = y1Recu;
            y1 = y2Recu;
        }


    }

    // ACCESSEURS
    /**
<<<<<<< HEAD
     * Methode : getX1()
     * Methode qui permet de
     *  retourner le x1 de Ligne
=======
     * Methode qui permet de retourner le x1 de Ligne
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) x1
     */
    public int getX1() {
        return x1;
    }

    /**
<<<<<<< HEAD
     * Methode : getY1()
     * Methode qui permet de retourner
     *  le y1 de Ligne
=======
     * Methode qui permet de retourner le y1 de Ligne
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) y1
     */
    public int getY1() {
        return y1;
    }

    /**
<<<<<<< HEAD
     * Methode : getX2()
     * Methode qui permet de
     *  retourner le x2 de  Ligne
=======
     * Methode qui permet de retourner le x2 de  Ligne
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) x2
     */
    public int getX2() {
        return x2;
    }

    /**
<<<<<<< HEAD
     * Methode : getY2()
     * Methode qui permet de 
     * retourner le y2 de  Ligne
=======
     * Methode qui permet de retourner le y2 de  Ligne
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) y2
     */
    public int getY2() {
        return y2;
    }

<<<<<<< HEAD
    /**
     * Methode : getY2()
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
        g.drawLine(x1, y1, x2, y2);
        g.setColor(Color.BLACK);
        g.setColor(Color.GREEN);
<<<<<<< HEAD
        g.drawRect(x1, y1, x2-x1, y2-y1);
    }

    /**
     * Methode : firstx()
     * Permet de retourner la 
     * premier coordonée x 
     * @return (int) x
     */
    public int firstx(){
        if(y2-y1 < 0)
            return x2;
        else
            return x1;
    }
    
    
    /**
     * Methode : lastx()
     * Permet de retourner la 
     * dernière coordonée x
     * @return (int) x2
     */
=======
        if(y2-y1 < 0)
            g.drawRect(x1, y2, Math.abs(x2-x1), Math.abs(y2-y1));
        else
            g.drawRect(x1, y1, Math.abs(x2-x1), Math.abs(y2-y1));
    }


    public double getAir(){
        return Math.abs(x2-x1);
    }
    public int firstx(){
            return x1;

    }
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int lastx(){
        if(y2-y1 < 0)
            return x1;
        else
            return x2;
    }
<<<<<<< HEAD
    
    /**
     * Methode : firsty()
     * Permet de retourner la 
     * premier coordonée y 
     * @return (int) y
     */
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int firsty(){
        if(y2-y1 < 0)
            return y2;
        else
            return y1;
    }
<<<<<<< HEAD
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonée y
     * @return: (int) y
     */
    public int lasty(){
        if(y2-y1 < 0)
            return y1;
        else
            return y2;
    }

    /**
     *  Methode : getHauteur()
     *  Permet de retourner la hauteur
     *  @return (int) hauteur
     */
    public int getHauteur() {
        return Math.abs(x2-x1);
    }

    /**
     *  Methode :getLargeur()
     *  Permet de retourner la largeur
     *  @return (int) largeur
     */
=======
    public int lasty(){
        if(y2-y1 < 0)
            return y2;
        else
            return y1;
    }

    public int getHauteur() {
        return x2-x1;
    }

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
    public void newPosition(int x2, int y2){
        // On vÃ©rifie le sens de la ligne
        if(y2-y1 < 0)//Si c'est de bas en haut
        {
            this.x1 = x2+(this.x2-this.x1);
            this.y1 = y2+(this.y2-this.y1);
            this.x2 = x2;
            this.y2 = y2;
        }
        else{ // Si c'est de haut en bas
            this.x2 = x2+(this.x2-this.x1);
            this.y2 = y2+(this.y2-this.y1);
            this.x1 = x2;
            this.y1 = y2;
        }
    }
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
=======
    public void newPosition(int x2, int y2){
        // On vÃ©rifie le sens de la ligne
        int tmpx = Math.abs(this.x2-this.x1);
        int tmpy = +Math.abs(this.y2-this.y1);
        if(y2-y1 < 0)//Si c'est de bas en haut
        {
            this.x1 = x2;
            this.y2 = y2;
            this.x2 = this.x1 + tmpx;
            this.y1 = this.y2 +tmpy;

        }
        else{ // Si c'est de haut en bas
            this.x1 = x2;
            this.y1 = y2;
            this.x2 = this.x1+tmpx;
            this.y2 = this.y1+tmpy;

        }
    }
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public double getDistanceMax(){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

