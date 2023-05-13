//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] S = read.readLine().split(" ");
            int N = Integer.parseInt(S[0]);
            int M = Integer.parseInt(S[1]);
            int Grid[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                String[] s = read.readLine().split(" ");
                for (int j = 0; j < M; j++) Grid[i][j] = Integer.parseInt(s[j]);
            }
            Solution ob = new Solution();
            System.out.println(ob.MinimumEffort(Grid));
        }
    }
}
// } Driver Code Ends


class Tri{
    int x;
    int y;
    int d;
    
    Tri(int xx, int yy, int dd){
        x = xx;
        y = yy;
        d = dd;
    }
}

class Solution {
    
    int MinimumEffort(int heights[][]) {
        
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        
        for(int[] temp: dist){
            Arrays.fill(temp, (int)1e9);
        }
        
        dist[0][0] = 0;
        
        PriorityQueue<Tri> pq = new PriorityQueue<Tri>((x,y) -> x.d - y.d);
        
        pq.add(new Tri(0, 0, 0));
        // int ans = Integer.MIN_VALUE;
        while(!pq.isEmpty()){
            
            int[] xdir = {0,0,1,-1};
            int[] ydir = {1,-1,0,0};
            
            Tri curr =pq.remove();
            
            for(int i = 0; i<4; i++){
                int new_x = curr.x + xdir[i];
                int new_y = curr.y + ydir[i];
                
                if(new_x >=0 && new_y >=0 && new_x <n && new_y < m){
                    
                    
                        // dist[new_x][new_y] = dist[curr.x][curr.y] + heights[curr.x][curr.y];
                        // pq.add(new Tri(new_x, new_y, dist[curr.x][curr.y] + heights[curr.x][curr.y]));
                        
                        int new_effort = Math.max( Math.abs(heights[new_x][new_y] - heights[curr.x][curr.y]), curr.d);
                        
                        if(new_effort < dist[new_x][new_y]){
                            dist[new_x][new_y] = new_effort;
                            pq.add(new Tri(new_x, new_y, new_effort));
                        }
                        
                        // ans= Math.max(ans, Math.abs(heights[new_x][new_y] - heights[curr.x][curr.y]));
                    
                }
            }
        }
        
        return dist[n-1][m-1]; 
        
    }
}