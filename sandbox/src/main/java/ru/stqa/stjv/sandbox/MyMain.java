package ru.stqa.stjv.sandbox;

public class MyMain {
  public static void main(String[] args) {
    Point  myP1 = new Point();
    myP1.coordX = 1;
    myP1.coordY = 1;

    Point  myP2 = new Point();
    myP2.coordX = 1;
    myP2.coordY = 11;

    System.out.println(" XY distance = " + distance(myP1,myP2));
  }

  public static double distance(Point p1, Point p2) {
    return  (Math.sqrt (Math.pow ((p2.coordX - p1.coordX), 2) +Math.pow ((p2.coordY - p1.coordY),2)));
  }

}
