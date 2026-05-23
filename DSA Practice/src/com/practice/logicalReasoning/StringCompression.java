package com.practice.logicalReasoning;
// leetcode - 443
public class StringCompression {
    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};
        // output : aabbccc -> a2b2c3 -> [a,2,b,2,c,3]
        System.out.println(compress(chars));
    }
    public static int compress(char[] chars) {
            // looping over the chars array
            int read = 0;
            int write = 0;
            while (read < chars.length) {
                char ch = chars[read];
                int count = 0;
                while (read < chars.length && chars[read] == ch) {
                    count++;
                    read++;
                }
                // now let's make the change in the input array
                chars[write++] = ch;
                // if count is greater than 1 (i.e; aaa -> a3)
                if (count > 1){
                    String freq = String.valueOf(count);
                    for(char c:freq.toCharArray()){
                        chars[write++]=c;
                    }
                }
            }
            return write;
    }
}