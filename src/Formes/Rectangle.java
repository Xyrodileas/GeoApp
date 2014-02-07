package Formes; /**
 * Created by Alexis on 17/01/14.
 */
import Formes.Forme;

import java.awt.*;

public class Rectangle extends Forme {

    private int x, y, width, height;

    public Rectangle(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.width = x2-x;
        this.height = y2-y;
        super.setCouleur(Color.yellow);
    }
    public void draw(Graphics g){
        g.setColor(super.getCouleur());

        g.fillRect(this.x, this.y, this.width, this.height);
    }
}
