//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.lps(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int lps(String s) {
        // code here
        
        //usign two pointers
        //for the longest possible prefix suffix the length is n-2;
        
        int n = s.length();
        int suffix = n-1;
        int prefix = n-2;
        int cnt = 0;
        
        
        while(prefix >= -1){
            
            if(prefix == -1 ){
                return cnt;
            }
            
            if(s.charAt(prefix) == s.charAt(suffix)){
                prefix--;
                suffix--;
                cnt++;
            }
            else if(cnt != 0) {
                
                suffix = n-1;
                cnt =0;
            } else{
                prefix--;
            }
            
        }
        
        return cnt;
    }
}