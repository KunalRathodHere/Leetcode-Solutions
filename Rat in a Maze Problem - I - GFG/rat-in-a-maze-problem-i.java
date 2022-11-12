//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    
    static ArrayList<String> list_ans;
    
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        
        list_ans = new ArrayList<String>();
        
        int[][] vis = new int[n][n];
        
        mazing(0, 0, m, vis, n, "");
        
        return list_ans;
        
    }
    
    public static void mazing(int i, int j, int[][] m, int[][] vis ,int n, String ans){
        
        if( i == n -1 && j == n - 1  && m[i][j] ==1)
        {
            
            // System.out.println(ans);
            list_ans.add(ans);
            return;
            
        }
        
        if(m[i][j] == 0)
            return;
        else{
        
        vis[i][j] = 1;
        
        if( i+1 < n && j  < n && i >=0 && j  >= 0 && vis[i+1][j]==0)
                 mazing(i + 1, j, m, vis, n, ans + "D");
            
        if( i  < n && j  < n && i-1 >=0 && j  >= 0 && vis[i-1][j]==0)
                 mazing(i -1, j, m, vis, n, ans + "U");
            
        if( i  < n && j +1 < n && i >=0 && j  >= 0 && vis[i][j+1]==0)
                 mazing(i , j+1, m, vis, n, ans + "R");            
            
        if( i  < n && j  < n && i >=0 && j -1 >= 0 && vis[i][j-1]==0)
                 mazing(i , j-1, m, vis, n, ans + "L");
        
        vis[i][j] = 0;
        return;
        }
        
    }
}