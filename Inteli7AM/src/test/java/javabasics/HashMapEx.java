package javabasics;

import java.util.HashMap;
import java.util.Map;

public class HashMapEx {

    public static void main(String[] args) {

        Map<Integer,String> m = new HashMap<Integer,String>();
        m.put(5756,"aravinth");
        m.put(789,"samp");

        System.out.println( m.get(5756));
        System.out.println(m.values());
    }
}
