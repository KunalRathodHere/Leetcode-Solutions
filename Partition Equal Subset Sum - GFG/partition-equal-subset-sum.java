//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        // code here
        int total = 0;
        for(int i=0; i<N; i++){
            total += arr[i];
        }
        if(total % 2 != 0) return 0;
        
        int target = total/2;
        Boolean[][] dp = new Boolean[N + 1][target + 1];
        for(int i=0; i<=N; i++){
            for(int j=0; j<=target; j++) dp[i][j] = null;
        }
        
        boolean ans = function(0, target, arr, dp);
        
        
        return (ans) ? 1 : 0;
        
    }
    
    static boolean function(int idx, int target, int[] arr, Boolean[][] dp ) {
        
        if(target == 0) return dp[idx][target] = true;
        
        if(target < 0) return false;
        if(idx == arr.length) return dp[idx][target] = false;
        
        if(dp[idx][target] != null) return dp[idx][target];
        
        boolean take = function(idx + 1, target - arr[idx], arr, dp);
        boolean not_take = function(idx + 1, target, arr, dp);
        
        return dp[idx][target] = take || not_take;
        
    }
    
}