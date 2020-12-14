package org.wayn.leetcode;

public class Topic3 {
    public static void main(String[] args) {
        System.out.println(Solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(Solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(Solution.lengthOfLongestSubstring("baaaaa"));
        System.out.println(Solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(Solution.lengthOfLongestSubstring("au"));
        System.out.println(Solution.lengthOfLongestSubstring("aab"));
    }

    static class Solution {
        public static int lengthOfLongestSubstring(String s) {
            if (null == s || s.length() == 0){
                return 0;
            }
            byte[] bytes = s.getBytes();
            int longestNum = 1;
            for (int i = 0; i < bytes.length; i++) {
                for (int j = i+1; j < bytes.length; j++) {
                    boolean indexOf = false;
                    for (int k = i; k < j; k++) {
                        if (bytes[k] == bytes[j]){
                            indexOf = true;
                           break;
                        }
                    }
                    if (indexOf){
                        break;
                    }
                    int longn = j-i+1;
                    if (!indexOf && longn > longestNum){
                        longestNum = longn;
                    }
                }
            }
            return longestNum;
        }
    }
}
