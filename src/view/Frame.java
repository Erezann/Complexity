package view;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */
public class Frame extends JFrame{


    public Frame(){;
        this.setVisible(true);
        this.setTitle("Projet de complexité");
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @param tailleBoite la taille des boite dans lesquelles on va insérer des rectangles
     * @param nbBoite le nombre nécessaire
     */
    public Frame(Dimension tailleBoite, int nbBoite){
    }

    /**
     *
     * @param numBoite le numéro de la boîte où le rectangle doit être dessiné
     * @param coordRectangle la liste des coordonnées du rectangle pour la boîte
     */
    public void drawRectangle(int numBoite, List<Dimension> coordRectangle){

    }
}
