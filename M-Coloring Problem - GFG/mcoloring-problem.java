//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}

// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        
        int[] color = new int[n];
        Arrays.fill(color, 0);
        
        return function(0, graph, color, n, m);
        
        
    }
    
    public boolean isValid(int idx, int c, int[] color, boolean[][] graph,int n){
        
        for(int i=0; i<n; i++){
            if(graph[idx][i] && (color[i] == c)) return false;
        }
        
        return true;
        
    }
    
    
    public boolean function(int idx, boolean graph[][], int[] color, int n, int m){
        
        if(idx == n){
            return true;
        }
        
        for(int c = 1; c <=m; c++){
            
            if(isValid( idx, c, color, graph, n)){
                
                color[idx] = c;
                boolean temp = function(idx+1, graph, color, n, m);
                if(temp){
                    return true;
                } else{
                    color[idx]=0;
                }
                
            }
            
        }
        
        return false;
        
    }
}