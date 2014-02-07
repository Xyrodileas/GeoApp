package Formes;
/**
 * Classe général décrivant une forme
 * Created by Alexis on 17/01/14.
 */

import java.awt.*;

public abstract class Forme {
    private Color couleur;

    public abstract void draw(Graphics g);

    /**
     * Méthode permettant de mettre à jour une couleur, et de modifier la transparence (paramètre alpha)
     * @param couleur
     */
    protected void setCouleur(Color couleur){
        this.couleur = new Color((float)couleur.getRed()/255, (float)couleur.getGreen()/255, (float)couleur.getBlue()/255, 1f);
    }
    protected Color getCouleur(){
        return this.couleur;
    }
}
