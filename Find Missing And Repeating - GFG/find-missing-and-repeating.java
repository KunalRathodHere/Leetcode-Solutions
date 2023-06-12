//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
        // code here
        
        int[] map = new int[n+1];
        Arrays.fill(map, 1);
        
        int repeated = 0;
        
        for(int i=0; i<n; i++){
            
            int curr = arr[i];
            
            if(map[curr] > 0){
                map[curr] =  map[curr] * -1;
            }
            else if(map[curr] < 0){
                // System.out.println(curr);
                repeated = curr;
            }
            
        }
        
        // for(int i=0; i<n+1; i++){
        //     System.out.println("i = " + i + " " + map[i]);
        // }
        
        int missing = 0;
        for(int i = 1; i<n+1; i++){
            if(map[i] > 0){
                missing = i;
                break;
            }
        }
        
        
        int[] ans = new int[2];
        ans[0] = repeated;
        ans[1] = missing;
        
        return ans;
    }
}