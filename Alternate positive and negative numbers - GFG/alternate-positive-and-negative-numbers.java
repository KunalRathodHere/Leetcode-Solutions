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
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        // code here
        
        boolean all_good = false;
        
        
            for(int i=0; i<n; i++){
            while(i < n){
                
                if(i%2  == 0 && arr[i] >= 0 && i < n) {
                    // System.out.println(i + " here");
                    i++;
                    continue;
                }
                if(i%2 != 0 && arr[i] <  0  && i < n) {
                    i++;
                    // System.out.println(i + " here2");
                    continue;
                }
                
                if(i == n) return;
                
                int out_of_place = i;
                // System.out.println(out_of_place)
                
                int next_opposite = out_of_place;
                
                while(next_opposite < n){
                    if(arr[out_of_place] >=0 && arr[next_opposite] < 0) break;
                    if(arr[out_of_place] <0 && arr[next_opposite] >= 0) break;
                    next_opposite++;
                }
                
                if(next_opposite == n) return;
                
                int opposite_val = arr[next_opposite];
                
                for(int ii = next_opposite; ii> out_of_place; ii--){
                    arr[ii] = arr[ii-1];
                }
                arr[out_of_place] = opposite_val;
                
                break;
                
                
            }
        }
            
            
        
        
    }
}