//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int X = Integer.parseInt(inputLine[1]);
		    int A[] = new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        A[i] = Integer.parseInt(inputLine[i]);
		    }
		    Solution ob=new Solution();
		    boolean ans = ob.find3Numbers(A, n, X);
		    System.out.println(ans?1:0);
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public  boolean find3Numbers(int A[], int n, int X) { 
    
       // Your code Here
        
        Arrays.sort(A);
        boolean ans = false;
        for(int i=0; i<n; i++){
            ans = ans || check(A, X - A[i], i); 
            if(ans) return true;
            
        }
        return ans;
    }
    
    public boolean check(int A[], int target, int start){
        
        int i = start + 1;
        int j = A.length -1;
        
        while(i < j){
            if(A[i] + A[j] == target) return true;
            
            else if(A[i] + A[j] < target) i++;
            else if(A[i] + A[j] > target) j--;
            
            
        }
    
        return false;
    }
    
    
}
