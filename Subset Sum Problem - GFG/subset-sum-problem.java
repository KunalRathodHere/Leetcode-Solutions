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
        
        int[][] dp = new int[N+1][sum+1];
        
        for(int[] temp: dp) Arrays.fill(temp, -1);
        
        return function(0, arr, sum, dp);
      
        
        
    }
    
    static boolean function(int idx, int[] arr, int target, int[][] dp ){
        
        if(target == 0) {
            dp[idx][target] = 1;
            return true;
        }
        if(idx > arr.length -1) return false;
        
        if(target < 0) return false;
        
        
        if(dp[idx][target] != -1) {
            
            return dp[idx][target] == 1 ? true : false;
            
        }
        
        
        boolean take = function(idx + 1, arr, target - arr[idx], dp);
        boolean nottake = function(idx+1, arr, target, dp);
        
        
        if(take || nottake) dp[idx][target] = 1;
        else dp[idx][target]= 0;
        
        return take || nottake;
 }
} 