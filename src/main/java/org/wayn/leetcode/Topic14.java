package org.wayn.leetcode;

import java.util.Arrays;

public class Topic14 {
    public static void main(String[] args) {
//        System.out.println(Solution.longestCommonPrefix(new String[]{"flower","flow","flight"}));
//        System.out.println(Solution.longestCommonPrefix(new String[]{"dog","racecar","car"}));
//        System.out.println(Solution.longestCommonPrefix(new String[]{}));
//        System.out.println(Solution.longestCommonPrefix(new String[]{""}));
//        System.out.println(Solution.longestCommonPrefix(new String[]{"a"}));
        System.out.println(Solution.longestCommonPrefix(new String[]{"ab", "a"}));

    }

    static class Solution {
        public static String longestCommonPrefix(String[] strs) {
            if (null == strs || strs.length == 0){
                return "";
            }
            if (strs.length == 1){
                return strs[0];
            }
            for (int i = 1;i<=strs[0].length(); i++) {
                if ("".equals(strs[0])){
                    return strs[0];
                }
                String prefix = strs[0].substring(0,i);
                for (int j = 0; j < strs.length; j++) {
                    if (strs[j].startsWith(prefix)){
                        continue;
                    }else {
                        return prefix.substring(0, prefix.length()-1);
                    }
                }
            }
            return strs[0];
        }
    }

    /**
     * class Solution {
     *     public String longestCommonPrefix(String[] strs) {
     *         String a = "";
     *         try {
     *             a = strs[0];
     *             for (String str : strs) {
     *                 // 若a已经减为""，则说明无公共前缀，直接返回
     *                 if (a == "") return a;
     *                 // 若a在当前str中匹配不上，则减少字符串a的长度，再次尝试匹配
     *                 while (!str.startsWith(a)) {
     *                     a = a.substring(0,a.length() - 1);
     *                 }
     *             }
     *             return a;
     *         } catch (Exception e) {
     *             return a;
     *         }
     *     }
     * }
     *
     */



}
