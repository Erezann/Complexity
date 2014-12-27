package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */
class Box extends JPanel {


    private int largeur;
    private int hauteur;
    private int nbBoite;
    private Frame frame;

    public Box(Frame f,Dimension dim,int nbBoite, List<Rectangle> rectangles){
        frame=f;
        largeur=(int) dim.getWidth();
        hauteur=(int) dim.getHeight();
        this.nbBoite = nbBoite;
    }

    public void paintComponent(Graphics g){
        for(int i=0;i<this.nbBoite;i++) {
            g.drawRect(frame.getX(i,0), frame.getY(i,0), largeur * frame.getUnite(), hauteur * frame.getUnite());
        }
    }


}
