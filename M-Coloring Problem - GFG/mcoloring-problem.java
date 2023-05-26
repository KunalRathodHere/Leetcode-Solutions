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
    
    int V;
    
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        V = n;
        int[] color = new int[V];
        
        Arrays.fill(color, 0);
        
        return function(graph, color, m, 0);
        
    }
    
    public boolean isValid(int idx, int c, int[] color, boolean[][] graph){
        
        for(int i=0; i<V; i++){
            
            if(graph[idx][i] && c == color[i]){
                return false;
            }
            
        }
        return true;
    }
    
    public boolean function(boolean graph[][], int[] color, int m, int idx){
        
        if(idx == V){
            return true;
        }
        
        for(int c = 1; c<=m; c++){
            
            if(isValid(idx, c, color, graph)){
                color[idx] = c;
                
                if(function(graph, color, m, idx+1)){
                    return true;
                }
                color[idx] = 0;
                
            }
            
        }
        
        return false;
    }
    
    
    
}