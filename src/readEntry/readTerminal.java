package readEntry;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */


public class readTerminal {


    private Dimension tailleBoite;
    private List<Dimension> listRectangle = new ArrayList<Dimension>();

    /**
     * lit deux lignes sur le terminal
     * la première ligne contient la taille d'un carré
     * la deuxième ligne contient une liste de dimension représentant la taille des rectangle
     */
    public readTerminal(){
        BufferedReader entry = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            line=entry.readLine();
            tailleBoite = getDimension(line);
            line=entry.readLine();
            String[] listDim = getRectDim(line);
            for(String s : listDim) {
                listRectangle.add(getDimension(s));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * sépare une ligne de string représentant des dimension en un liste de string représentant des dimensions
     * @param s représente un ensemble de rectangle avec leur dimension 2x2 3x3 2x3
     * @return une liste de dimension ecrite en string [2x2,3x3,2x3]
     */
    private String[] getRectDim(String s){
        return s.split(" ");
    }

    /**
     * converti un string représentant une dimension en un objet Dimension
     * @param s représente une dimension  (2x2)
     * @return la dimension convertie en objet Dimension(2,2)
     */
    private Dimension getDimension(String s){
        String[] dim=s.split("x");
        return new Dimension(Integer.parseInt(dim[0]),Integer.parseInt(dim[1]));
    }

    public Dimension getTailleBoite() {
        return tailleBoite;
    }

    public List<Dimension> getListRectangle() {
        return listRectangle;
    }
}
