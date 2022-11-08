//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        boolean visited[] = new boolean[V+1];
        boolean path_visited[] = new boolean[V+1];
        
        for(int i =0; i<V;i++){
            if( dfs(i, adj, visited, path_visited) )
                return true;
                
        }
        
        return false;
        
    }
    
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] path_visited ){
        
            if(path_visited[V] == true)
            return true;
            
            if(visited[V] == true)
            return false;
            
            visited[V]  = true;
            path_visited[V] = true;
            
            ArrayList<Integer> arr = adj.get(V);
            
            for(int i : arr){
                
                if(dfs(i, adj, visited, path_visited))
                    return true;
                
            }
            
            path_visited[V] = false;
            
            return false;
    }
}