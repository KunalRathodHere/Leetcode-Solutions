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
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
     int maximumPath(int N, int Matrix[][])
    {
        // code here
        int[][] dp = new int[Matrix.length + 1][Matrix[0].length + 1];
        for(int[] temp: dp) Arrays.fill(temp, -1);
        
        int max = 0;
        for(int j = 0; j<Matrix[0].length; j++){
            max = Math.max(max, dfs(0, j, Matrix, dp));
        }
        
        return max;
        
    }
    
    int dfs(int i, int j, int[][] mat, int[][] dp){
        
        if(i == mat.length){
            return 0;
        }
        
        if(j < 0 || j >= mat[0].length) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int left = (int) -1e9, up = (int) -1e9, down = (int) -1e9;
        
        if(i + 1 <= mat.length){
            left = dfs(i+ 1, j , mat, dp) + mat[i][j];
        }
        
        if(i + 1 <= mat.length && j > 0){
            up = dfs(i + 1, j -1 , mat, dp) + mat[i][j];
        }
        
        if(i + 1 <= mat.length && j < mat[0].length){
            down = dfs(i + 1, j + 1, mat, dp) + mat[i][j];
        }
        
        return  dp[i][j] = Math.max(left, Math.max(up, down));
        
        
    }
    
}