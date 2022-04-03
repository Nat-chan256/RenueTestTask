package ru.moskovka.airportbrowser.util;

public class LineSearchAlgorithm {

    /**
     * Checks if line contains another line.
     * @param str the line to check
     * @param substr supposed substring
     * @return true if substr is a substring of str
     */
    public static boolean KMP(String str, String substr){
        int k = 0;
        int[] pi = prefixFunction(str);
        for (int i = 0; i < str.length(); ++i){
            while (k >= 0 && str.charAt(i) != substr.charAt(k) && k != pi[k])
                k = pi[k];
            if (str.charAt(i) == substr.charAt(k))
                k = k + 1;
            if (k == substr.length()){
                return true;
            }
        }
        return false;
    }

    public static int[] prefixFunction(String str){
        int[] prefix = new int[str.length()];
        for (int i = 0; i < str.length(); ++i)
            prefix[i] = 0;
        for (int i = 1; i < str.length(); ++i){
            int k = prefix[i-1];
            while (k > 0 && str.charAt(k) != str.charAt(i))
                k = prefix[k-1];
            if (str.charAt(k) == str.charAt(i))
                k++;
            prefix[i] = k;
        }
        return prefix;
    }
}
