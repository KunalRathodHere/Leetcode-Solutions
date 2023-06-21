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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    int[][] dp = new int[n][n];
	    for(int[] temp: dp) Arrays.fill(temp, -1);
	    
	    
	    int sol = list(0, -1, arr, dp);
	    
	    
	    return sol;
	   // return ans;
	}  
	
	
	int ans= (int) -1e9;
	public int list(int curr, int prev, int[] arr, int[][] dp){
	    
	    if(curr == arr.length){
	       // ans = Math.max(ans, curr_sum);
	        return 0;
	    }
	    
	    if(prev != -1 && dp[curr][prev] != -1) return dp[curr][prev];
	    
	    //take if possible
	    int take = (int) -1e9;
	    if(prev != -1 && arr[curr] > arr[prev]){
	        
	       // ans = Math.max(ans, curr_sum + arr[curr]);
	        take = arr[curr] + list(curr+1, curr, arr, dp);
	    } 
	    
	    if(prev ==  -1){
	        take = arr[curr] + list(curr + 1, curr, arr, dp); 
	    }
	    
	    int not_take = list(curr + 1, prev, arr, dp);
	    
	   // ans = Math.max(take, not_take);
	    if(prev != -1) dp[curr][prev]=  Math.max(take, not_take);
	   
	    return Math.max(take, not_take);
	    
	}
	
}