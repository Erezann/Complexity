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
        Assert.assertEquals(Frame.getMarge(),f.getX(0,0));
        Assert.assertEquals(Frame.getMarge()+Frame.getUnite(),f.getX(0,1));
        Assert.assertEquals(2*Frame.getMarge()+Frame.getUnite()*(int)f.getTailleBoite().getWidth(),f.getX(1,0));
        Assert.assertEquals(3*Frame.getMarge()+2*Frame.getUnite()*(int)f.getTailleBoite().getWidth()+2*Frame.getUnite(),f.getX(2,2));
    }

    @Test
    public void getYTest(){
        Assert.assertEquals(Frame.getMarge(),f.getY(0, 0));
        Assert.assertEquals(Frame.getMarge()+Frame.getUnite(),f.getY(0,1));
        Assert.assertEquals(Frame.getMarge()+Frame.getUnite(),f.getY(3,1));
        Assert.assertEquals(2*Frame.getMarge()+Frame.getUnite()*(int)f.getTailleBoite().getHeight(),f.getY(12,0));
        Assert.assertEquals(2*Frame.getMarge()+Frame.getUnite()*(int)f.getTailleBoite().getHeight()+2*Frame.getUnite(),f.getY(19,2));
    }
}
