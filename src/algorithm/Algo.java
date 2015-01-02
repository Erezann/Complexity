package algorithm;

import readEntry.ReadTerminal;
import view.Frame;
import view.Rectangle;

import java.awt.*;
import java.util.ArrayList;
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

    private int currentWidth;
    private int currentLength;
    private int usedSurfaceArea;
    private int shelfLength;
    /**
     * Le constructeur doit permettre d'obtenir de compléter les attributs de Algo pour pouvoir construire l'objet draw
     */
     public Algo(){
         readTerminal=new ReadTerminal();
         rectangles = new ArrayList<Rectangle>();
         initialisation();
         //Ici, avec algo Shelf NextFit
        // for (Dimension d : readTerminal.getListRectangle()) rectangles.add(ajoutNextFit(d));
         //Ici, avec algo Shelf FirstFit
         for (Dimension d : readTerminal.getListRectangle()) rectangles.add(ajoutFirstFit(d));
         nbBoite++;
         System.out.println("Nombre boites : " + nbBoite + "\nnb rectangles : " + rectangles.size());
     }

    private Rectangle ajoutFirstFit(Dimension d) {
            //Comment savoir si cette étagère est la dernière de la boite du moment ?
           for (int i = 0; i< etageres.size();i++) {

            if (tiensSurLEtage(etageres.get(i), d.getWidth(), d.getHeight(), dernierEtage(i))) {
                return ajoutSurLetage(etageres.get(i), d.getWidth(), d.getHeight());
            }
        }
        //Si on est ici, pas d'étage libre : besoin d'une nouvelle boite
        ajouterEtage(++nbBoite, 0);
        return ajoutSurLetage(etageres.get(etageres.size()-1), d.getWidth(), d.getHeight());
    }

    private boolean dernierEtage(int i) {
        if (i < etageres.size()-1)
        return etageres.get(i).getBoite() != etageres.get(i+1).getBoite();
        return true;
    }

    private boolean tiensSurLEtage(Shelf s, double rectW, double rectH, boolean dernierEtage) {
        double hauteurMax = shelfLength;
        if (dernierEtage) hauteurMax = tailleBoite.getHeight() - s.getBeginY();
        if (s.getCurrentX() + rectW <= tailleBoite.getWidth() && rectH <= hauteurMax)
            return true;
        else
            return false;
    }

    private Rectangle ajoutSurLetage(Shelf s, double rectW, double rectH) {
        // On commence par créer effectivement le rectangle
        List<Dimension> coord = new ArrayList<Dimension>();
        //x, y
        coord.add(new Dimension(s.getCurrentX(),s.getBeginY()));
        //coord de fin : ma largeur puis ma hauteur
        coord.add(new Dimension(s.getCurrentX()+(int)rectW-1,s.getBeginY()+(int)rectH-1));
        Rectangle rect = new Rectangle(s.getBoite(), coord);

        //On adapte les informations pour l'étage utilisé
        s.decalerX((int)rectW);
        if (rectH>s.getHeight()) s.setHeight(rectH);
        //currentWidth += rect.getWidth();

        return rect;
    }

    private void initialisation(){
        tailleBoite = readTerminal.getTailleBoite();
        currentWidth = 0;
        currentLength = 0;
        nbBoite = 0;
        usedSurfaceArea = 0;
        shelfLength = 0;
        etageres = new ArrayList<>();
        ajouterEtage(0, 0);
    }

    private void ajouterEtage(int quelleBoite, int hauteurDebut) {
        etageres.add(new Shelf(quelleBoite, 0, currentLength, hauteurDebut));
    }

    //ici, j'ai la responsabilité d'augmenter le nbBoite si ncs !
    private Rectangle ajoutNextFit(Dimension rect) {
        verifierLargeur(rect);
        verifierHauteur(rect);
        return itFitsISits(rect);
    }

    private Rectangle itFitsISits(Dimension rect) {
        //Si ça rentre :
        List<Dimension> coord = new ArrayList<Dimension>();
        //x, y
        coord.add(new Dimension(currentWidth,currentLength));
        //coord de fin : ma largeur puis ma hauteur
        coord.add(new Dimension(currentWidth+(int)rect.getWidth()-1,currentLength+(int)rect.getHeight()-1));
        if (rect.getHeight()>shelfLength) shelfLength = (int)rect.getHeight();
        currentWidth += rect.getWidth();
        return new Rectangle(nbBoite, coord);
    }

    private void verifierHauteur(Dimension rect) {
        //Besoin de vérifier la hauteur aussi : peut-être besoin de changer de boite en fait !
        if (currentLength + rect.getHeight() > tailleBoite.getHeight()) { // Alors plus de place en hauteur,
            // on change de boite, pas le choix, comme on n'a pas le droit de retourner les rectangles !
            nbBoite++;
            currentWidth = 0;
            currentLength = 0;
            shelfLength = 0;
        }
    }

    private void verifierLargeur(Dimension rect) {
        if (currentWidth + rect.getWidth() > tailleBoite.getWidth()) { //Si je n'ai plus la largeur pour mettre mon rectangle
            //On fait un nouvel étage =>pas nécessairement = une nouvelle boite
            currentWidth = 0;
            currentLength += shelfLength;
            shelfLength = 0;
        }
    }

    public void draw(){
            new Frame(readTerminal.getTailleBoite(),nbBoite,rectangles);
        System.out.println("Je dessine une boite de taille" + readTerminal.getTailleBoite());
    }
}
