package ru.stqa.stjv.sandbox;


import org.testng.annotations.Test;
import org.testng.Assert;

public class PointTests {
  @Test
  public void testDistance(){
    Point p = new Point (0,0);
    Point p2 = new Point(100,100);
    Assert.assertEquals(p.distance(p2),141.421356);
  };
}
