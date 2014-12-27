package view;

import java.awt.*;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */
public class Rectangle{

    /**
     * Dessine les rectangles
     *
     * @origx abscisse de départ
     * @origy ordonnée de départ
     * @largeur largeur
     * @hauteur hauteur
     *
     * les valeurs ci-dessus correspondent à des valeurs en coordonnées, la traduction en pixel est faite dans box
     * si les paramètres du constructeur sont mauvais toutes les valeurs sont initialisées à -1.
     *
     */
    private int origx;
    private int origy;
    private int largeur;
    private int hauteur;

    /**
     *
     * @param numBoite le numéro de la boîte où se trouve le rectangle
     * @param coordonnees les coordonnées des emplacements du rectangle dans la boîte (haut,gauche) <=> (0,0)
     */
    public Rectangle(int numBoite, List<Dimension> coordonnees){

        if (numBoite<0 || coordonnees==null || coordonnees.isEmpty()){
            origx=-1;
            origy=-1;
            largeur=-1;
            hauteur=-1;
            return;
        }

        int minX=coordonnees.get(0).width;
        int maxX=coordonnees.get(0).width;
        int minY=coordonnees.get(0).height;
        int maxY=coordonnees.get(0).height;

        for(Dimension d : coordonnees){
            if (d.width<minX){
                minX=d.width;
            }
            if (d.width>maxX){
                maxX=d.width;
            }
            if (d.height<minY){
                minY=d.height;
            }
            if (d.height>maxY){
                maxY=d.height;
            }
        }

        origx=minX;
        origy=minY;
        largeur=maxX-minX+1;
        hauteur=maxY-minY+1;
    }

    public int getOrigy() {
        return origy;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public int getOrigx() {

        return origx;
    }
}
