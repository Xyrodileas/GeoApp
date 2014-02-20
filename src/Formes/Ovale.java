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
     * @param ordre
     * @param id
     * @param xRecu
     * @param yRecu
     * @param rayonhRecu
     * @param rayonVRecu
     * Consequent:
     * 				Les elements recus seront affecter aux attributs de l'objet
     */
    public Ovale(int ordre,int id,int xRecu, int yRecu, int rayonhRecu,int rayonVRecu){


        super(ordre,id,Math.abs(Math.PI*(rayonhRecu)*(rayonVRecu)), Color.red,"Ovale",3); //fait appel a la classe mere
        centreX = xRecu;
        centreY = yRecu;
        rayonH = rayonhRecu;
        rayonV = rayonVRecu;
    }

    // ACCESSEURS
    /**
     * Methode :  getCentreX()
     * Methode qui retourne 
     * le centre X de Ovale
     * @return (int) centreX
     */
    public int getCentreX() {
        return centreX;
    }
    
    /**
     * Methode : getCentreY()
     * Methode qui retourne 
     * le centre Y de Ovale
     * @return (int) centreY
     */
    public int getCentreY() {
        return centreY;
    }
    /**
     *  Methode : getCentreY()
     *  Methode qui retourne
     *   le rayonH de Ovale
     * @return (int) rayonH
     */
    public int getRayonH() {
        return rayonH;
    }

    /**
     * Methode : getRayonV()
     * Methode qui retourne
     *  le rayonV de Ovale
     * @return (int) rayonV
     */
    public int getRayonV() {
        return rayonV;
    }

    /**
     * Methode : getIDLogger()
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
        g.fillOval(centreX, centreY, rayonH, rayonV);
        g.setColor(Color.BLACK);
        g.fillOval(centreX, centreY, rayonH, rayonV);
        g.setColor(Color.GREEN);
        g.drawLine(centreX, centreY, centreX+rayonH, centreY+rayonV);
        g.setColor(Color.CYAN);
        g.drawRect(centreX, centreY, centreX+rayonH-centreX, centreY+rayonV-centreY);
    }

    /**
     * Methode : firstx()
     * Permet de retourner la 
     * premier coordonée x 
     * @return (int) x
     */
    public int firstx(){
        return centreX;
    }
    
    
    
    /**
     * Methode : lastx()
     * Permet de retourner la 
     * dernière coordonée x
     * @return (int) x
     */
    public int lastx(){
        return centreX+rayonH;
    }
    
    
    
    /**
     * Methode : firsty()
     * Permet de retourner la 
     * premier coordonée y 
     * @return (int) y
     */
    public int firsty(){
        return centreY;
    }
    
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonée y
     * @return: (int) y
     */
    public int lasty(){
        return centreY+rayonV;
    }

    /**
     *  Methode : getHauteur()
     *  Permet de retourner la hauteur
     *  @return (int) hauteur
     */
    public int getHauteur() {
        return rayonV*2;
    }

    /**
     *  Methode :getLargeur()
     *  Permet de retourner la largeur
     *  @return (int) largeur
     */
    public int getLargeur(){
        return rayonH*2;
    }

    /**
     * Methode : newPosition
     * Permet de corriger l'affichage des formes sur le panneau
     * modification des coordonne de la formes selon celle d'avant
     * @param x2 formes precedente
     * @param y2 formes precedente
     */
    public void newPosition(int x2, int y2){
        // On attribut les coordonnÃ©es du centre
        this.centreX = x2 + this.rayonH;
        this.centreY = y2 + this.rayonV;
    }
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
    public double getDistanceMax(){
        if(rayonH > rayonV)
            return rayonH;
        else
            return rayonV;
    }
}