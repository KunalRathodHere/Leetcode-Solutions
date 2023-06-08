//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        // Code here
        
        int[][] dp = new int[nums.length+1][k+1];
        
        for(int[] temp: dp) Arrays.fill(temp, -1);
        
        
        int ans = function(0, k, nums, k, dp);
        return ans;
        
    }
    
    public int function(int idx, int remL, int[] nums, int k, int[][] dp ) {
        
        int n = nums.length;
        if(idx ==n - 1){
            if(nums[idx] < remL) return  dp[idx][remL] = 0;
            else  return  dp[idx][remL] =  remL * remL;
        }
        
        if(dp[idx][remL] != -1) return dp[idx][remL];
        
        int curr = nums[idx];
        if(curr < remL ){
            int curr_line = function(idx + 1, remL == k ? remL - curr : remL - curr - 1, nums, k, dp);
            int new_line = remL * remL + function(idx + 1, k - curr, nums, k, dp);
            
            return dp[idx][remL] = Math.min(curr_line, new_line);
            
        }
        else{
            return dp[idx][remL] = remL * remL + function(idx+1, k - curr, nums, k, dp);
        }
        
        
    }
    
    // public int function(int idx, int[] nums, int k){
        
    //     if(idx >= nums.length ) return 0;
        
    //     int ans = Integer.MAX_VALUE;
    //     int takeone = (k - nums[idx])* (k - nums[idx]) + function(idx + 1, nums, k);
    //     ans = Math.min(ans, takeone);
        
    //     int curr = nums[idx];
    //     for(int i = idx+1; i<nums.length; i++){
    //         curr += nums[i];
    //         if(k >= curr  + (i - idx) ){
                
    //             if(i == nums.length - 1){
    //                 return 0;
    //             }
                
    //             int curr_cost = (k - curr - (i - idx))*(k - curr  - (i - idx)) + function(i+1, nums, k);
            
    //             ans = Math.min(curr_cost, ans);
    //         }
    //         else{
    //             break;
    //         }
            
    //     }
        
    //     return ans;
        
    // }
}