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
    private List<Dimension> boites;
    private Dimension tailleBoite;

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

         //readTerminal.getTailleBoite()
       /*  boites = new ArrayList<>();
         //On initialise la liste des boites avec 1 seule, de la dimension donnée
         //Ensuite, à chaque fois qu'on met un rectangle dans cette boite, on change ce qui est encore dispo ?
         boites.add(readTerminal.getTailleBoite());
         nbBoite = readTerminal.getListRectangle().size();
         //Donne une liste de dimensions, genre 2x3, 1x2...
         // readTerminal.getListRectangle()
         //On crée une liste de rectangles vide,
         //on mettra dedans chacun de nos rectangles, avec la boite où ils vont, & leur coordonnées dans cette boite
         rectangles = new ArrayList<Rectangle>();
         int i = 0;

         for (Dimension d : readTerminal.getListRectangle()) {
             List<Dimension> coord = new ArrayList<Dimension>();
             //Coord début : tout en haut à gauche de la boite, parce que là c'est juste 1 rect / boite
             //x, y
             coord.add(new Dimension(0,0));
             //coord de fin : ma largeur puis ma hauteur
             coord.add(new Dimension((int)d.getWidth(),(int)d.getHeight()));
             rectangles.add(new Rectangle(i++,coord));
         }
         System.out.println(rectangles.size());
         //Implémentation du first fit : On prend la première boite où mon rectangle actuel peut entrer,
         // ou bien on en ouvre une nouvelle
         //On parcourt la liste des dimensions des rectangles à placer
         /*double hleft;// = readTerminal.getTailleBoite().getHeight();
         double wleft;// = readTerminal.getTailleBoite().getWidth();
         for (Dimension d : readTerminal.getListRectangle()) {
             List<Dimension> coord = new ArrayList<Dimension>();
             hleft = boites.get(i).getHeight();
             wleft = boites.get(i).getWidth();
             while (!(d.getWidth()<=wleft && d.getHeight()<=hleft) && i<boites.size()-1) {
                 i++;
                 hleft = boites.get(i).getHeight();
                 wleft = boites.get(i).getWidth();
             }
              if (i<boites.size()-1) { //si cette condition est toujours vraie, c'est l'autre qui est devenue fausse
                 //Si le rectangle que je tiens entre dans la boite que je regarde
                     //Alors, je dois regarder comment placer dans cette boite
                     coord.add(new Dimension((int)wleft,0));
                     coord.add(d);
                     rectangles.add(new Rectangle(i,coord));
                     wleft -= d.getWidth();
                     hleft -= d.getHeight();
                     boites.get(i).setSize(wleft,hleft);
                 } else {
               boites.add(readTerminal.getTailleBoite());
                coord.add(new Dimension(0,0));
                coord.add(d);
                rectangles.add(new Rectangle(i,coord));
                wleft = readTerminal.getTailleBoite().getWidth() - d.getWidth();
                hleft = readTerminal.getTailleBoite().getHeight() - d.getHeight();
                boites.get(i).setSize(wleft,hleft);
            }
             //Besoin d'une liste de boites !
         }
*/
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
    }

    //ici, j'ai la responsabilité d'augmenter le nbBoite si ncs !
    private Rectangle ajoutRectangle(Dimension rect) {
        if (currentWidth + rect.getWidth() > tailleBoite.getWidth()) { //Si je n'ai plus la largeur pour mettre mon rectangle
            //On fait un nouvel étage =>pas nécessairement = une nouvelle boite
            currentWidth = 0;
            currentLength += shelfLength;
            shelfLength = 0;
        }
        //Besoin de vérifier la hauteur aussi : peut-être besoin de changer de boite en fait !
        if (currentLength + rect.getHeight() > tailleBoite.getHeight()) { // Alors plus de place en hauteur,
            // on change de boite, pas le choix, comme on n'a pas le droit de retourner les rectangles !
            nbBoite++;
            currentWidth = 0;
            currentLength = 0;
            shelfLength = 0;
        }

            //Si ça rentre :
            List<Dimension> coord = new ArrayList<Dimension>();
            //x, y
            coord.add(new Dimension(currentWidth,currentLength));
            //coord de fin : ma largeur puis ma hauteur
            //coord.add(new Dimension((int)rect.getWidth(),(int)rect.getHeight()));
            // essai coord de fin en donnant les coords, pas juste largeur hauteur => 1 de +, cf tests
             coord.add(new Dimension(currentWidth+(int)rect.getWidth(),currentLength+(int)rect.getHeight()));
            if (rect.getHeight()>shelfLength) shelfLength = (int)rect.getHeight();
            currentWidth += rect.getWidth();
            return new Rectangle(nbBoite, coord);

    }

    public void draw(){
            new Frame(readTerminal.getTailleBoite(),nbBoite,rectangles);
        System.out.println("Je dessine une boite de taille" + readTerminal.getTailleBoite());
    }
}
