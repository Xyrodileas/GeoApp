package Formes; /**
 * Created by Alexis on 18/01/14.
 */
import java.awt.Graphics;
import java.awt.Color;
public class Carre extends Rectangle {

    public Carre(int x, int y, int x2, int y2){
        super(x, y, x2, y2); // Un carré est un rectangle particulier, on appel donc le super constructeur
        super.setCouleur(Color.red);
    }
}
