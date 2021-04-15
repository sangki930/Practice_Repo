package Leetcode.Fibonacci_Number;

class Solution {
    int dp[]=new int[31];
    
    public int fib(int n) {
        if(n<=1)
            return dp[n]=n;
        return dp[n]=fib(n-1)+fib(n-2);
    }
}
