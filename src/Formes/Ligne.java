package Formes;

/**
 *
 * Created by Alexis on 18/01/14.
 */

import java.awt.Graphics;
import java.awt.Color;
public class Ligne extends Forme {

    private int x, y, x2, y2;

    public Ligne(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        super.setCouleur(Color.DARK_GRAY);
    }
    public void draw(Graphics g){
        g.setColor(super.getCouleur());
        g.drawLine(this.x, this.y, this.x2, this.y2);
    }
}
