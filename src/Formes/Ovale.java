package Formes;

//*************************************************************

import java.awt.*;


/**
 * Classe : Ovale
 * Heritage : Formes
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
<<<<<<< HEAD
     * @param ordre
     * @param id
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @param xRecu
     * @param yRecu
     * @param rayonhRecu
     * @param rayonVRecu
<<<<<<< HEAD
=======
     *
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
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
<<<<<<< HEAD
     * Methode :  getCentreX()
     * Methode qui retourne 
     * le centre X de Ovale
=======
     * Methode qui retourne le centre X de Ovale
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) centreX
     */
    public int getCentreX() {
        return centreX;
    }
<<<<<<< HEAD
    
    /**
     * Methode : getCentreY()
     * Methode qui retourne 
     * le centre Y de Ovale
=======
    /**
     * Methode qui retourne le centre Y de Ovale
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) centreY
     */
    public int getCentreY() {
        return centreY;
    }
    /**
<<<<<<< HEAD
     *  Methode : getCentreY()
     *  Methode qui retourne
     *   le rayonH de Ovale
=======
     *  Methode qui retourne le rayonH de Ovale
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) rayonH
     */
    public int getRayonH() {
        return rayonH;
    }

    /**
<<<<<<< HEAD
     * Methode : getRayonV()
     * Methode qui retourne
     *  le rayonV de Ovale
=======
     * Methode qui retourne le rayonV de Ovale
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) rayonV
     */
    public int getRayonV() {
        return rayonV;
    }

<<<<<<< HEAD
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
     * premier coordonÈe x 
     * @return (int) x
     */
    public int firstx(){
        return centreX;
    }
    
    
    
    /**
     * Methode : lastx()
     * Permet de retourner la 
     * derniËre coordonÈe x
     * @return (int) x
     */
    public int lastx(){
        return centreX+rayonH;
    }
    
    
    
    /**
     * Methode : firsty()
     * Permet de retourner la 
     * premier coordonÈe y 
     * @return (int) y
     */
    public int firsty(){
        return centreY;
    }
    
    
    /**
     * Methode : lasty()
     * Permet de retourner la 
     * derniere coordonÈe y
     * @return: (int) y
     */
=======
    public void draw(Graphics g){
        g.setColor(Color.DARK_GRAY);
        g.fillOval(centreX-rayonH, centreY-rayonV, rayonH*2, rayonV*2);
        g.setColor(Color.GREEN);
        g.drawLine(centreX-rayonH, centreY-rayonV, centreX+rayonH, centreY+rayonV);
        g.setColor(Color.CYAN);
        g.drawRect(centreX-rayonH, centreY-rayonV, rayonH*2, rayonV*2);
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
        return centreY-rayonV;
    }
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int lasty(){
        return centreY+rayonV;
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
        return rayonV*2;
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
        return rayonH*2;
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
        // On attribut les coordonn√©es du centre
        this.centreX = x2 + this.rayonH;
        this.centreY = y2 + this.rayonV;
<<<<<<< HEAD
    }
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
=======
        //this.centreX =(int) Math.round(x2+Math.sqrt(rayonH*rayonH+rayonH*rayonH));
        //this.centreY = (int) Math.round(y2+Math.sqrt(rayonV*rayonV+rayonV*rayonV));
    }
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public double getDistanceMax(){
        if(rayonH > rayonV)
            return rayonH;
        else
            return rayonV;
    }
}