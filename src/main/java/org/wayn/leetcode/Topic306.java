package org.wayn.leetcode;

import java.util.Arrays;

public class Topic306 {
    public static void main(String[] args) {
//        System.out.println(Solution.isAdditiveNumber("112358"));
//        System.out.println(Solution.isAdditiveNumber("199100199"));
//        System.out.println(Solution.isAdditiveNumber("1023"));
//        System.out.println(Solution.isAdditiveNumber("101"));
//        System.out.println(Solution.isAdditiveNumber("0235813"));
//        System.out.println(Solution.isAdditiveNumber("11235813213455890144"));
//        System.out.println(Solution.isAdditiveNumber("121474836472147483648"));
//        System.out.println(Solution.isAdditiveNumber("199100199"));
//        System.out.println(Solution.isAdditiveNumber("1023"));
//        System.out.println(Solution.isAdditiveNumber("199001200"));
        System.out.println(Solution.isAdditiveNumber("11111111111011111111111"));
//        System.out.println(Solution.getInts("1", 10));
   }


    static class Solution {
        public static boolean isAdditiveNumber(String num) {
            if (num.length() < 3){
                return false;
            }
            if (num.length() == 3){
                Integer a1 = Integer.valueOf(num.substring(0,1));
                Integer a2 = Integer.valueOf(num.substring(1,2));
                Integer a3 = Integer.valueOf(num.substring(2,3));
                return a1+a2 == a3;
            }
            int maxSub = num.length()/2 + 1;
            boolean checkOverflow = false;
//            if (maxSub >= 10){
//                maxSub = 10;
//                checkOverflow = true;
//            }
            for (int i = 1; i <= maxSub; i++) {
                if (num.startsWith("0") && i > 1){
                    return false;
                }
                for (int j = 1; j <= num.length()-maxSub-1; j++) {
                    if ("0".equals(num.substring(i, i+1)) && j > 1){
                        continue;
                    }
                    String s1 = num.substring(0, i);
                    String s2 = num.substring(i, i+j);
                    if (i+j> num.length()-1){
                        continue;
                    }
//                    if (checkOverflow){
//                        if (Long.valueOf(s1) > Integer.MAX_VALUE || Long.valueOf(s2) > Integer.MAX_VALUE){
//                            continue;
//                        }
//                    }
                    if (additiveNumberCheck(s1, s2, num.substring(i+j))){
                        return true;
                    }
                }
            }
            return false;
        }
        // String类型加法
        public static boolean additiveNumberCheck(String n1, String n2, String num){
            int maxLength = n1.length()> n2.length()?n1.length():n2.length();
            int[] bytes1 = getInts(n1, maxLength);
            int[] bytes2 = getInts(n2, maxLength);
            int[] next = new int[maxLength+1];
            boolean isCarry = false;
            for (int i = maxLength-1; i > -1; i--) {
                int f1 = i >= bytes1.length?0:bytes1[i];
                int f2 = i >= bytes2.length?0:bytes2[i];
                int sum = f1 + f2;
                if (isCarry){
                    sum += 1;
                    isCarry = false;
                }
                if (sum >= 10){
                    sum -=10;
                    isCarry = true;
                }
                next[i+1] = (byte) sum;
            }
            if (isCarry){
                next[0] = 1;
            }
            if (next[0] == 0){
                int[] nextswap = new int[maxLength];
                for (int i = 0; i < maxLength; i++) {
                    nextswap[i] = next[i+1];
                }
                next = nextswap;
            }
            String numString = Arrays.toString(next).replaceAll(",","").replace("[","").replaceAll("]","").replaceAll(" ","");
            if(num.startsWith(numString)){
                if (numString.equals(num)){
                    return true;
                }
                return additiveNumberCheck(n2, numString, num.substring(numString.length()));
            }
            return false;
        }

        public static int[] getInts(String s,Integer length){
            int[] ints = new int[length];
            for (int i = length-s.length(); i < length; i++) {
                ints[i] = Integer.parseInt(s.substring(i-length+s.length(), i-length+s.length()+1));
            }
            return ints;
        }

        public boolean isAdditiveNumber0(String num) {
            return dfs(num, num.length(), 0, 0, 0, 0);
        }

        /**
         * @param num    原始字符串
         * @param len    原始字符串长度
         * @param idx    当前处理下标
         * @param sum    前面的两个数字之和
         * @param pre    前一个数字
         * @param k      当前是处理的第几个数字
         */
        private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
            if (idx == len) {
                return k > 2;
            }
            for (int i = idx; i < len; i++) {
                long cur = fetchCurValue(num, idx, i);
                // 剪枝：无效数字
                if (cur < 0) {
                    continue;
                }
                // 剪枝：当前数字不等于前面两数之和
                if (k >= 2 && cur != sum) {
                    continue;
                }
                if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {
                    return true;
                }
            }
            return false;
        }

        /**
         * 获取 l ~ r 组成的有效数字
         */
        private long fetchCurValue(String num, int l, int r) {
            if (l < r && num.charAt(l) == '0') {
                return -1;
            }
            long res = 0;
            while (l <= r) {
                res = res * 10 + num.charAt(l++) - '0';
            }
            return res;
        }
    }
}
