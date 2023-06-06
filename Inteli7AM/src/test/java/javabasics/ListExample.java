package javabasics;

import java.util.ArrayList;
import java.util.List;

public class ListExample {

    public static void main(String[] args) {


        String []a = new String[10];
        a[0]="Aravinth";
        a[1] ="Learn";

        for(int i =0 ; i < a.length ;i++){
            System.out.println(a[i]);
        }


        List <String> l1 = new ArrayList<String>();
        l1.add("Aravinth");
        l1.add("Learn More");

        System.out.println(l1);
        l1.add("hello");
        System.out.println(l1);
        l1.add("Learn More");
        System.out.println(l1);
        l1.add(3,"new");
        System.out.println(l1);

        for(int i=0 ; i <l1.size();i++){

            System.out.println(l1.get(i));
        }

        System.out.println(l1.get(1));

        System.out.println("-----------------");

        for(String output:l1){
            System.out.println(output);
        }

        List <Integer> intList = new ArrayList<Integer>();

        intList.add(23);
        intList.add(56);
        intList.add(99);
        for (int e:intList){
            System.out.println(e);
        }


    }
}
