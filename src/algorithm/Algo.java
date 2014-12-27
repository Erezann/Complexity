package algorithm;

import readEntry.ReadTerminal;
import view.*;
import view.Frame;

import java.awt.*;
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

     }


    public void draw(){
        new Frame(readTerminal.getTailleBoite(),nbBoite,rectangles);
    }
}
