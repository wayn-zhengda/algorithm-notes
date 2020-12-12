package org.wayn.leetcode;

/**
 * 整数反转
 */
public class Topic7 {

    public static int reverse2(int x) {
        if (-10< x && x <10){
            return x;
        }
        long[] nums = new long[12];
        int i = 0;
        do {
            nums[i] = x%10;
            i++;
            x = x/10;
        }while (x!=0);
        long reverseNum = 0L;
        for (int j = 0; j < i; j++) {
            int unit = 1;
            for (int k = 1; k < i-j; k++) {
                unit = unit*10;
            }
            reverseNum += nums[j]*unit;
        }
        if (reverseNum > 0x7fffffff || reverseNum < 0x80000000){
            return 0;
        }
        x = (int) reverseNum;
        return x;
    }


    public int reverseo(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            // 这一步判断是否大于Integer.MAX_VALUE/10 或者小于Integer.MIN_VALUE/10  不通过则下一步*10一定会越界。
            // (rev == Integer.MAX_VALUE / 10 && pop > 7)、(rev == Integer.MIN_VALUE / 10 && pop < -8)属于写死了的,已知Integer.MAX_VALUE和Integer.MIN_VALUE的最后一位是多少
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
