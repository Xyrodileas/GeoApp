package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
<<<<<<< HEAD
 * Classe : Cercle
=======
 * Classe : Carre
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
 * Heritage : Formes
 *
 */
public class Cercle extends Formes {

    //ATTRIBUTS DE CERCLE
    private int centreX;
    private int centreY;
<<<<<<< HEAD
    private int rayon;
=======
    private final int rayon;
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e

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
    public Cercle(int ordre,int id,int centreXRecu,int centreYRecu,int rayonREcu){
        super(ordre,id, Math.abs(Math.PI*(rayonREcu)*(rayonREcu)), Color.blue,"Cercle",2);
        centreX=centreXRecu;
        centreY=centreYRecu;
        rayon=rayonREcu;
    }

    // ACCESSEURS
    /**
<<<<<<< HEAD
     * Methode : getCentreX()
     * Methode qui retourne 
     * le centreX de Cercle
=======
     * Methode qui retourne le centreX de Cercle
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) centreX
     */
    public int getCentreX() {
        return centreX;
    }

    /**
<<<<<<< HEAD
     * Methode : getCentreY()
     * Methode qui retourne 
     * le centreY de Cercle
=======
     * Methode qui retourne le centreY de Cercle
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * @return (int) centreY
     */
    public int getCentreY() {
        return centreY;
    }

    /**
<<<<<<< HEAD
     * Methode : getRayon()
=======
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
     * methode qui retourne le rayon de Cercle
     * @return (int) rayon
     */
    public int getRayon() {
        return rayon;
    }

<<<<<<< HEAD
    /**
     * Methode : getIDLogger()
     * Retourne int idlogger
     * @return : int id
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
        g.fillOval(centreX, centreY, rayon, rayon);
        g.setColor(Color.BLACK);
        g.drawOval(centreX, centreY, rayon, rayon);
        g.setColor(Color.GREEN);
        g.drawLine(centreX, centreY, centreX+rayon, centreY+rayon);
        g.setColor(Color.CYAN);
        g.drawRect(centreX, centreY, rayon, rayon);

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
     * @return (int) x2
     */
    public int lastx(){
        return centreX+rayon;
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
        g.setColor(this.couleur);
        g.fillOval(centreX-rayon, centreY-rayon, rayon*2, rayon*2);
        g.setColor(Color.GREEN);
        g.drawLine(centreX-rayon, centreY-rayon, centreX+rayon, centreY+rayon);
        g.setColor(Color.CYAN);
        g.drawRect(centreX-rayon, centreY-rayon, rayon*2, rayon*2);

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
>>>>>>> ebc8c444d9c32e8db20551f54955191644af5d8e
    public int lasty(){
        return centreY+rayon;
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
        return rayon*2;
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
        return rayon*2;
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
        this.centreX = x2 + this.rayon;
        this.centreY = y2 + this.rayon;
        //this.centreX =(int) Math.round(x2+Math.sqrt(2*rayon*rayon));
        //this.centreY = (int) Math.round(y2+Math.sqrt(2*rayon*rayon));
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
        return rayon;
    }
}