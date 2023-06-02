//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int[] a = new int[2];
            String s[] = br.readLine().trim().split(" ");
            if(s.length == 2){
                a[0] = Integer.parseInt(s[0]);
                a[1] = Integer.parseInt(s[1]);
            } else{
                a[0] = Integer.parseInt(s[0]);
                s = br.readLine().trim().split(" ");
                a[1] = Integer.parseInt(s[0]);
            }
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            
            int src; 
            src = Integer.parseInt(br.readLine());
            
            
            int dst; 
            dst = Integer.parseInt(br.readLine());
            
            Solution obj = new Solution();
            int res = obj.minimumEdgeReversal(edges, a[0], a[1], src, dst);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Pair{
    int node;
    int wt;
    
    Pair(int n, int w){
        node = n;
        wt = w;
    }
}

class Solution {
    public  int minimumEdgeReversal(int[][] edges, int n, int m, int src, int dst) {
        // code here
        
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        
        for(int i=0; i<edges.length; i++){
            int u = edges[i][0] -1;
            int v= edges[i][1] -1;
            
            adj.get(u).add(new Pair(v, 0));
            adj.get(v).add(new Pair(u, 1));
            
        }
        
        
        int[] dis = new int[n+1];
        Arrays.fill(dis, (int) 1e9);
        dis[src-1] =0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src-1, 0));
        
        while(!q.isEmpty()){
            Pair curr = q.remove();
            // System.out.println(curr.node);
            
            for(int i=0; i<adj.get(curr.node).size(); i++){
                
                Pair adj_ele = adj.get(curr.node).get(i);
                
                int adj_node = adj_ele.node;
                int wt = adj_ele.wt;
                
                if(dis[adj_node] > dis[curr.node] + wt){
                    
                    dis[adj_node] = dis[curr.node] + wt;
                    q.add(new Pair(adj_node, wt));                
                }
            }
        }
        
        if(dis[dst-1] == (int) 1e9) return -1;
        
        return dis[dst-1];
        
    }
}
        
