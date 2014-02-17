package Formes;

//*************************************************************

import java.awt.*;

/**
 * Sous classe de Formes.Formes : classe Ovale
 * @author Aissou Idriss
 *
 */
public class Ovale extends Formes  {

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


        super(id,Math.abs(Math.PI*(rayonhRecu)*(rayonVRecu)), Color.red,"Ovale",3); //fait appel a la classe mere
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

        return Math.abs(Math.PI*rayonH*rayonV);
    }
    public int firstx(){
        return centreX-rayonH;
    }
    public int lastx(){
        return centreX+rayonH;
    }
    public int firsty(){
        return centreY-rayonH;
    }
    public int lasty(){
        return centreY+rayonV;
    }
    public void newPosition(int x2, int y2){
        // On attribut les coordonnées du centre
        this.centreX = x2 + this.rayonH;
        this.centreY = y2 + this.rayonV;
        //this.centreX =(int) Math.round(x2+Math.sqrt(rayonH*rayonH+rayonH*rayonH));
        //this.centreY = (int) Math.round(y2+Math.sqrt(rayonV*rayonV+rayonV*rayonV));
    }
    public double getDistanceMax(){
        if(rayonH > rayonV)
            return rayonH;
        else
            return rayonV;
    }
}