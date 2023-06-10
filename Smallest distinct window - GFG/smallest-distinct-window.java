//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String str = br.readLine();
            
            Solution obj = new Solution();
            System.out.println(obj.findSubString(str));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    public int findSubString( String str) {
        // Your code goes here
        
        int[] arr = new int[256];
        
        int distinct = 0;
        
        for(int i=0; i<str.length(); i++){
            if(arr[str.charAt(i)] ==0){
                arr[str.charAt(i)] = 1;
                distinct++;
            }
        }
        
        int[] window = new int[256];
        int start = 0, start_index = -1;
        int small = str.length();
        int curr_distinct = 0;
        for(int j= 0; j< str.length(); j++){
            
            window[str.charAt(j)]++;
            
            if(window[str.charAt(j)] == 1){
                curr_distinct++;
            }
            
            if(curr_distinct == distinct){
                
                while(window[str.charAt(start)] > 1 ){
                    
                    if(window[str.charAt(start)] > 1){
                        window[str.charAt(start)]--;
                        
                    }
                    start++;
                }
                
                small = Math.min(small, j - start + 1);
                start_index = start;
                
            }
            
        }
        
        return small;
    }
}