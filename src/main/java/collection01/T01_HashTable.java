package collection01;

import java.util.*;

public class T01_HashTable {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        v.add("123");
        System.out.println(v.get(0));

        Hashtable<String, String> table = new Hashtable<>();

        Map<String, String> map = Collections.synchronizedMap(new HashMap<>());
    }
}
