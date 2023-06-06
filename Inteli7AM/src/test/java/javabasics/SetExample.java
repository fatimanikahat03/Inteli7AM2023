package javabasics;

import java.util.HashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {

        Set<String> s = new HashSet<>();
        s.add("abc");
        s.add("learn");
        s.add("learn");
        s.add("uuu");
        System.out.println(s);

        for (String m:s){
            System.out.println(m);
        }

    }
}
