//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToInfix(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToInfix(String postfix) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        while(i < postfix.length()){
            char ch = postfix.charAt(i);

            if(isOperand(ch)){
                stack.push(ch+"");

            }else{
                String second = stack.pop();
                String first = stack.pop();
                String answer = '(' + first + ch + second + ')';
                stack.push(answer);
            }
            i++;
        }
        return stack.pop();
    }

    private static boolean isOperand(char ch){
        if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')){
            return true;
        }
        return false;
        
    }
}
