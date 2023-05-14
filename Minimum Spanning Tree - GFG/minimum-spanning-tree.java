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

class DisjointSet{
    
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent =new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    public DisjointSet(int n){
        for(int i =0; i<n; i++){
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }
    
    public int findUPar(int node){
        if (node == parent.get(node)){
            return node;
        }
        
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        
        return parent.get(node);
    }
    
    public void UnionByRank(int u, int v){
        
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        
        if(ulp_u == ulp_v){
            return;
        }
        
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        } else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        } else{
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
        
    }
    
}

class Edge implements Comparable<Edge> {
    int src, dest, weight;
    Edge(int _src, int _dest, int _wt) {
        this.src = _src; this.dest = _dest; this.weight = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};


class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    
	    List<Edge> edgelist = new ArrayList<>();
	    
	    for(int i =0; i<edges.length; i++){
	        edgelist.add(new Edge(edges[i][0], edges[i][1], edges[i][2]));
	    }
	    
	    Collections.sort(edgelist);
	    
	    DisjointSet dsu = new DisjointSet(V);
	    
	    int ans =0;
	    for(int i=0; i<edgelist.size(); i++){
	        
	        int a = dsu.findUPar(edgelist.get(i).src);
	        int b = dsu.findUPar(edgelist.get(i).dest);
	        
	        if(a != b){
	            dsu.UnionByRank(a, b);
	            ans += edgelist.get(i).weight;
	        }
	        
	    }
	    
	    return ans; 
	    
	    
	}
}