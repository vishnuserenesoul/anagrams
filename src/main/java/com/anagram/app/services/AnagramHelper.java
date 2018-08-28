package com.anagram.app.services;

import com.sun.prism.shader.Solid_ImagePattern_Loader;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AnagramHelper {


    public static Set<String> getAnagramsFromDictionary(String input)  {

        return StringPermutations.get(input).stream().filter( key -> !input.equals(key)&& Dictionary.getInstance().contains(key)).collect(Collectors.toCollection(TreeSet::new));


    }

//    public static void main(String[] args) {
//        for (Object s:
//        Dictionary.getInstance().withInitializedData("https://users.cs.duke.edu/~ola/ap/linuxwords").keys()) {
//            List<String> out = getAnagramsFromDictionary(String.valueOf(s));
//            if(out!=null && out.size()>0)
//            {
//                System.out.println(out.toArray().toString());
//            }
//        }
//    }

}
