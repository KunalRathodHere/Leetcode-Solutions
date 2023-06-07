//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0)
        {
            String wild = in.readLine();
            String pattern = in.readLine();
            
            Solution ob = new Solution();
            boolean flag = ob.match(wild, pattern);
            if(flag)
            System.out.println("Yes");
            else
            System.out.println("No");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public boolean match(String wild, String pattern)
    {
        // code here
        
        Boolean[][] dp = new Boolean[wild.length()+1][pattern.length()+1];
        
        for(Boolean[] temp: dp) Arrays.fill(temp, null);
        
        boolean ans = function(0, 0, wild, pattern, dp);
        
        return ans;
        
        
    }
    
    public boolean function(int i, int j, String A, String B, Boolean[][] dp ) {
        
        int n = A.length();
        int m = B.length();
        
        if( i>= n && j >= m ) return true;
        if(i >= n && j < m) return false;
        if(j >= m && i < n){
            for(int k = i; k<n; k++){
                if(A.charAt(k) != '*') return false;
            }
            return true;
        }
        
        
        if(dp[i][j] != null) return dp[i][j];
        
        if(A.charAt(i) == B.charAt(j) || A.charAt(i) == '?'){
            return  dp[i][j] = function(i+1, j+1, A, B, dp);
        }
        
        if(A.charAt(i) == '*'){
            return  dp[i][j] = function(i + 1, j, A, B, dp) ||  function(i, j+1, A, B, dp);
        }
        
        return dp[i][j] = false;
        // if(i == A.length() && j == B.length()) return true;
        // if(i == A.length() && A.charAt(i-1) == '*') return true;
        // if(j == B.length() && B.charAt(j-1) == '*') return true;
        
        // if(i == A.length() || j == B.length()) return false;
     
        // if(dp[i][j] != null) return dp[i][j];
     
        // char a = A.charAt(i);
        // char b = A.charAt(j);
        
        // boolean ans = false;
        
        // if(a == '*'){
            
        //         ans = ans || function(i+1, j, A, B, dp) || function(i, j + 1, A, B, dp);
        //         if(ans){
        //             return dp[i][j] = true;
        //         }
            
        // }
        // else if(b == '*'){
            
        //         ans = ans || function(i, j+1, A, B, dp) || function(i+1, j, A, B, dp) ;
            
        //         if(ans){
        //             return dp[i][j] = true;
        //         }
            
        // }
        
        // else if(a == '?' || b == '?'){
        //     ans = ans || function(i + 1, j + 1, A, B, dp);
        
        //     if(ans){
        //         return dp[i][j] = true;
        //     }
        // }
        // else if(a == b){
        //     ans = ans || function(i+1, j+1, A, B, dp);
        
        //     if(ans){
        //         return dp[i][j] = true;
        //     }
        // }
        // else if(a != b){
        //     ans = false;
        //     return dp[i][j]= ans;
        // }
        
        // return dp[i][j] = false;
    }
}