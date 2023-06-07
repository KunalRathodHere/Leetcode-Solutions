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


class StringMatrix
{
    public static String[][] input(BufferedReader br, int n, int m) throws IOException
    {
        String[][] mat = new String[n][];
        for(int i = 0; i < n; i++)
            mat[i] = br.readLine().trim().split(" ");
        return mat;
    }
    
    public static void print(String[][] m)
    {
        for(var a : m)
        {
            for(String e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<String>> m)
    {
        for(var a : m)
        {
            for(String e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[] a = IntArray.input(br, 2);
        
        
        String[][] list = StringMatrix.input(br, a[0], a[1]);
        
        Solution obj = new Solution();
        ArrayList<ArrayList<String>> res = obj.sentences(list);
        
        StringMatrix.print(res);
        
    }
}

// } Driver Code Ends


class Solution {
    ArrayList<ArrayList<String>> ans = new ArrayList<>();
    public  ArrayList<ArrayList<String>> sentences(String[][] list) {
        // code here
        
        for(int j=0; j<list[0].length; j++){
            fcn(0, j, new ArrayList<>(), list);
        }
        
        
        return ans;
        
    }
    
    public void fcn(int i, int j, ArrayList<String> curr, String[][] list ){
        
        if(i == list.length -1  ){
            curr.add(list[i][j]);
            ans.add(new ArrayList<>(curr));
            return;
            
        }
        
        curr.add(list[i][j]);
        
        for(int jj =0; jj<list[0].length; jj++){
            fcn(i +1, jj, new ArrayList<>(curr), list);
        }
        return;
    }
}
        
