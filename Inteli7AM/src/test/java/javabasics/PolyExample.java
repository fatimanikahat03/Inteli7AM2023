package javabasics;

import java.util.ArrayList;
import java.util.List;

public class PolyExample {

    public static void main(String[] args) {

        PolyExample p = new PolyExample();

        p.m1(1,4,89);

        List <String> d = new ArrayList<>();



    }

    public void m1(int a , int b){

        System.out.println(a+b);

    }

    public void m1(int a , int b,int c){

        System.out.println(a+b);

    }

    public void m1(int a){

        System.out.println(a);
    }

    public void m1(String b){

        System.out.println(b);

    }

    public void m1(int a , String b){

        System.out.println(a + b);
    }
}
