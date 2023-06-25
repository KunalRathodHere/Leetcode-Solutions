//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    
    public static boolean isPossible(int[] stalls, int mid_distance, int k){
        
        int cows = 1;
        int last_cow = stalls[0];
        
        for(int i=1; i<stalls.length; i++){
            
            if(stalls[i] - last_cow >=mid_distance){
                cows++;
                last_cow = stalls[i];
            }
            
        }
        
        return (cows >= k);
        
    }
    
    
    public static int solve(int n, int k, int[] stalls) {
        
        Arrays.sort(stalls);
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<n; i++){
            
            min = (stalls[i] < min) ? stalls[i] : min;
            max = (stalls[i] > max) ? stalls[i] : max;
            
        }
        
        int start = 1;
        int end = max - min;
        int ans = 0;
        while(start <= end){
            
            int mid = start + (end-start)/2;
            
            if(isPossible(stalls, mid, k)){
                ans = mid;
            
                start = mid + 1;
            } else{
                // start = mid + 1;
                end = mid - 1;
            }
            
            
        }
        
        return ans;
        
    }
}