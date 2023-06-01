package javabasics;

public class SalaryCalculation {

    public static void main(String[] args) {

        //Bank :  Manger  - 500 , Clerk - 350  , staff - 250
        //
        //No of working days as 10 days

        int n = 10 ;
        String role = "Staff";
        int salary = 0;

        if(role.equalsIgnoreCase("Manger")){

             salary = 500 * n ;

        }
        else if (role.equalsIgnoreCase("clerk")){

             salary = 350 * n ;
        }
        else if(role.equalsIgnoreCase("staff")){

             salary = 200 * n ;
        }
        else{
            System.out.println("Enter Valid role");
        }

        System.out.println(salary);



    }
}
