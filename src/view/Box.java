package view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mael on 20/12/14.
 */
class Box extends JPanel {


    private int largeur;
    private int hauteur;
    private int nbBoite;
    private Frame frame;

    //TODO modifier la classe en utilisant les fonctions getX et getY
    public Box(Frame f,Dimension dim,int nbBoite){
        frame=f;
        largeur=(int) dim.getWidth();
        hauteur=(int) dim.getHeight();
        this.nbBoite = nbBoite;
    }

    public void paintComponent(Graphics g){
        int nbBoiteAffiche=0;
        int ligne=0;
        for(int i=0;i<this.nbBoite;i++) {

            if( Frame.getMarge() + ( largeur*Frame.getUnite() +Frame.getMarge() )*(i-nbBoiteAffiche)
                    >Frame.getLargeurFenetre() -Frame.getUnite()*largeur ) {
                nbBoiteAffiche=i;
                ligne++;
            }

            g.drawRect(Frame.getMarge() + ( largeur*Frame.getUnite() +Frame.getMarge() )*(i-nbBoiteAffiche),
                    Frame.getMarge()+(hauteur*Frame.getUnite()+Frame.getMarge())*ligne,
                    largeur * Frame.getUnite(), hauteur * Frame.getUnite());


        }

    }

}
