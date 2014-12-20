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
    int largeur;
    int hauteur;


    public Rectangle(Dimension dim){
        largeur=(int) dim.getHeight();
        hauteur=(int) dim.getWidth();
    }

    public void paintComponent(Graphics g){
        //g.drawRect(5,5,150,150);
    }
}
