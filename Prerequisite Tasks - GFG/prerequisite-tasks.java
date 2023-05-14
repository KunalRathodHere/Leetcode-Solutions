//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int N, int[][] prereq)
    {
        // Your Code goes here
        int[] indegree = new int[N];
        
        for(int i =0; i<prereq.length; i++){
            indegree[prereq[i][0]]++;
        }
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<N; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i =0; i<prereq.length; i++){
            adj.get(prereq[i][1]).add(prereq[i][0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<N; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        List<Integer> list =new ArrayList<>();
        
        while(!q.isEmpty()){
            
            int curr = q.remove();
            list.add(curr);
            
            // System.out.println(curr);
            
            for(int i : adj.get(curr)){
                indegree[i]--;
                
                if(indegree[i] == 0){
                    q.add(i);
                }
            }
            
        }
        
        // System.out.println(list.size());
        
        if(list.size() == (N)){
            return true;
        } else
        return false;
    }
    
}