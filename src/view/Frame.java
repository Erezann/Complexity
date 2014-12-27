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

    private int LARGEUR_FENETRE=1100;
    private int HAUTEUR_FENETRE=600;
    private int UNITE=50;
    private int MARGE=5;

    private Dimension tailleBoite;
    private int maxBoiteLigne;
    private Box boites;

    /**
     * @param tailleBoite la taille des boite dans lesquelles on va insérer des rectangles
     * @param nbBoite le nombre nécessaire
     */
    public Frame(Dimension tailleBoite, int nbBoite, List<Rectangle> rectangles){
        this.tailleBoite=tailleBoite;
        this.maxBoiteLigne=setMaxBoiteLigne();

        this.setVisible(true);
        this.setTitle("Projet de complexité");
        this.setSize(LARGEUR_FENETRE, HAUTEUR_FENETRE);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.boites = new Box(this,tailleBoite,nbBoite, rectangles);
        this.setContentPane(boites);
    }

    //retourne le nombre de boite maximum par ligne
    private int setMaxBoiteLigne(){
        int xMax;
        int i=1;
        do{
            i++;
            xMax=MARGE+(UNITE*(int)tailleBoite.getWidth()+MARGE)*i;
        }while(xMax<LARGEUR_FENETRE);
        i--;//on s'arrête dès que le nombre de boîte dépasse on retourne donc au nombre de boîte précédent
        return i;
    }


    /**
     *
     * @param num le numéro la boîte
     * @param coordx la position dans la boîte (entre 0 et strict inférieur à tailleBoite.getWidth)
     * @return la position dans la fenêtre de x
     */
    public int getX(int num, int coordx){
        return MARGE+coordx*UNITE+(num%maxBoiteLigne)*(MARGE+UNITE*(int)tailleBoite.getWidth());
    }

    /**
     *
     * @param num le numéro de la boîte
     * @param coordy la position y dans la boîte (entre 0 et strict inférieur à tailleBoîte.getHeight)
     * @return la position de y dans la fenêtre
     */
    public int getY(int num, int coordy){
        return MARGE+coordy*UNITE+(num/maxBoiteLigne)*(MARGE+UNITE*(int) tailleBoite.getHeight());
    }

    public Dimension getTailleBoite(){
        return tailleBoite;
    }

    public int getMarge() {
        return MARGE;
    }
    public int getUnite(){
        return UNITE;
    }
    public int getMaxBoiteLigne() {return maxBoiteLigne; }
}
