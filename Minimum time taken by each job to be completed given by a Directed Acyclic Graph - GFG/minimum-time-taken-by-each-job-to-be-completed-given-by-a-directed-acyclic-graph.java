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
            
            int[] a = IntArray.input(br, 2);
            
            
            int[][] edges = IntMatrix.input(br, a[1], 2);
            
            Solution obj = new Solution();
            int [] res = obj.minimumTime(a[0],a[1], edges);
            for(int x: res)
                System.out.print(x+" ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int [] minimumTime(int n,int m, int[][] edges) {
        // code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[n];
        
        for(int i=0; i<edges.length; i++){
            
            int u = edges[i][0] - 1;
            int v= edges[i][1] - 1;
            indeg[v]++;    
            adj.get(u).add(v);
        }
        
        int[] ans = new int[n];
        Queue<Integer> q= new LinkedList<>();
        
        
        for(int i=0; i<n; i++){
            if(indeg[i] == 0) {
                ans[i] =  1;
                q.add(i);
            }
        }
        
        
        int time_done = 1;
        while(!q.isEmpty())
        {
            
            int size = q.size();
            while(size-- > 0){
                int curr = q.remove();
                ans[curr] = time_done;
                
                for(int i=0; i<adj.get(curr).size();i++){
                    int next = adj.get(curr).get(i);
                    indeg[next]--;
                    
                    if(indeg[next] == 0) q.add(next);
                }
            }

            time_done++;
        }
        
        return ans;
        
    }
}
        
