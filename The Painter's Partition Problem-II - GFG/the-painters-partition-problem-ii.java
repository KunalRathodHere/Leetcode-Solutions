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
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
     
    static boolean isPossible(int[] arr, int n, int k,  long max_time){
        
        int painters_needed = 1;
        long curr_sec = 0;
        
        for(int i =0; i<n; i++){
            
            curr_sec += (long) arr[i];
            if(curr_sec > max_time){
                curr_sec = arr[i];
                painters_needed++;
            }
            
        }
        
        return (painters_needed <= k);
    }
     
    static long minTime(int[] arr,int n,int k){
        //code here
        
        long total = 0;
        int mx =0;
        for(int i =0; i<n; i++){
            total += (long) arr[i];
            mx = (arr[i] > mx) ? arr[i] : mx; 
        }
        
        long start = mx;
        long end = total;
        
        long res =end;
        
        while(start <= end){
            
            long mid = start + (end - start)/2;
            
            if(isPossible(arr, n, k, mid)){
                res = mid;
                
                end = mid -1;
            } else{
                start = mid + 1;
            }
    
        }
        
        return res;
        
    }
}


