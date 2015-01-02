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
         for (Dimension d : readTerminal.getListRectangle()) rectangles.add(ajoutRectangle(d));
         nbBoite++;
         System.out.println("Nombre boites : " + nbBoite + "\nnb rectangles : " + rectangles.size());
     }


    private void initialisation(){
        tailleBoite = readTerminal.getTailleBoite();
        currentWidth = 0;
        currentLength = 0;
        nbBoite = 0;
        usedSurfaceArea = 0;
        shelfLength = 0;
        etageres = new ArrayList<>();
        ajouterEtage(0);
    }

    private void ajouterEtage(int hauteurDebut) {
        etageres.add(new Shelf(0,currentLength,hauteurDebut));
    }

    //ici, j'ai la responsabilité d'augmenter le nbBoite si ncs !
    private Rectangle ajoutRectangle(Dimension rect) {
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
        //coord.add(new Dimension((int)rect.getWidth(),(int)rect.getHeight()));
        // essai coord de fin en donnant les coords, pas juste largeur hauteur => 1 de +, cf tests
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
