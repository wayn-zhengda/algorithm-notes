package org.wayn.leetcode;

public class Topic20 {
    public static void main(String[] args) {
        System.out.println(Solution.isValid("()"));
        System.out.println(Solution.isValid("()[]{}"));
        System.out.println(Solution.isValid("(]"));
        System.out.println(Solution.isValid("([)]"));
        System.out.println(Solution.isValid("{[]}"));
        System.out.println(Solution.isValid("}"));

    }

    static class Solution {
        public static boolean isValid(String s) {
            StringBuffer parttens = new StringBuffer();
            for (int i = 0; i < s.length(); i++) {
                String sub = s.substring(i, i+1);
                switch (sub){
                    // 符合条件的括号肯定是成对出现的
                    // 左括号, 入栈
                    case "(":
                    case "{":
                    case "[":
                        parttens.append(sub);
                        break;
                    case ")":
                        if (parttens.toString().endsWith("(")){
                            parttens = parttens.delete(parttens.length()-1, parttens.length());
                        }else {
                            return false;
                        }
                        break;
                    case "}":
                        if (parttens.toString().endsWith("{")){
                            parttens = parttens.delete(parttens.length()-1, parttens.length());
                        }else {
                            return false;
                        }
                        break;
                    case "]":
                        if (parttens.toString().endsWith("[")){
                            parttens = parttens.delete(parttens.length()-1, parttens.length());
                        }else {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
            return parttens.length() == 0;
        }
    }
}
