//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Node{
    int curr;
    int parent;
    
    Node(int c, int p){
        curr = c;
        parent = p;
    }
}

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        
        Queue<Node> queue = new LinkedList<>();
        
        Arrays.fill(visited, false);
        
        
        for(int i =0; i<adj.size(); i++){
            
            if(visited[i] == false){
                queue.add(new Node(i, -1));
                visited[i] = true;
                boolean ans = detect(V, adj, visited, queue);
                if(ans) return true;
            }
            
        }
        return false;
    }
    
    public boolean detect(int V, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Queue<Node> queue){
        
        while(!queue.isEmpty()){
            
            Node curr_node = queue.remove();
            int curr = curr_node.curr;
            
            for(int i =0; i<adj.get(curr).size(); i++){
                
                int next = adj.get(curr).get(i);
                
                if(visited[next] == true && next != curr_node.parent){
                    return true;
                } else if(!visited[next] ){
                    visited[next] = true;
                    queue.add(new Node(next, curr));
                    
                }
                
            }
            
        }
         
        return false;

    }
    
}