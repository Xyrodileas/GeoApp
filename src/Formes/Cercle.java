package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Sous classe de Formes.Formes : classe Cercle
 * @author Aissou Idriss
 *
 */
public class Cercle extends Formes {

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
        super(id, Color.blue,"Cercle");
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

        return Math.abs(Math.PI*rayon*rayon);
    }
    public int firstx(){
        return centreX-rayon;
    }
    public int lastx(){
        return centreX+rayon;
    }
    public int firsty(){
        return centreY-rayon;
    }
    public int lasty(){
        return centreY+rayon;
    }
    public void newPosition(int x2, int y2){
        this.centreX = x2+40;
        this.centreY = y2+40;
    }
}