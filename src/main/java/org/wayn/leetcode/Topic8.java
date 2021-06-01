package org.wayn.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
 * 返回整数作为最终结果。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Topic8 {
    public static void main(String[] args) {
//        System.out.println(Solution.myAtoi("9581"));
//        System.out.println(Solution.myAtoi("-42"));
//        System.out.println(Solution.myAtoi("     -42"));
//        System.out.println(Solution.myAtoi("42"));
//        System.out.println(Solution.myAtoi("3.14159"));
//        System.out.println(Solution.myAtoi("4193 with words"));
//        System.out.println(Solution.myAtoi("words and 987"));
//        System.out.println(Solution.myAtoi("-91283472332"));
//        System.out.println(Solution.myAtoi("+-12"));
//        System.out.println(Solution.myAtoi("-+12"));
//        System.out.println(Solution.myAtoi("00000-42a1234"));
//        System.out.println(Solution.myAtoi("  -0012a42"));
//        System.out.println(Solution.myAtoi("   +0 123"));
        System.out.println(Solution.myAtoi("9223372036854775808"));
//        System.out.println(Solution.myAtoi("  +  413"));
//        System.out.println(Solution.myAtoi("-9223372036854775809"));
//        System.out.println(Solution.myAtoi("18446744073709551617"));
    }

    static class Solution {
        public static int myAtoi(String s) {
            long result = 0;
            boolean flag = false;
            int sign = 0;
            final List<String> intList = Arrays.asList("0" , "1" , "2" , "3" , "4" , "5" ,"6" , "7" , "8" , "9");
            final List<String> charList = Arrays.asList("A" , "B" ,
                    "C" , "D" , "E" , "F" , "G" , "H" ,
                    "I" , "J" , "K" , "L" , "M" , "N" ,
                    "O" , "P" , "Q" , "R" , "S" , "T" ,
                    "U" , "V" , "W" , "X" , "Y" , "Z", "a" , "b" ,
                    "c" , "d" , "e" , "f" , "g" , "h" ,
                    "i" , "j" , "k" , "l" , "m" , "n" ,
                    "o" , "p" , "q" , "r" , "s" , "t" ,
                    "u" , "v" , "w" , "x" , "y" , "z");
            for (int i = 0; i < s.length(); i++) {
                String substring = s.substring(i, i + 1);
                if (" ".equals(substring)){
                    if (flag){
                        break;
                    }
                    continue;
                }
                if (charList.contains(substring)){
                    break;
                }
                if ("-".equals(substring)){
                    if (sign == 1 || flag){
                        break;
                    }
                    sign = -1;
                    flag = true;
                    continue;
                }
                if ("+".equals(substring)){
                    if (sign == -1 || flag) {
                        break;
                    }
                    sign = 1;
                    flag = true;
                    continue;
                }
                if (intList.contains(substring)){
                    flag = true;
                    if (result*10 < 0 || result*10 + Integer.parseInt(substring) < 0){
                        if (sign < 0){
                            return Integer.MIN_VALUE;
                        }else {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result*10 + Integer.parseInt(substring);
                }
                if (".".equals(substring)){
                    break;
                }
            }
            if (result > 0){
                if (sign == 0){
                    sign = 1;
                }
                result = result * sign;
                if (result > 0 && sign < 0){
                    return Integer.MIN_VALUE;
                }
            }
            if (result > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
            if (result < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            return (int)result;
        }

}
}
