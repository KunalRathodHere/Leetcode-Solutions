//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Driver
{
    public static void main(String args[])throws IOException
    {
        //reading input using BufferedReader class
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
        //reading total testcases
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            //reading length of line segment
            int n = Integer.parseInt(read.readLine().trim());
            
            
            //reading 3 segment lengths
            String str[] = read.readLine().trim().split(" ");
            
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            int z = Integer.parseInt(str[2]);
            
            
            //calling method maximizeCuts() of class Solution()
            //and printinting the result
            System.out.println(new Solution().maximizeCuts(n, x, y, z));
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
       //Your code here
       
       int[] segments =new int[n+1];
       Arrays.fill(segments, -1);
       int ans = cutter(n, x, y, z, segments);
       
       if(ans < 0) return 0;
       
       return ans;
       
    }
    
    public int cutter(int n, int x, int y, int z, int[] seg){
        
        if(n == 0) return 0;
        if(n < x && n < y && n < z){
            return (int) -1e9;
        }
        
        
        
        int x_cut = (int) -1e9, y_cut = (int) -1e9, z_cut = (int) -1e9;
        
        if(seg[n] != -1) return seg[n];
        
        if(n >= x){
             
             x_cut = 1 +cutter(n - x, x, y, z, seg);
        }
        if(n >= y){
             y_cut = 1 +cutter(n - y, x, y, z, seg);
        }
        if(n >= z){
             z_cut = 1 +cutter(n - z, x, y, z, seg);
        }
        
        return seg[n] = Math.max(x_cut, Math.max(y_cut, z_cut));
        
    }
}
