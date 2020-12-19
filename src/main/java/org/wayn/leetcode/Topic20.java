package org.wayn.leetcode;

import sun.misc.Unsafe;

public class Topic20 {
    public static void main(String[] args) {
//        System.out.println(Solution.isValid("()"));
//        System.out.println(Solution.isValid("()[]{}"));
//        System.out.println(Solution.isValid("(]"));
//        System.out.println(Solution.isValid("([)]"));
//        System.out.println(Solution.isValid("{[]}"));
//        System.out.println(Solution.isValid("}"));
        Unsafe unsafe = Unsafe.getUnsafe();
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

    /**
     * public boolean isValid(String s) {
     *         if(s.isEmpty())
     *             return true;
     *         Stack<Character> stack=new Stack<Character>();
     *         for(char c:s.toCharArray()){
     *             if(c=='(')
     *                 stack.push(')');
     *             else if(c=='{')
     *                 stack.push('}');
     *             else if(c=='[')
     *                 stack.push(']');
     *             else if(stack.empty()||c!=stack.pop())
     *                 return false;
     *         }
     *         if(stack.empty())
     *             return true;
     *         return false;
     *     }
     */
}
