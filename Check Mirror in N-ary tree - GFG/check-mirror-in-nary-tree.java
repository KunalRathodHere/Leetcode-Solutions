//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            
            int n = Integer.parseInt(S[0]);
            int e = Integer.parseInt(S[1]);
            
            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            
            int[] A = new int[2*e];
            int[] B = new int[2*e];
            
            for(int i=0; i<2*e; i++)
            {
                A[i] = Integer.parseInt(S1[i]);
                B[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.checkMirrorTree(n,e,A,B));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        // code here
        
        Map<Integer, Stack<Integer>> Amap = new HashMap<>();
        
        for(int i =0; i<A.length; i+=2){
            
            int u = A[i];
            int v = A[i+1];
            
            if(!Amap.containsKey(u)){
                Amap.put(u, new Stack<>());
                Amap.get(u).add(v);
            } else{
                Amap.get(u).add(v);
            }
        }
        
        for(int i=0;i<B.length; i+=2){
            
            int u = B[i];
            int v = B[i+1];
            
            if(Amap.get(u).peek() == v){
                Amap.get(u).pop();
            }
            else{
                return 0;
            }
        }
        return 1;
    }
};