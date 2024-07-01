import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        final var anagrams = new HashMap<String, List<String>>();
        for (var str : strs) {
            final var sortedStr = stringHash(str);
            anagrams.computeIfAbsent(sortedStr, k -> new ArrayList<String>()).add(str);
        }

        return new ArrayList<>(anagrams.values());
    }

    protected String stringHash(String string) {
        final var frequencyArray = new char[26];
        for (int i = 0; i < string.length(); ++i) {
            ++frequencyArray['z' - string.charAt(i)];
        }

        final var idBuilder = new StringBuilder();
        for (char c : frequencyArray) {
            idBuilder.append(c);
        }

        return idBuilder.toString();
    }
}

