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
    private List<Rectangle> rectangles;

    public Box(Frame f,Dimension dim,int nbBoite, List<Rectangle> r){
        frame=f;
        largeur=(int) dim.getWidth();
        hauteur=(int) dim.getHeight();
        this.nbBoite = nbBoite;
        this.rectangles=r;
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.gray);
        int j= 1;
        for(int i=0;i<this.nbBoite;i++) {
            g.fillRect(frame.getX(i,0), frame.getY(i,0), largeur * frame.getUnite(), hauteur * frame.getUnite());
        }

        int i = 1;
        for(Rectangle r: rectangles){
            g.setColor(Color.pink);
            g.fillRect(frame.getX(r.getBoite(),r.getOrigx()),frame.getY(r.getBoite(),r.getOrigy()),
                    r.getLargeur() * frame.getUnite(), r.getHauteur() * frame.getUnite());
            g.setColor(Color.RED);
            g.drawRect(frame.getX(r.getBoite(),r.getOrigx()),frame.getY(r.getBoite(),r.getOrigy()),
                    r.getLargeur() * frame.getUnite(), r.getHauteur() * frame.getUnite());
        }
    }


}
