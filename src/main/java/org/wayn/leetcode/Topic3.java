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

        // https://pic.leetcode-cn.com/36efcc3cc13acb0bc572a1ed9139b51cd00ad4502c70ac0a98d38c7de4765076-%E5%BE%AE%E4%BF%A1%E6%88%AA%E5%9B%BE_20190516154813.png
        public int lengthOfLongestSubstringo(String s) {
            int i = 0;
            int flag = 0;
            int length = 0;
            int result = 0;
            while (i < s.length()) {
                int pos = s.indexOf(s.charAt(i),flag);
                if (pos < i) {
                    if (length > result) {
                        result = length;
                    }
                    if (result >= s.length() - pos - 1) {
                        return result;
                    }
                    length = i - pos - 1;
                    flag = pos + 1;
                }
                length++;
                i++;
            }
            return length;
        }

    }
}
