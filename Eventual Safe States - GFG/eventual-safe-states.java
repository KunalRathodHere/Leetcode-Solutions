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
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        int[] visited = new int[V];
        int[] path_visited = new int[V];
        Arrays.fill(visited, 0);
        Arrays.fill(path_visited, 0);
        int[] safe_nodes =  new int[V];    
        Arrays.fill(safe_nodes, 0);
        
        
        for(int i=0; i<V; i++){
            
            if(visited[i] != 1){
                dfs(i, adj, visited, path_visited, safe_nodes);
            }
            
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<V; i++){
            
            if(safe_nodes[i] == 1){
                ans.add(i);
            }
            
        }
        
        return ans;
    }
    
    boolean dfs(int node, List<List<Integer>> adj, int[] visited, int[] path_visited,
    int[] safe_nodes){
        
        visited[node] = 1;
        path_visited[node] = 1;
        safe_nodes[node] = 0;
        
        List<Integer> adjcent = adj.get(node);
        
        for(int i=0; i<adjcent.size(); i++){
            
            int adj_node = adjcent.get(i);
            
            if(path_visited[adj_node] == 1) {
                safe_nodes[adj_node] = 0;
                return true;
            }
            
            
            else if(visited[adj_node] != 1){
                
                boolean temp =dfs(adj_node, adj, visited, path_visited, safe_nodes);
                if(temp){
                    safe_nodes[adj_node] = 0;
                    return true;
                }
                
            }
            
        }
        
        safe_nodes[node] = 1;
        path_visited[node] = 0;
        
        return false;
    }
    
}
