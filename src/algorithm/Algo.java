package algorithm;

import readEntry.ReadTerminal;
import view.*;
import view.Frame;
import view.Rectangle;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mael on 20/12/14.
 */
public class Algo {

    /**
     * @param readTerminal est l'objet permet de lire la taille de la boite et les dimensions des rectangles
     * @param nbBoite correspond au nombre de boite nécessaire pour remplir les rectangles
     * @param rectangles list des view.Rectangles utiliser
     *                   (voir la classe view.Rectangle pour la construction)
     *
     */
    private ReadTerminal readTerminal;
    private int nbBoite;
    private List<view.Rectangle> rectangles;


    /**
     * Le constructeur doit permettre d'obtenir de compléter les attributs de Algo pour pouvoir construire l'objet draw
     */
     public Algo(){
        readTerminal=new ReadTerminal();
        //readTerminal.getTailleBoite()
         nbBoite = readTerminal.getListRectangle().size();
         //Donne une liste de dimensions, genre 2x3, 1x2...
         // readTerminal.getListRectangle()
         //On crée une liste de rectangles
         rectangles = new ArrayList<Rectangle>();
         int i = 0;
         for (Dimension d : readTerminal.getListRectangle()) {
             List<Dimension> coord = new ArrayList<Dimension>();
             //Coord début : tout en haut à gauche de la boite, parce que là c'est juste 1 rect / boite
             coord.add(new Dimension(0,0));
             //coord de fin : ma largeur puis ma hauteur
             coord.add(new Dimension((int)d.getWidth(),(int)d.getHeight()));
             rectangles.add(new Rectangle(i++,coord));
         }
         System.out.println(rectangles.size());

     }


    public void draw(){
        new Frame(readTerminal.getTailleBoite(),nbBoite,rectangles);
    }
}
