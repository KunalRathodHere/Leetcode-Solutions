//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N, M, x, y;
            String S[] = read.readLine().split(" ");
            N = Integer.parseInt(S[0]);
            M = Integer.parseInt(S[1]);
            int a[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String s[] = read.readLine().split(" ");
                for (int j = 0; j < M; j++) a[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maximumSumRectangle(N, M, a));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int maximumSumRectangle(int R, int C, int M[][]) {
        // code here
        
        int[] column_sum = new int[R];
        
        int max_sum = (int) -1e9;
        int max_left = 0;
        int max_right = 0;
        int max_up = 0;
        int max_down =0;
        
        for(int L = 0; L< C; L++){
            
            Arrays.fill(column_sum, 0);
            int curr_sum =0;
            
            for(int right = L; right<C; right++){
                
                for(int row =0; row<R; row++){
                    column_sum[row] += M[row][right];
                    // curr_sum += column_sum[row];
                }
                
                //running kadane in column_sum
                
                int max_sum_here = 0;
                int max_sum_till = (int) -1e9;
                
                for(int i=0; i<R; i++){
                    
                    max_sum_here = max_sum_here + column_sum[i];
                    if(max_sum_here > max_sum_till){
                        max_sum_till = max_sum_here;
                    }
                    
                    if(max_sum_here < 0){
                        max_sum_here = 0;
                    }
                    
                }
                
                if(max_sum_till > max_sum){
                    max_sum = max_sum_till;
                }
                
            }
            
        }
        
        
        return max_sum;
        
    }
    
    
    
};