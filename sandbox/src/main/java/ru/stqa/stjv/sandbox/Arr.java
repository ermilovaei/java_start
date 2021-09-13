package ru.stqa.stjv.sandbox;

import java.util.ArrayList;
import java.util.Comparator;

public class Arr {
  public static void main(String[] args)
  {
    ArrayList<Integer> arr = new ArrayList();
    for (int i = 1; i<=15; i++){
      arr.add(Integer.valueOf((int) (Math.random()*100)));
    }
System.out.println(arr);

 int   max = arr.get(0);
 for (int i = 0; i<15; i++)   {
   //System.out.println(arr.get(i));
   if (arr.get(i) > max)  {max = arr.get(i);};
 }
 System.out.println(max);

    boolean isSorted = false;
    int buf;
    while(!isSorted) {
      isSorted = true;
      for (int i = 0; i<14; i++) {
        if(arr.get(i) > arr.get(i + 1)){
          isSorted = false;
          buf = arr.get(i);
          arr.set(i, arr.get(i + 1));
          arr.set(i + 1, buf);
        }
      }
    }
    System.out.println(arr);




  }


}
