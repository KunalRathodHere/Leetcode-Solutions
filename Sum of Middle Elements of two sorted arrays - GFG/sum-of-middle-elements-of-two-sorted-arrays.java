//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] ar1 = new int[n], ar2 = new int[n];
            String[] inputLine = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                ar1[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                ar2[i] = Integer.parseInt(inputLine[i]);
            }
            System.out.println(new Solution().findMidSum(ar1, ar2, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMidSum(int[] ar1, int[] ar2, int n) {
        // code here
        
        int low = 0;
        int high = n;
        
        int cut1, cut2;
        int l1, l2, r1, r2;
        
        while(low <= high){
            
             cut1 = (low + high) /2;
             cut2 = n - cut1;
            
            l1 = (cut1 == 0) ? Integer.MIN_VALUE : ar1[cut1-1];
            l2 = (cut2 == 0) ? Integer.MIN_VALUE : ar2[cut2 - 1];
            r1 = (cut1 == n) ? Integer.MAX_VALUE : ar1[cut1];
            r2 = (cut2 == n) ? Integer.MAX_VALUE : ar2[cut2];
            
            if(l1 > r2){
                
                high = cut1 -1;
                
                
            } else if(l2 > r1){
                low = cut1 + 1;
            } else{
                
                return (Math.max(l1, l2) + Math.min(r1, r2));
                
            }
            
            
        }
        
        return 0;
    }
}