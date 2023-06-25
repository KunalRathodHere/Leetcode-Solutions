//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    
    public  boolean maximum_page_to_one(int[] A, int n, int m, int max_page_allowed){
        
        int students = 1;
        int curr_page = 0;
        
        for(int i=0; i<A.length; i++){
            
            curr_page += A[i];
            if(curr_page > max_page_allowed){
                students++;
                curr_page = A[i];
            }
            
        }
        
        return (students <= m);
        
    }
    
    //Function to find minimum number of pages.
    public  int findPages(int[]A,int N,int M)
    {
        //Your code here
        
        if(M > N) return -1;
        
        int total = 0;
        int mx = Integer.MIN_VALUE;
        for(int i=0; i<N;i++){
            total+= A[i];
            mx = (A[i] > mx) ? A[i] : mx;
        }
        
        int start = mx;
        int end = total;
        int res = -1;
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(maximum_page_to_one(A, N, M, mid)){
                res = mid;
                
                end = mid-1;
                
            }
            else{
                start = mid+1;
            }
            
        }
        
        return res;
        
    }
};