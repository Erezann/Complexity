package algorithm;

import view.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garance on 02/01/2015.
 * Une classe pour symboliser les étages définis dans chaque boite, afin de pouvoir les stocker, & donc y revenir
 */
public class Shelf {
    // Le x qui donne l'extrémité droite du remplissage actuel de l'étagère
    private int currentX;
    // Le y du début de l'étagère
    private int beginY;
    // La hauteur de l'étage. Si beginY + height< hauteur boite, & c'est la dernière, on peut agrandir
    private int height;
    //Une liste des rectangles que contient l'étagère
    private List<Rectangle> rectangles;


    public Shelf(int x, int y, int h) {
        currentX = x;
        beginY = y;
        height = h;
        rectangles = new ArrayList();
    }

    public void ajoutRectangle (Rectangle rec) {
        rectangles.add(rec);
    }
}

