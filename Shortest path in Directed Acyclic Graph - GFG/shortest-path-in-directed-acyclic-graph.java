//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Pair{
    
    int node;
    int weight;
    
    Pair(int n, int w){
        node = n;
        weight = w;
    }
    
}

class Solution {


    public void toposort(int node, ArrayList<ArrayList<Pair>> adj, int[] vis, Stack<Integer> st){
        
        vis[node] = 1;
        
        for(int i=0; i<adj.get(node).size(); i++){
            int v = adj.get(node).get(i).node;
            if(vis[v] != 1){
                toposort(v, adj, vis, st);
            }
        }
        
        st.add(node);
        
    }

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		
		
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i=0; i<N; i++){
		    adj.add(new ArrayList<Pair>());
		}
		
		for(int i=0; i<edges.length; i++){
		    
		    adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
		    
		}
		
		int[] vis = new int[N];
		Stack<Integer> s = new Stack<>();

        Arrays.fill(vis, 0);

		for(int i=0; i<adj.size(); i++){
		    if(vis[ i ] != 1){
		        toposort( i, adj, vis, s);
		    }
		}
		
		int[] dist = new int[N];
	
	    for(int i =0; i<N; i++){
	        dist[i] =  (int)1e9;
	    }

        dist[0] = 0;
		
		while(!s.isEmpty()){
		    
            int node = s.pop();
            
            for(int i =0 ;i<adj.get(node).size(); i++){
                
                int v = adj.get(node).get(i).node;
                int w = adj.get(node).get(i).weight;
                
                if(dist[node] + w < dist[v]){
                    dist[v] = w + dist[node];
                }
                
            }

    
		}
		
		for(int i=0; i<N; i++){
		    if(dist[i] ==  1e9) dist[i] = -1;
		}
		
		return dist;
	}
	

	
}