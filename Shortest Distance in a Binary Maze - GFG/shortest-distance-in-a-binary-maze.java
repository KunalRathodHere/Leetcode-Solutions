//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int x;
    int y;
    int dist;
    
    Pair(int xx, int yy, int d){
        x = xx;
        y = yy;
        dist = d;
    }
}

class Solution {

    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist = new int[n][m];
        
        
        
        for(int i=0; i<n; i++){
            for(int j =0; j<m; j++){
                
                if(grid[i][j] == 1  ) dist[i][j] = (int)1e9;
                else dist[i][j] = -1;
                
            }
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.dist - y.dist);
        
        dist[source[0]][source[1]] = 0;
        pq.add(new Pair(source[0], source[1], 0));
        
        while(!pq.isEmpty()){
            
            int[] xdir = {0, 0, 1, -1};
            int[] ydir = {1, -1, 0, 0};
            
            Pair curr = pq.remove();
            
            for(int i =0; i<4; i++){
                int new_x = curr.x + xdir[i];
                int new_y = curr.y + ydir[i];
                
                if(new_x >= 0 && new_y >= 0 && new_x <n && new_y < m){
                
                if(grid[new_x][new_y] == 1){
                    if(dist[curr.x][curr.y] + 1 < dist[new_x][new_y]){
                        dist[new_x][new_y] = dist[curr.x][curr.y] + 1;
                        pq.add(new Pair(new_x, new_y, dist[curr.x][curr.y] + 1 ));
                    }
                }
                }
            }
            
        }
        
        if(dist[destination[0]][destination[1]] == (int) 1e9){
            return -1;
        } else{
            return dist[destination[0]][destination[1]];
        }
        
    }
}
