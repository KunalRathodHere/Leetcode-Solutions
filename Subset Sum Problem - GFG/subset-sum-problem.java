//{ Driver Code Starts
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
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{


    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        
        Boolean[][] dp  = new Boolean[N+1][sum +1];
        for(Boolean[] a: dp){
            Arrays.fill(a, null);
        }
        return function(arr.length -1, arr, sum, dp);
    }
    
    static Boolean function(int idx, int arr[], int target, Boolean[][] dp ){
        
        if(target < 0) return false;
        if(idx == 0)  return (arr[0] == target); 
        if(idx >= arr.length) return false;
        if(target == 0) return true;
        
        if(dp[idx][target] != null) return dp[idx][target];
        
        return  dp[idx][target] = (function(idx -1, arr, target, dp) || function(idx -1, arr, target - arr[idx], dp));
        
    }
    
    // static Boolean isSubsetSum(int N, int arr[], int sum){
        
        
        
    // }
}