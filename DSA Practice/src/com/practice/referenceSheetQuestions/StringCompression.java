package com.practice.referenceSheetQuestions;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

/*
"Convert a string as given in the format below:
    Example:
        aabbb into a2b3
        aaaa into a4
        a into a1"
 */
public class StringCompression {
    public static void main(String[] args){
        String str = "baaabbbaa";


        // Ouput : b4a5
//        String compressedStr = str.chars()
//                                    .mapToObj(c->(char)c)
//                                    .collect(Collectors.groupingBy(
//                                            c->c,
//                                            LinkedHashMap::new,
//                                            Collectors.counting()
//                                    ))
//                                    .entrySet()
//                                    .stream()
//                                    .map(e-> e.getKey() + "" + e.getValue())
//                                    .collect(Collectors.joining());
//
//        System.out.println(compressedStr);

        // but output should be b1a3b3a2

    }
}
