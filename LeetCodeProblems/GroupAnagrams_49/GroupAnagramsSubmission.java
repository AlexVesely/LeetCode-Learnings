package LeetCodeProblems.GroupAnagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagramsSubmission {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> anagrams = new HashMap<>();

        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);

            String key = new String(arr);

            if (anagrams.get(key) == null) {
                anagrams.put(key, new ArrayList<>());
            }

            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
