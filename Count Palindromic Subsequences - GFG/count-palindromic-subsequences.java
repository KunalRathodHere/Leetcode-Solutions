//{ Driver Code Starts
import java.util.*;
class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			//System.out.println(str.length());
			Solution ob  = new Solution();
			System.out.println(ob.countPS(str));
		t--;
		}
	}
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution
{
    
    final long mod = 1000000007;
    long add(long x, long y) {
        return ((x % mod) + (y % mod)) % mod;
    }
    long sub(long x, long y) {
        return ((x % mod) - (y % mod) + mod) % mod;
    }
    
    long countPS(String str)
    {
        // Your code here
        int N = str.length();
 
        // create a 2D array to store the count
        // of palindromic subsequence
        long[][] cps = new long[N][N];
 
        // palindromic subsequence of length 1
        for (int i = 0; i < N; i++)
            cps[i][i] = 1;
 
        // check subsequence of length L is
        // palindrome or not
        for (int L = 2; L <= N; L++) {
            for (int i = 0; i <= N-L; i++) {
                int k = L + i - 1;
              if (str.charAt(i) == str.charAt(k)) {
                cps[i][k] = (add(cps[i][k - 1]
                                    , cps[i + 1][k]) + 1) %  mod ;
              }else{
                cps[i][k] = sub(add(cps[i][k - 1]
                                    , cps[i + 1][k])
                                    , cps[i + 1][k - 1]) % mod ;
              }
            }
        }
 
        // return total palindromic subsequence
        return cps[0][N - 1] % mod;
        
        // for(long[] temp: dp) Arrays.fill(temp, -1);
        
        // return solve(str, 0, str.length()-1, dp);
        
    }    
    // long solve(String str, int i, int j, long[][] dp)
    // {
    //     if (i == j) //  base case when index is same
    //         return 1;
 
    //     if (i > j)
    //         return 0;
 
    //     if(dp[i][j] != -1) return dp[i][j];
 
    //     if (str.charAt(i) == str.charAt(j)) {
 
    //         return 1 + solve(str, i + 1, j, dp)
    //             + solve(str, i, j - 1, dp);
    //     }
 
    //     else
    //         return solve(str, i + 1, j, dp)
    //             + solve(str, i, j - 1, dp)
    //             - solve(str, i + 1, j - 1, dp);
    // }

}