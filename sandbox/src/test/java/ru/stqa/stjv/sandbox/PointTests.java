package ru.stqa.stjv.sandbox;


import org.testng.annotations.Test;
import org.testng.Assert;

public class PointTests {
  @Test
  public void testDistance1(){
    Point p = new Point (1,1);
    Point p2 = new Point(1,100);
    Assert.assertEquals(p.distance(p2),99);
  };
  @Test
  public void testDistance2(){
    Point p = new Point (0,0);
    Point p2 = new Point(-33,12);
    Assert.assertEquals(p.distance(p2), 35.11409973, 0.00001);
  };
  @Test
  public void testDistance3() {
    Point p = new Point(0, 0);
    Point p2 = new Point(0, 0);
    Assert.assertEquals(p.distance(p2), 0);
  }
  @Test
  public void testDistance4(){
    Point p = new Point (4560,4560);
    Point p2 = new Point(4560,4560);
    Assert.assertEquals(p.distance(p2), 0);

  };

  @Test
  public void testDistance5(){
    Point p = new Point (-0.15,123);
    Point p2 = new Point(0.45,-50 );
    Assert.assertEquals(p.distance(p2), 173.00104,0.00001);

  };

}

