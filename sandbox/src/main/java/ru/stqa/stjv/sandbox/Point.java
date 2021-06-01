package ru.stqa.stjv.sandbox;

public class Point {
  public double coordX;
  public double coordY;
  public Point (double x, double y){
    this.coordY = x;
    this.coordY = y;
  }

  // расстояние от точки до точки p2
  public double distance(Point p2) {
    return  (Math.sqrt (Math.pow ((this.coordX - p2.coordX), 2) + Math.pow ((this.coordY - p2.coordY),2)));
  }

}


