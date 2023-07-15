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
            String s1[] = read.readLine().split(" ");
            x = Integer.parseInt(s1[0]);
            y = Integer.parseInt(s1[1]);
            Solution ob = new Solution();
            System.out.println(ob.shortestDistance(N, M, a, x, y));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int shortestDistance(int N, int M, int A[][], int X, int Y) {
        // code here
        int m = A.length;
        int n = A[0].length;
        
        boolean[][] vis = new boolean[m][n];
        
        for(boolean[] temp: vis) Arrays.fill(temp, false);
        
        vis[0][0] = true;
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0} );
        
        int[][] dir = {{0,1}, {0,-1}, {-1,0}, {1,0}};
        
        int res =0;
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-->0){
                
                int[] curr= q.remove();
                
                if(curr[0] == X && curr[1]== Y) return res;
                
                for(int i =0; i< 4; i++){
                    
                    int newi = curr[0] + dir[i][0];
                    int newj = curr[1] + dir[i][1];
                    
                    if(newi >= 0 && newj >=0 && newi < m && newj < n){
                        
                        if(vis[newi][newj] == false && A[newi][newj] == 1){
                            
                            vis[newi][newj] = true;
                            q.add(new int[]{newi, newj});
                            
                        }
                        
                    }
                    
                }
                
            }
            res++;
            
        }
        return -1;
        
    }
};