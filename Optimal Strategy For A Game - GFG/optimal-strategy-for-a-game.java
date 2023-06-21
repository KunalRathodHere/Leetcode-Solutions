//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
     long countMaximum(int arr[], int n)
    {
        // Your code here
        long[][] dp = new long[n][n];
        
        for(long[] temp: dp) Arrays.fill(temp, -1);
        
        return game(0, n-1, arr, dp);
        
        
    }
    
    long game(int i, int j, int[] arr, long[][] dp) {
        
        if(i == j){
            return  dp[i][j] = arr[i];
        } 
        if ( (j - i) == 1){
            return dp[i][j] = Math.max(arr[i], arr[j]);
        }
        
        if(dp[i][j] != -1) return dp[i][j];
        
        long top = (long) 1e9;
        long down = (long) 1e9;
        
        //taking the top element
        
        top = arr[i] + Math.min(game(i+1, j-1, arr, dp), game(i+2, j, arr, dp));
        
        down = arr[j] + Math.min(game(i+1, j-1, arr, dp), game(i, j-2, arr, dp));
        
        return  dp[i][j] = Math.max(top, down);
        
        
    }
    
}
