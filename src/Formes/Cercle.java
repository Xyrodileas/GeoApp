package Formes;

/**
 * Created by Alexis on 18/01/14.
 */
import Formes.Forme;

import java.awt.Graphics;
import java.awt.Color;
public class Cercle extends Ovale {


    public Cercle(int x, int y, int r){
        super(x, y, r, r); // Un cercle est un ovale particulier, on appel donc le super constructeur
        super.setCouleur(Color.green);
    }

}
