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
        
        int[] vis = new int[V];
        int[] path_vis = new int[V];
        
        Arrays.fill(vis, 0);
        Arrays.fill(path_vis, 0);
        
        for(int i=0; i<V; i++){
            if(vis[i] != 1)
            dfs(adj, vis, path_vis, i);
        }
        
        return isCyclic;
        
    }
    boolean isCyclic = false;
    public void dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path_vis, int node){
        
        vis[node] = 1;
        path_vis[node] = 1;
        
        for(int i=0; i<adj.get(node).size(); i++){
            
            int adj_node = adj.get(node).get(i);
            
            if(path_vis[adj_node] == 1 ) isCyclic = true;
            if(vis[adj_node] == 1) continue;
            
            dfs(adj, vis, path_vis, adj_node);
            
            
        }
        path_vis[node] =  0;
        
    }
    
}