//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
     int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[N][N];
        
        for(int i=1; i<N; i++){
            dp[i][i] = 0;
        }
        
        for(int i = N-1; i>= 1; i--){
            
            for(int j = i +1; j<N; j++){
                
                int min = (int) 1e9;
                
                for(int k = i; k<= j-1; k++){
                    
                    int a = dp[i][k] + dp[k+1][j] 
                    + arr[i-1]* arr[k] * arr[j];
                    
                    min = Math.min(a, min);
                }
                
                dp[i][j] = min;
                
            }
            
        }
        
        return dp[1][N-1];
    }
    
    int mulitply(int start, int end, int[] arr, int[][] dp ) {
        
        if(start == end) return 0;
        
        if(dp[start][end] != -1) return dp[start][end];
        
        int min_steps = (int) 1e9;
        
        for(int k = start; k<= end -1; k++){
            
            int partition_one_stps = mulitply(start, k, arr, dp);
            int partition_two_stps = mulitply(k + 1, end, arr, dp);
            
            int multiply_paritions = arr[start-1] * arr[k] * arr[end];
            
            int totoal = partition_one_stps + partition_two_stps 
            + multiply_paritions;
            
            min_steps = Math.min(min_steps, totoal);
            
        }
        
        return dp[start][end] = min_steps;
    }
    
}