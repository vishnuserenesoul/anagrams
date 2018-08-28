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

}
