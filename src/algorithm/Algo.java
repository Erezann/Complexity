package algorithm;

import readEntry.ReadTerminal;
import view.Frame;
import view.Rectangle;

import java.awt.*;
import java.util.*;
import java.util.List;

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
    private Dimension tailleBoite;
    private List<Shelf> etageres;
    private List<Dimension> rectTries;

    private int shelfLength;
    /**
     * Le constructeur doit permettre d'obtenir de compléter les attributs de Algo pour pouvoir construire l'objet draw
     */
     public Algo(ReadTerminal term){
         rectangles = new ArrayList<Rectangle>();
         readTerminal = term;
         initialisation();
         for (Dimension d : rectTries) {
             if (d.getHeight()>tailleBoite.getHeight() || d.getWidth()>tailleBoite.getWidth()) throw new UnvalidDimensionException("Un rectangle dépasse la taille des boites, calculs arrêtés. " + d.toString());
             rectangles.add(ajoutFirstFit(d));
         }
         nbBoite++;
     }

    private Rectangle ajoutFirstFit(Dimension d) {
        for (int i = 0; i<etageres.size();i++){
            Shelf monEtagere = etageres.get(i);
               //On teste si ça tient sur l'étage actuel
               boolean dernierEt = dernierEtage(i);
               if (tiensSurLEtage(monEtagere, d.getWidth(), d.getHeight(), dernierEt)) {
                   return ajoutSurLetage(monEtagere, d.getWidth(), d.getHeight());
               }
           //Sinon, peut-être qu'on peut créer un nouvel étage ? Seulement dans le cas où on vient de regarder un dernier étage...
              if (dernierEt) {
                  if (monEtagere.getHeight() + d.getHeight() + monEtagere.getBeginY() <= tailleBoite.getHeight()) {
                      ajouterEtage(monEtagere.getBoite(), monEtagere.getHeight()+monEtagere.getBeginY());
                      return ajoutSurLetage(etageres.get(etageres.size() - 1), d.getWidth(), d.getHeight());
                  }
              }
           }
        //Si on est ici, aucun étage libre : besoin d'une nouvelle boite
        ajouterEtage(++nbBoite, 0);
        return ajoutSurLetage(etageres.get(etageres.size()-1), d.getWidth(), d.getHeight());
    }


    private boolean dernierEtage(int i) {
        int boiteActu = etageres.get(i).getBoite();
        if (i < etageres.size()-1) {
            while(i<etageres.size()-1) {
                if (boiteActu == etageres.get(++i).getBoite()) return false;
            }
        }
        return true;
    }

    private boolean tiensSurLEtage(Shelf s, double rectW, double rectH, boolean dernierEtage) {
        double hauteurMax = shelfLength;
        if (dernierEtage) hauteurMax = tailleBoite.getHeight() - s.getBeginY();
        if (s.getCurrentX() + rectW <= tailleBoite.getWidth() && rectH <= hauteurMax)
            return true;
        return false;
    }

    /**
     * Ici, on crée le rectangle à ajouter, puis on modifie les informations nécessaires sur l'étage
     * @param s l'étagère où on ajoute le rectangle
     * @param rectW la largeur du rectangle
     * @param rectH la hauteur du rectangle
     * @return le nouveau rectangle placé
     */
    private Rectangle ajoutSurLetage(Shelf s, double rectW, double rectH) {
        List<Dimension> coord = new ArrayList<Dimension>();
        coord.add(new Dimension(s.getCurrentX(),s.getBeginY()));
        coord.add(new Dimension(s.getCurrentX()+(int)rectW-1,s.getBeginY()+(int)rectH-1));
        Rectangle rect = new Rectangle(s.getBoite(), coord);
        s.decalerX((int)rectW);
        if (rectH>s.getHeight()) s.setHeight(rectH);
        if (s.getCurrentX() ==tailleBoite.getWidth()) {
            etageres.remove(s);
        }
            return rect;
    }

    private void initialisation(){
        tailleBoite = readTerminal.getTailleBoite();
        nbBoite = 0;
        shelfLength = 0;
        etageres = new ArrayList<>();
        ajouterEtage(0, 0);
        triRectangles(readTerminal.getListRectangle());
    }

    /**
     * Méthode pour trier par ordre décroissant les rectangles avant de les placer, afin d'optimiser le placement.
     * Le tri est uniquement en fonction de la largeur. Si les largeurs sont égales, on choisit d'abord la plus grande longueur.
     * @param rects la liste des rectangles non placés
     */
    protected void triRectangles(List<Dimension> rects) {
        Comparator<Dimension> c = new Comparator<Dimension>() {
            public int compare(Dimension d1, Dimension d2) {
                if (d2.getHeight() == d1.getHeight()) return (int)d2.getWidth()-(int)d1.getWidth();
                return (int)d2.getHeight()-(int)d1.getHeight();
            }
        };
        rectTries = rects;
       Collections.sort(rectTries, c);
    }

    private void ajouterEtage(int quelleBoite, int hauteurDebut) {
        etageres.add(new Shelf(quelleBoite, 0, hauteurDebut, 0));
    }

    public void draw(){
        new Frame(readTerminal.getTailleBoite(),nbBoite,rectangles);
    }
}


