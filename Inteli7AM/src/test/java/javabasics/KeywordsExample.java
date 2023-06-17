package javabasics;

public class KeywordsExample extends Sample {

    int a = 15;

    final double pie = 3.14;

    public static void main(String[] args) {

        int a = 10;

        System.out.println(a);
        KeywordsExample k = new KeywordsExample();
       k.m1();

       Sample.t();

    }

    public void m1(){

        int a = 45;
        this.a = 100;

        System.out.println(a);
        System.out.println(this.a);
        System.out.println(super.a);
        System.out.println(pie);
    }




}
