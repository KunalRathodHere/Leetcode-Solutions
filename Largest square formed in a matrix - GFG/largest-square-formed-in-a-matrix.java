//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            String a1[] = in.readLine().trim().split("\\s+");
            int mat[][] = new int[n][m];
            for(int i = 0;i < n*m;i++)
                mat[i/m][i%m] = Integer.parseInt(a1[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxSquare(int n, int m, int mat[][]){
        // code here
        
        int[][] square = new int[n][m];
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                
                if(mat[i][j] == 0){
                    square[i][j] = 0;
                } else{
                    
                    if(i == 0 || j == 0){
                        square[i][j] = 1;
                        max = Math.max(max, square[i][j]);
                        continue;
                    }    
                    
                    square[i][j] =1 + Math.min(square[i-1][j-1], Math.min(square[i-1][j], square[i][j-1]));
                    
                    max = Math.max(max, square[i][j]);
                    
                }
                
            }
        }
        
        return max;
        
    }
}