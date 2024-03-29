//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2, n, m));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int longestCommonSubstr(String text1, String text2, int n, int m){
        // code here
        
                int[][] dp = new int[text1.length() +1][text2.length() +1];
        
        // for(int[] arr: dp){
        //     Arrays.fill(arr, 0);
        // }

        int idx1 =text1.length();
        int idx2 =text2.length();

        for(int i=0; i<=idx1; i++){
            dp[i][0] = 0;
        }

        for(int i =0; i<=idx2; i++){
            dp[0][i] = 0;
        }

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=idx1; i++){
            for(int j =1; j<=idx2; j++){

                if(text1.charAt(i-1) ==  text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i -1 ][j -1];
                    
                }
                else{
                    dp[i][j] = 0;
                }
                
                max = Math.max(max, dp[i][j]);

            }
        }

        return max;

        
        
    }
}