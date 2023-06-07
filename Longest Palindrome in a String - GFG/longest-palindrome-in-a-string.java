//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public String longestPalin(String S){
        // code here
        
        int n = S.length();
        String ans = S.substring(0, 1);
        int low, high;
        for(int i =0; i<S.length(); i++){
            
            //odd length
            
            low = i -1;
            high = i + 1;
            
            
            while( high<n && S.charAt(high) == S.charAt(i) ) high++;
            
            while(low >= 0 && S.charAt(low) == S.charAt(i)) low--;
             
            
            while( low >= 0 && high <n && S.charAt(low) == S.charAt(high)){
                
                low--;
                high++;
                
                
                
            }
            
                String curr = S.substring(low+1, high );
                if(curr.length()> ans.length()) ans = curr;

            
            
        }
        
        return ans;
        
        
    }
    

    
}