//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        // code here
        
        long ans = Long.MIN_VALUE;
        long curr = arr[0];
        ans = Math.max(curr, ans);
        
        for(int i=1; i<n; i++){
            if(curr == 0) curr = 1;
            curr *= arr[i];
            ans = Math.max(ans, curr);
        }
        
        long temp = 1;
        
        for(int i= n-1; i>=0; i--){
            if(temp == 0) temp =1;
            temp *= arr[i];
            ans = Math.max(ans, temp);
        }
        
        return ans;
        
    }
}