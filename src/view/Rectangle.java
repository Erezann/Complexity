package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mael on 20/12/14.
 */
class Rectangle extends JPanel {

    /**
     * Dessine les rectangles
     *
     */
    int origx;
    int origy;
    int largeur;
    int hauteur;


    public Rectangle(int x,int y, int l,int h){
        origx=x;
        origy=y;
        largeur=l;
        hauteur=h;
    }

    public void paintComponent(Graphics g){
        g.drawRect(origx,origy,largeur,hauteur);
    }
}
