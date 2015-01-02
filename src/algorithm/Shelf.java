package algorithm;

import view.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garance on 02/01/2015.
 * Une classe pour symboliser les étages définis dans chaque boite, afin de pouvoir les stocker, & donc y revenir
 */
public class Shelf {

    private int numBoite;
    // Le x qui donne l'extrémité droite du remplissage actuel de l'étagère
    private int currentX;
    // Le y du début de l'étagère
    private int beginY;
    // La hauteur de l'étage. Si beginY + height< hauteur boite, & c'est la dernière, on peut agrandir
    private int height;
    //Une liste des rectangles que contient l'étagère
    private List<Rectangle> rectangles;


    public Shelf(int num, int x, int y, int h) {
        numBoite = num;
        currentX = x;
        beginY = y;
        height = h;
        rectangles = new ArrayList();
    }

    public void ajoutRectangle (Rectangle rec) {
        rectangles.add(rec);
    }

    public int getBoite() {
        return numBoite;
    }

    public int getBeginY() {
        return beginY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public void decalerX(int x) {
        if (x>=0)
        currentX+=x;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(double h) {
        if (h>0) height = (int) h;
    }
}

