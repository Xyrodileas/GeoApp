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
     * @param x1Recu
     * @param y1Recu
     * @param x2Recu
     * @param y2Recu
     * Consequent :
     * 				affecte les elements recu aux attributs de Ligne
     */
    public  Ligne(int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(id,Math.abs((x2Recu)-(x1Recu)) ,Color.BLACK,"Ligne",4);
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
        return Math.abs(x2-x1);
    }
    public int firstx(){
        if(y2-y1 < 0)
            return x2;
        else
            return x1;
    }
    public int lastx(){
        if(y2-y1 < 0)
            return x1;
        else
            return x2;
    }
    public int firsty(){
        if(y2-y1 < 0)
            return y2;
        else
            return y1;
    }
    public int lasty(){
        if(y2-y1 < 0)
            return y1;
        else
            return y2;
    }
    public void newPosition(int x2, int y2){
        // On vérifie le sens de la ligne
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
    public double getDistanceMax(){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}

