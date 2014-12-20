package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */
public class Frame extends JFrame{

    /**
     * Cette classe est la fenetre de base qui va contenir les dessins
     */

    private static final int LARGEUR_FENETRE=1100;
    private static int HAUTEUR_FENETRE=600;
    private static int UNITE=50;
    private static int MARGE=5;

    public Frame(){;
        this.setVisible(true);
        this.setTitle("Projet de complexité");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * @param tailleBoite la taille des boite dans lesquelles on va insérer des rectangles
     * @param nbBoite le nombre nécessaire
     */
    public Frame(Dimension tailleBoite, int nbBoite){
        this.setVisible(true);
        this.setTitle("Projet de complexité");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Box(tailleBoite,nbBoite));
    }

    /**
     *
     * @param numBoite le numéro de la boîte où le rectangle doit être dessiné
     * @param coordRectangle la liste des coordonnées du rectangle pour la boîte
     */
    public void drawRectangle(int numBoite, List<Dimension> coordRectangle){

    }

    public static int getMarge() {
        return MARGE;
    }
    public static int getUnite(){
        return UNITE;
    }

    public static int getLargeurFenetre(){
        return LARGEUR_FENETRE;
    }

    public static int getHauteurFenetre(){
        return HAUTEUR_FENETRE;
    }
}
