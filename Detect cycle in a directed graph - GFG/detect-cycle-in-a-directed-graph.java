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
        
        int[] indegree = new int[V];
        
        for(int i =0; i<V; i++){
            ArrayList<Integer> arr = adj.get(i);
            for(int j: arr){
                indegree[j]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<Integer>();

        
        for(int i=0 ;i<V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        
        // int[] ans = new int[V];
        int k = 0;
        
        // int[] vis = new int[V];
        // Arrays.fill(vis, 0);
        
        while(!q.isEmpty()){
            int a = q.remove();
            // ans[k ] = a;
            k++;
            
            ArrayList<Integer> adj_arr = adj.get(a);
            
            for(int i : adj_arr){
                indegree[i]--;
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            
            // bfs(a, adj, q, indegree, vis);
        }
        
        if(k == V){
            return false;
        } else{
            return true;
        }
        
    }
    
    public boolean dfs(int V, ArrayList<ArrayList<Integer>> adj, int[] vis, int[] path_vis){
        
        ArrayList<Integer> adj_arr = adj.get(V);
        vis[V] = 1;
        path_vis[V] = 1;
        
        for(int i =0; i<adj_arr.size(); i++){
            
            if(vis[adj_arr.get(i)] == -1){
                if(dfs(adj_arr.get(i), adj, vis, path_vis) == true){
                    return true;
                }
            }
            else if(path_vis[adj_arr.get(i)] == 1){
                // System.out.println("vis " + V + " adj " + adj_arr.get(i));
                return true;
            }
            
        }
        
        path_vis[V] = -1;
        return false;
        
    }
}