import view.Frame;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mael on 20/12/14.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
        Frame f = new Frame(new Dimension(1,2),20);
        List<Dimension> list=new ArrayList<Dimension>();
        list.add(new Dimension(1,1));
        f.drawRectangle(1, list);
    }
}
