package javabasics;

public class CalculatorProgram {

    public static void main(String[] args) {

        double a = 12;
        double b = 23.45;
        String operator = "-";
        double output = 0;

        if(operator.equals("+")){
            output= a+b;
        }

        else if (operator.equals("-")){

            if(a>b){
                output= a-b;
            }
            else if(a<b){
                output= b-a;
            }

        }
        else if (operator.equals("*")) {

            output= a*b;

        }
        else if(operator.equals("/")){
           if( a != 0 && b != 0 ){
               output= a/b;
           }
           else{
               System.out.println("Division cannot be performed");
           }
        }
        else{

        }

        System.out.println(output);
    }
}
