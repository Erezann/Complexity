import algorithm.Algo;
import readEntry.ReadTerminal;
import view.Frame;
import view.Rectangle;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by mael on 20/12/14.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");

        //ReadTerminal r = new readEntry.ReadTerminal();

  /*      List<Rectangle> list = new ArrayList<Rectangle>();
        List<Dimension> coord = new ArrayList<Dimension>();
        coord.add(new Dimension(0,0));
        coord.add(new Dimension(1,1));
        list.add(new Rectangle(2,coord));
        list.add(new Rectangle(1,coord));

        Frame f = new Frame(new Dimension(5,5),24, list);
*/
        ReadTerminal readTerminal=new ReadTerminal();
        Algo a = new Algo(readTerminal);
        a.draw();
    }
}
