//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int K = Integer.parseInt(in.readLine());
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int A[] = new int[N];
            for (int i = 0; i < N; i++) A[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            System.out.println(ob.maxProfit(K, N, A));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
     int maxProfit(int K, int N, int prices[]) {
        // code here
        int n = prices.length;
        int[][][] dp = new int[n][2][K+1];

        for(int[][] temp: dp){
            for(int[] temp2: temp){
                Arrays.fill(temp2, -1);
            }
        }

        return stock(0, -1, 0, K, prices, dp);

        
        
    }
    
    public int stock(int curr_day, int prev_day, int have_stock, int transactions, int[] prices, int[][][] dp){

        if(curr_day == prices.length) {
            return 0;
        }

        if(transactions == 0) return  0;

        if(dp[curr_day][have_stock][transactions] != -1) return dp[curr_day][have_stock][transactions];

        if(have_stock == 1){
            //if you have stock you can either sell it or don't sell it

            //first condition if you sell it
            int sell = stock(curr_day+1, -1, 0, transactions-1, prices, dp) + prices[curr_day];
            
            int dontsell = stock(curr_day+1, prev_day, have_stock, transactions, prices, dp);

            return dp[curr_day][have_stock][transactions] = Math.max(sell, dontsell);

        } else{
            // dont have stock so you can buy it or skip it

            int buy = stock(curr_day+1, curr_day, 1, transactions, prices, dp) - prices[curr_day];

            int dontbuy = stock(curr_day+1, prev_day, have_stock,
            transactions, prices, dp);

            return dp[curr_day][have_stock][transactions] = Math.max(buy, dontbuy);



        }

    }
    
}