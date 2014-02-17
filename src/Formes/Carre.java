package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Sous classe de Formes.Formes : classe Carre
 * @author Aissou Idriss
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
    public Carre(int id,int x1Recu,int y1Recu,int x2Recu, int y2Recu){
        super(id,Math.abs(((x2Recu)-(x1Recu))*((y2Recu)-(y1Recu))), Color.green,"Carre",0);
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
        g.fillRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.BLACK);
        g.drawRect(x1, y1, x2-x1, y2-y1);
        g.setColor(Color.GREEN);
        g.drawLine(x1, y1, x2, y2);
    }
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
    public int lasty(){
        return y2;
    }
    public void newPosition(int x2, int y2){
        // On calcul la longueur du carré
        int tmp = this.x2-this.x1;
        // On attribut les nouvelles coordonnées de départ
        this.x1 = x2;
        this.y1 = y2;
        // On attribut les coordonnée de départ + la longueur du carré
        this.x2 = this.x1+tmp;
        this.y2 = this.y1+tmp;
    }
    public double getDistanceMax(){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}