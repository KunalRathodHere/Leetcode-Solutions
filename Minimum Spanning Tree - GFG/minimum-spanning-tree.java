//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;
    int second;
    
    Pair(int f, int s){
        first = f;
        second = s;
    }
}

class Tri{
    int node;
    int parent;
    int wt;
    
    Tri(int n, int p, int w){
        node = n;
        parent = p;
        wt = w;
    }
}

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    
	    for(int i =0; i<V; i++){
	        adj.add(new ArrayList<Pair>());
	    }
	    
	    for(int i=0; i<edges.length; i++){
	        int u = edges[i][0];
	        int v = edges[i][1];
	        int wt = edges[i][2];
	        adj.get(u).add(new Pair(v, wt));
	        adj.get(v).add(new Pair(u, wt));
	        
	    }
	    
	    int[] vis = new int[V];
	    PriorityQueue<Tri> pq = new PriorityQueue<Tri>((x,y) -> x.wt - y.wt);
	    int wt_sum =0;
	    pq.add(new Tri(0, -1, 0));
	    
	    Arrays.fill(vis , 0);
	    vis[0 ] = 0;
	    
	    while(!pq.isEmpty()){
	        
	        Tri curr= pq.remove();
	        int curr_u = curr.node;
	        int curr_p = curr.parent;
	        int curr_wt = curr.wt;
	        
	        if(vis[curr_u] == 1){
	            continue;
	        }
	        
	        vis[curr_u] = 1;
	        wt_sum += curr_wt;
	        
	       // System.out.println("curr_u " + curr_u);
	        for(int i =0; i<adj.get(curr_u).size(); i++){
	            
	            Pair adj_ele = adj.get(curr_u).get(i);
	            
	            int adj_node = adj_ele.first;
	            int weight = adj_ele.second;
	            
	            if(vis[adj_node] != 1){
	                pq.add(new Tri(adj_node, curr_u, weight));
	            }
	            
	        }
	        
	    }
	    
	    return wt_sum;
	    
	}
}