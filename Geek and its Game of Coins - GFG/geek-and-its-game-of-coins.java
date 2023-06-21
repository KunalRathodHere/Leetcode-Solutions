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
            String input[] = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int X = Integer.parseInt(input[1]);
            int Y = Integer.parseInt(input[2]);
            Solution ob = new Solution();
            int ans = ob.findWinner(N,X,Y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public int findWinner(int N,int X,int Y)
    {
        // Code here
        
        boolean[] dp = new boolean[N+1];
        
        dp[0] = false;
        dp[1] = true;
        
        for(int i = 2; i<=N; i++){
            if(dp[i-1] == false) {
                dp[i] = true;
            }
            else if(i >= X && dp[i-X] == false){
                dp[i] = true;
            }
            else if(i>=Y && dp[i-Y] == false){
                dp[i] = true;
            } 
            else{
                dp[i] = false;
            }
        }
        
        return (dp[N])? 1 : 0;
        
    }
    
    public boolean pick(int N, int X, int Y){
        
        if(N == 1) return true;
        else if(N == 0) return false;
        
        
        boolean ans = false;
        
        if(pick(N-1, X, Y) == false) {
            ans = true;
        } 
        
        if(N >= X && pick(N-X, X , Y) == false){
            ans = true;
        }
        
        if(N>= Y && pick(N-Y,X, Y) == false){
            ans = true;
        }
        
        return ans;
        
        
        
    }
        
        
    
    
}