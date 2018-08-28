package com.anagram.app.services;

import java.util.*;

public class StringPermutations {

    public static List<String> get(String s) {

        List<String> strings = new ArrayList<>();
        if(s!=null) {
            permute(s,0, s.length()-1,strings);
        }

        return strings;

    }


    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private  static void permute(String str, int l, int r,List<String> strings)
    {
        if (l == r)
            strings.add(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                permute(str, l+1, r,strings);
                str = swap(str,l,i);
            }
        }
    }

    /**
     * Swap Characters at position
     * @param a string value
     * @param i position 1
     * @param j position 2
     * @return swapped string
     */
    public static  String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
       List<String> strings= StringPermutations.get("abc");
       for (String s: strings)
           System.out.println(s);

    }
}