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
            System.out.println("Dessin de boite : " + j++);

            g.fillRect(frame.getX(i,0), frame.getY(i,0), largeur * frame.getUnite(), hauteur * frame.getUnite());
        }

        g.setColor(Color.RED);
        int i = 1;
        for(Rectangle r: rectangles){
            System.out.println("Dessin de rectangle : " + i++ + r.getLargeur() + ", " + r.getHauteur());
            g.drawRect(frame.getX(r.getBoite(),r.getOrigx()),frame.getY(r.getBoite(),r.getOrigy()),
                    r.getLargeur() * frame.getUnite(), r.getHauteur() * frame.getUnite());
        }
    }


}
