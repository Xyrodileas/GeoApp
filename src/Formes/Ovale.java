package Formes; /**
 * Created by Alexis on 18/01/14.
 */
import Formes.Forme;

import java.awt.Graphics;
import java.awt.Color;
public class Ovale extends Forme {

    private int centreX, centreY, rayonH, rayonV;

    public Ovale(int x, int y, int h, int v){
        this.centreX = x;
        this.centreY = y;
        this.rayonH = h;
        this.rayonV = v;
        super.setCouleur(Color.blue);
    }
    public void draw(Graphics g){
        g.setColor(super.getCouleur());
        g.fillOval(this.centreX, this.centreY, this.rayonH, this.rayonV);
    }
}
