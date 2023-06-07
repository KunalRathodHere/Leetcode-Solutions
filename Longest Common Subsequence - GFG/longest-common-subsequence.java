//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    public int lcs(int x, int y, String s1, String s2)
    {
        
        int[][] dp = new int[x+1][y+1];
        
        for(int[] temp : dp ){
            Arrays.fill(temp, -1);
        }
        
        int ans = fcn(s1.length()-1, s2.length()-1, s1, s2, dp);
        
        return ans;
        
            
    }
    
    public int fcn(int i, int j, String A, String B, int[][] dp) {
        
        if(i < 0 || j < 0) return 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        if(A.charAt(i) == B.charAt(j)) return dp[i][j] = 1 + fcn(i -1, j -1, A, B, dp);
        else return dp[i][j]=  Math.max(fcn(i, j -1, A, B, dp), fcn(i-1, j, A, B, dp) );
        
        
        
    }
    
    
    
}