package Formes;

/**
 * Created by Alexis on 15/02/14.
 */

//*************************************************************

import java.awt.*;

/**
 * Classe : Cercle
 * Classe : Carre
 * Heritage : Formes
 *
 */
public class Cercle extends Formes {

    //ATTRIBUTS DE CERCLE
    private int centreX;
    private int centreY;

    private final int rayon;


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
     * Methode : getCentreX()
     * Methode qui retourne 
     * le centreX de Cercle
     * Methode qui retourne le centreX de Cercle
     * @return (int) centreX
     */
    public int getCentreX() {
        return centreX;
    }

    /**
     * Methode : getCentreY()
     * Methode qui retourne 
     * le centreY de Cercle
     * Methode qui retourne le centreY de Cercle
     * @return (int) centreY
     */
    public int getCentreY() {
        return centreY;
    }

    /**
     * Methode : getRayon()
     * methode qui retourne le rayon de Cercle
     * @return (int) rayon
     */
    public int getRayon() {
        return rayon;
    }

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
     * @return (int) x2
     */
    public int lastx(){
        return centreX+rayon;
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
	public int lasty() {
		return  centreY+rayon;
	}
    
    /**
     *  Methode : getHauteur()
     *  Permet de retourner la hauteur
     *  @return (int) hauteur
     */
    public int getHauteur() {
        return rayon*2;
    }

    /**
     *  Methode :getLargeur()
     *  Permet de retourner la largeur
     *  @return (int) largeur
     */
    public int getLargeur(){
        return rayon*2;
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
        this.centreX = x2 + this.rayon;
        this.centreY = y2 + this.rayon;
        //this.centreX =(int) Math.round(x2+Math.sqrt(2*rayon*rayon));
        //this.centreY = (int) Math.round(y2+Math.sqrt(2*rayon*rayon));
    }
    
    /**
     *  Methode : getDistanceMax()
     *  Permet de retourner distance Max entre 2 points
     *  @return (int) distanceMax
     */
    public double getDistanceMax(){
        return rayon;
    }


}