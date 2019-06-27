
//Two strings are called anagrams if they contain all the same characters in the same frequencies

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class AnagramsSolution {

    static boolean isAnagram(String a, String b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }
        if (a.length() != b.length())
            return false;
        a = a.toLowerCase();
        b = b.toLowerCase();
        Map<Character, Integer> m = new HashMap<>();

        for (int i = 0; i < b.length(); i++) {
            char currentLetter = b.charAt(i);

            if (!m.containsKey(currentLetter)) {
                m.put(currentLetter, 1);
            } else {
                Integer frequency = m.get(currentLetter);
                m.put(currentLetter, ++frequency);
            }
        }

        for (int i = 0; i < a.length(); i++) {
            char currentLetter = a.charAt(i);

            if (!m.containsKey(currentLetter)) {
                return false;
            }

            Integer frequency = m.get(currentLetter);

            if (frequency == 0) {
                return false;
            } else
                m.put(currentLetter, --frequency);
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String firstString = scanner.next();
        String secondString = scanner.next();
        scanner.close();
        if (isAnagram(firstString, secondString) == true) {
            System.out.println("Anagrams");
        }
    }
}
