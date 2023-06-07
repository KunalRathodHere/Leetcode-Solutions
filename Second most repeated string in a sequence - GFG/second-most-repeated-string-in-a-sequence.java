//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            for(int i = 0;i<n;i++)
                arr[i] = sc.next();
            
            Solution ob = new Solution();
            
            System.out.println(ob.secFrequent(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    String secFrequent(String arr[], int N)
    {
        // your code here
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<N; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1  );
        }
        
        int max = Integer.MIN_VALUE;
        String mm = "";
        int sec = Integer.MIN_VALUE;
        String ans = "";
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            
            String curr = entry.getKey();
            int val = entry.getValue();
            // System.out.println(curr + "  " + val);
            
            
            if(val > max ){
                sec = max;
                max = val;
                
                ans = mm;
                mm = curr;
            }
            else if(val > sec){
                
                sec = val;
                ans = curr;
            }
        
        }
        return ans;
    }
}