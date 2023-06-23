//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String reverse(String S){
        
        String reversed = "";
        
        for(int i = S.length()-1; i>= 0; i--){
            reversed += S.charAt(i);
        }
        return reversed;
    }
    
    public int longestPalinSubseq(String S)
    {
        //code here
        String reversed = reverse(S);
        int n = S.length();
        
        int[][] dp = new int[n+1][n+1];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        
        return lps(n-1, n-1,  S, reversed, dp);
        
    }
    
    public int lps(int i, int j, String A, String B, int[][] dp ) {
        
        if(i < 0 || j < 0) return 0;
        
        if(dp[i+1][j+1] != -1) return dp[i+1][j+1];
        
        int take = (int) -1e9;
        if(A.charAt(i) == B.charAt(j)){
            take = 1 + lps(i -1, j-1, A, B, dp);
            return dp[i+1][j+1] =  take;
        }
        
        //shift A
        int shift_a = lps(i-1, j, A, B, dp);
        int shift_b = lps(i, j-1, A, B, dp);
        
        return dp[i+1][j+1] = Math.max(shift_a, shift_b);
        
    }
}