package view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;

/**
 * Created by mael on 20/12/14.
 */
public class FrameTest {
    Frame f;

    @Before
    public void setUp(){
        f=new Frame(new Dimension(2,2),12);
    }

    @Test
    public void setMaxBoiteLigneTest(){
        Assert.assertEquals(10,f.getMaxBoiteLigne());
        f=new Frame(new Dimension(5,2),10);
        Assert.assertEquals(4,f.getMaxBoiteLigne());
        f=new Frame(new Dimension(1,2),25);
        Assert.assertEquals(19,f.getMaxBoiteLigne());
    }

    @Test
    public void getXTest(){
        Assert.assertEquals(Frame.getMarge(),f.getX(1,1));
    }
}
