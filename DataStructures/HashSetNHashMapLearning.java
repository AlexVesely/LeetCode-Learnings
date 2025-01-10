package DataStructures;

import java.util.HashMap;
import java.util.HashSet;

public class HashSetNHashMapLearning {
    // Why is Searching in Hashing so quick?
    // When looking up a key, the hash function takes the key, computes the hash
    // and directly accesses the index in the key.

    // A Hash Map is a data structure with key-value pairs
    // Keys are unique and map to a specific value
    // O(1) insertion, deletion, retrieval
    public static void basicHashMapExample() {
        HashMap<String, Integer> map = new HashMap<>();

        // Insert key-value pairs
        map.put("apple", 1);
        map.put("banana", 22);
        map.put("cherry", 6);

        System.out.println("Banana count: " + map.get("banana")); // Output: 22

        System.out.println("Contains apple? " + map.containsKey("apple")); // Output: true

        map.remove("cherry");

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }
    }

    // A Hash Set is like a HashMap but only stores unique elements
    // Useful for problems checking if a value is present or duplicates
    public static void basicHashSetExample() {
        // Create a HashSet
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);

        System.out.println("Contains 20? " + set.contains(20)); // Output: true

        set.remove(20);

        for (int num : set) {
            System.out.println(num);
        }
    }

    //COMMON HASHING PROBLEMS

    // Given an array of ints check if it contains a duplicate
    // Use a Hash Set and not a Hash Map as we do not need to store keys
    public static boolean hasDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    // Count the frequency of characters in a string
    // Use a Hash Map and not a Hash Set as each char (the key) needs to be associated with its value (count)
    public static void charFrequency(String str) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // .getOrDefault returns the value from the key or default if the key leads nowhere
        for (char c : str.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        for (char c : freqMap.keySet()) {
            System.out.println(c + ": " + freqMap.get(c));
        }
    }

    public static void main(String[] args) {
        charFrequency("hsoaojbfpaibgfebgfurabcdefghijklmnopqrstuvwxzyyasdhwrhgfiwgifvbiv");
    }

}
