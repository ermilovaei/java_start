package ru.stqa.stjv.sandbox;

public class FB {
  public static void main(String[] args)
  {
    for (int i=1; i<=100; i++){
      if (i % 15 == 0) {
        System.out.println("FizzBizz");
        continue;
      } else {
        if (i % 3 == 0)
          System.out.println("Fizz");
        else {
          if (i % 5 == 0) System.out.println("Bizz");
          else {
            System.out.println(i);
          }
        }
      };


    }

  }

}
