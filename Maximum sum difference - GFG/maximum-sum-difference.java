//{ Driver Code Starts


// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.maxSum(N));
        }
    }
}
// } Driver Code Ends




// User function Template for Java

class Solution{
    static int maxSum(int N){
        // code here
        
        
        int curr = (N)*(N-1)/2;
        curr += N/2 -1;
        
        return curr;
        
        // N--;
        
        // int curr = N * (N+1)/2;
        
        // if((N+1) %2 != 0) return curr;
        // else{
        //     curr += ((N+1)/2) -1;
        //     return curr;
        // }
        
        // return (N) *(N+1)/2;
        
    }
}