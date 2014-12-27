package view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mael on 27/12/14.
 */
public class RectangleTest {

    private Rectangle r;
    private List<Dimension> dim;


    @Test
    public void getErrorTest(){
        dim=new ArrayList<Dimension>();
        r=new Rectangle(0,dim);
        Assert.assertEquals(-1,r.getOrigx());
        Assert.assertEquals(-1,r.getHauteur());
        Assert.assertEquals(-1,r.getLargeur());
        Assert.assertEquals(-1,r.getOrigy());
        dim.add(new Dimension(5,2));
        r=new Rectangle(-1,dim);
        Assert.assertEquals(-1,r.getOrigx());
        Assert.assertEquals(-1,r.getHauteur());
        Assert.assertEquals(-1,r.getLargeur());
        Assert.assertEquals(-1,r.getOrigy());
        r=new Rectangle(2,null);
        Assert.assertEquals(-1,r.getOrigx());
        Assert.assertEquals(-1,r.getHauteur());
        Assert.assertEquals(-1,r.getLargeur());
        Assert.assertEquals(-1,r.getOrigy());
    }

    @Test
    public void getTest(){
        dim=new ArrayList<Dimension>();
        dim.add(new Dimension(0,0));
        r=new Rectangle(0,dim);
        Assert.assertEquals(0,r.getOrigx());
        Assert.assertEquals(0,r.getOrigy());
        Assert.assertEquals(1,r.getLargeur());
        Assert.assertEquals(1,r.getHauteur());


        dim=new ArrayList<Dimension>();
        dim.add(new Dimension(2,4));
        r=new Rectangle(0,dim);

        Assert.assertEquals(2,r.getOrigx());
        Assert.assertEquals(4,r.getOrigy());
        Assert.assertEquals(1,r.getLargeur());
        Assert.assertEquals(1,r.getHauteur());

        dim=new ArrayList<Dimension>();
        dim.add(new Dimension(2,4));
        dim.add(new Dimension(3,4));
        dim.add(new Dimension(4,4));
        dim.add(new Dimension(2,5));
        dim.add(new Dimension(3,5));
        dim.add(new Dimension(4,5));
        r=new Rectangle(2,dim);

        Assert.assertEquals(2,r.getOrigx());
        Assert.assertEquals(4,r.getOrigy());
        Assert.assertEquals(3,r.getLargeur());
        Assert.assertEquals(2,r.getHauteur());

        dim=new ArrayList<Dimension>();
        dim.add(new Dimension(2,5));
        dim.add(new Dimension(3,5));
        dim.add(new Dimension(4,5));
        dim.add(new Dimension(2,4));
        dim.add(new Dimension(3,4));
        dim.add(new Dimension(4,4));
        r=new Rectangle(2,dim);

        Assert.assertEquals(2,r.getOrigx());
        Assert.assertEquals(4,r.getOrigy());
        Assert.assertEquals(3,r.getLargeur());
        Assert.assertEquals(2,r.getHauteur());
        
    }
}
