import java.io.*;
import java.util.*;

class Square<T> {
    private T side;

    public Square(T side) {
        this.side = side;
    }

    public void display() {
        System.out.println(side);
    }

    public T getSide()
    {
        return this.side;
    }
}

public class Dem {
    public static void main(String[] args) {
Square<Integer> s1= new Square<Integer>(2);
Square<Double> s2= new Square<Double>(2.2);
System.out.println("Area"+ s1.getSide()*s1.getSide());
System.out.println("Area"+ s2.getSide()*s2.getSide());
    }
}