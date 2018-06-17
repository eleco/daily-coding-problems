package problem103;

import java.util.HashMap;
import java.util.Map;

public class Main {

    //Given a string and a set of characters, return the shortest substring containing all the characters in the set.
    //For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".

    public static void main(String[] args) {
        System.out.println(shortestSubstring("figehaeci", "aei"));
    }

    private static String shortestSubstring(String input, String pattern) {

        int minLength = input.length();
        String ret = input;

        Map<Character, Integer> histoPattern = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            histoPattern.merge(pattern.charAt(i), 1, Integer::sum);
        }

        Map<Character, Integer> histoInput = new HashMap<>();

        int start = 0;
        for (int i = 0; i < input.length(); i++) {

            histoInput.merge(input.charAt(i), 1, Integer::sum);

            boolean patternMatch = histoPattern.entrySet().stream().
                    allMatch(x -> histoInput.get(x.getKey()) != null && x.getValue() <= histoInput.get(x.getKey()));

            if (patternMatch) {

                while (histoPattern.get(input.charAt(start)) == null ||
                        histoInput.get(input.charAt(start)) > histoPattern.get(input.charAt(start))) {

                    Character r = input.charAt(start);
                    if (histoInput.get(r) != null && histoPattern.get(r) != null && histoInput.get(r) > histoPattern.get(r)) {
                        histoInput.merge(r, -1, Integer::sum);
                    }
                    start++;
                }

                if (i - start + 1 < minLength) {
                    ret = input.substring(start, i + 1);
                    minLength = i - start + 1;
                }
            }
        }
        return ret;
    }
}
