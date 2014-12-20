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


    public Rectangle(int x,int y, Dimension dim){
        origx=x;
        origy=y;
        largeur=(int) dim.getHeight();
        hauteur=(int) dim.getWidth();
    }

    public void paintComponent(Graphics g){
        g.drawRect(origx,origy,largeur,hauteur);
    }
}
