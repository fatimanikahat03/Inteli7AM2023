package javabasics;

public class ArrayBasics {

    public static void main(String[] args) {

        int [] a = {5,6,7,9,10};   //index order 0 ,1,2 length - 5
        String [] b = {"aravinth","learnmore"}; //0,1 length - 2
        //size is fixed - length
        System.out.println(a[2]);
        System.out.println(b[1]);

        for(int j=0 ; j < b.length ; j++){

            System.out.println(b[j]);
        }
        System.out.println("--------------");
        for (int p:a){
            System.out.println(p);
        }

        for (int i=0 ; i < a.length ; i++){

            System.out.println(a[i]);
        }
        System.out.println("------------");
        for(String h:b){
            System.out.println(h);
        }


    }
}
