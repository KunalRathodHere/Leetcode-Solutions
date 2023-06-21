//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int k = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().removals(arr, n, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int removals(int[] arr, int n, int k) {
        // code here
        
        Arrays.sort(arr);
        
        int i = 0;
        int j = 0;
        int max = 0;
        
        while(j < n){
            
            if(arr[j] - arr[i] <= k){
                max = Math.max(max, j - i + 1);
                j++;
            } else{
                i++;
            }
            
        }
        return (n - max);
        
        // return slider(0, n-1, k, arr);
    }
    
    // int slider(int i, int j, int k, int[] arr){
        
    //     if(arr[j] - arr[i] <= k) return 0;
        
    //     int move_left;
    //     int move_right;
        
    //     move_left = slider(i + 1, j, k, arr) + 1;
    //     move_right = slider(i, j - 1, k , arr) + 1; 
    //     return Math.min(move_left, move_right);
        
    // }
    
}