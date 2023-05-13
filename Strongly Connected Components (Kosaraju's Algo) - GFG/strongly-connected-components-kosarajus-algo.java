//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis, Stack<Integer> st){
        
        vis[node] = 1;
        
        for(int adj_node : adj.get(node)){
            if(vis[adj_node] != 1){
                dfs(adj_node, adj, vis, st);
            }
        }
        
        st.push(node);
        
    }
    
    public void dfs2(int node, ArrayList<ArrayList<Integer>> adj, int[] vis){
        vis[node] = 1;
        
        for(int it: adj.get(node)){
            
            if(vis[it] != 1){
                dfs2(it, adj, vis);
            }   
            
        }
        
    }
    
    
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        
        int[] vis = new int[V];
        Stack<Integer> st = new Stack<>();
        
        
        //sort accodring to the finishing time
        for(int i =0; i<adj.size(); i++){
            
            if(vis[i] != 1){
                dfs(i, adj, vis, st);
            }    
            
        }
        
        //reverwse the graph
        
        ArrayList<ArrayList<Integer>> rvr_adj = new ArrayList<>();
        
        for(int i=0; i<V; i++){
            rvr_adj.add(new ArrayList<>());
        }
        
        for(int i =0; i< adj.size(); i++){
            for(int it: adj.get(i)){
                rvr_adj.get(it).add(i);
            }
        }
        
        //run dfs and count how many times it's called
        
        int count = 0;
        
        Arrays.fill(vis, 0);
        while(!st.isEmpty()){
            
            int curr = st.pop();
            
            if(vis[curr] != 1){
                dfs2(curr, rvr_adj, vis);
                count++;
            }
            
        }
        
        
        return count;
        
    }
}
