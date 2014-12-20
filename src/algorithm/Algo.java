package algorithm;

import readEntry.ReadTerminal;

import java.awt.*;
import java.util.List;
import java.util.Map;

/**
 * Created by mael on 20/12/14.
 */
public class Algo {

    /**
     * readTerminal est l'objet permet de lire la taille de la boite et les dimensions des rectangles
     * nbBoite correspond au nombre de boite nécessaire pour remplir les rectangles
     * coordRectangle est un map ou chaque clé est un numéro de boite auquelle correspond la list des coordonnees de ses
     * différents rectangle
     * La première liste contient tout les rectangles et la deuxième la liste contient les coodonnées des emplacements du
     * rectangle dans la boîte
     *
     */
    private ReadTerminal readTermcinal;
    private int nbBoite;
    private Map<Integer,List<List<Dimension>>> coordRectangle;


    /**
     * Le constructeur doit permettre d'obtenir de compléter les attributs de Algo pour pouvoir construire l'objet draw
     */
     public Algo(){


     }
}
