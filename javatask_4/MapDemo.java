package javatask_4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapDemo {
    public static void main(String[] args) {

        // 🔹 HashMap Example
        Map<Integer, String> studentMap = new HashMap<>();

        studentMap.put(101, "Rahul");
        studentMap.put(102, "Amit");
        studentMap.put(103, "Neha");

        System.out.println("HashMap Data:");
        for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 🔹 Data Lookup
        int keyToSearch = 102;
        if (studentMap.containsKey(keyToSearch)) {
            System.out.println("\nFound: " + studentMap.get(keyToSearch));
        } else {
            System.out.println("\nKey not found");
        }

        // 🔹 TreeMap Example (Sorted)
        Map<Integer, String> sortedMap = new TreeMap<>();
        sortedMap.putAll(studentMap);

        System.out.println("\nTreeMap (Sorted Data):");
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}