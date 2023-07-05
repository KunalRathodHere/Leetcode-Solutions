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
            
            
            int[] b = IntArray.input(br, 4);
            
            
            int[][] mat = IntMatrix.input(br, a[0], a[1]);
            
            Solution obj = new Solution();
            int res = obj.longestPath(mat,a[0],a[1],b[0],b[1],b[2],b[3]);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public  int longestPath(int[][] mat,int n,int m,int xs,int ys,int xd,int yd) {
        // code here
        
        if(mat[xs][ys] == 0 || mat[xd][yd] == 0) return -1;
        
        int[]src  = {xs, ys};
        int[] dst = {xd, yd};
        
        bt(xs, ys, mat, src, dst, 0);
        
        return ans;
    }
    
    int ans = -1;
    
    public  void bt(int x, int y, int[][] mat, int[] src, int[] dst, int dist){
        
        if(x == dst[0] && y == dst[1]){
            ans = Math.max(dist, ans);
            return;
        }
        
        if(mat[x][y] == 0) return;
        
        mat[x][y] = 0;
        
        int[] xdir = {0,0,1,-1};
        int[] ydir = {1,-1,0,0};
        
        for(int i =0; i<4; i++){
            int newx = x + xdir[i];
            int newy = y + ydir[i];
        
            if(newx <0 || newy < 0 || newx >= mat.length || 
            newy >= mat[0].length){
                continue;
            } else{
                bt(newx, newy, mat, src, dst, dist + 1);
            }
        }
        
        mat[x][y] = 1;
        
        return;
        
        
        
    }
    
}
        
