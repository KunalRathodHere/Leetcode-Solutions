//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            for (int i = 0; i < n; i++)
                list.add(i, new ArrayList<Integer>());

            ArrayList<ArrayList<Integer>> prerequisites = new ArrayList<>();
            for (int i = 1; i <= m; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(v).add(u);
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(u);
                pair.add(v);
                prerequisites.add(pair);
            }

            int[] res = new Solution().findOrder(n, m, prerequisites);
            
            if(res.length==0)
                System.out.println("No Ordering Possible");
            else
            {
                if (check(list, n, res) == true)
                    System.out.println("1");
                else
                    System.out.println("0");
            }
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> pre) 
    {
        // add your code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++ ) adj.add(new ArrayList<>());
        
        
        int[] in_degree = new int[n];
        Arrays.fill(in_degree, 0);
        
        for(int i=0; i<pre.size(); i++){
            int u = pre.get(i).get(0);
            int v=  pre.get(i).get(1);
            
            adj.get(v).add(u);
            in_degree[u]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i =0; i<n; i++){
            if(in_degree[i] == 0){
                q.add(i);
            }
        }
        
        if(q.size() == 0){
            int[] ans = new int[0];
            return ans;
        }
        
        int[] ans = new int[n];
        int idx =0;
        
        while(!q.isEmpty()){
            
            int curr = q.peek();
            ans[idx]  = q.remove();
            idx++;
            // System.out.println("here = " + idx);
            for(int i =0; i<adj.get(curr).size(); i++  ){
                int adjcent = adj.get(curr).get(i);
                in_degree[adjcent]--;
                
                if(in_degree[adjcent] == 0){
                    q.add(adjcent);
                }
            }
            
        }
        
        if(idx != n){
            int[] temp = new int[0];
            return temp;
        }
        
        return ans;
        
    }
}