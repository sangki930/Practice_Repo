package Leetcode.RemoveAllAdjacentDuplicatesInString;

import java.util.Stack;

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        
        for(int j=0; j<s.length();j++){
            char ch = s.charAt(j);
            
            if(!stack.isEmpty() && stack.peek()==ch){
                stack.pop();
            }else
                stack.add(ch);
            
        }
        StringBuilder sb = new StringBuilder();
        
        for(char c : stack){
            sb.append(c+"");
        }
        
        return sb.toString();
    }
}