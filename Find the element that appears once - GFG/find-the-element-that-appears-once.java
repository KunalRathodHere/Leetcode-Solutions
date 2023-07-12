//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for (int i = 0; i < n; ++i)
                arr[i] = sc.nextInt ();

    		System.out.println (new Sol().search (arr, n));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int search(int A[], int N)
    {
        // your code here
        
        int idx = find(A, 0, N-1);
        return A[idx];
        
    }
    
    public static int find(int[] A, int left, int right){
        
        int mid = left + (right - left)/2;
        
        if(left > right) return -1;
        if(left == right){
            if((left - 1 >= 0 && A[left] == A[left -1]) ||
             (left + 1 < A.length) && A[left + 1] == A[left] ){
                 
                 return -1;
                 
             }
             else{
                 return left;
             }
        }
        
        if((mid - 1 >= 0 && A[mid-1] == A[mid]) || (mid + 1 < A.length && A[mid + 1] == A[mid])  )
        {
            int l= find(A ,left, mid - 1);
            int r = find(A, mid + 1, right);
            
            if(l != -1 || r != -1){
            
                return Math.max(l, r);
            } else{
                return -1;
            }
        } 
        else{
            return mid;
        }
        
    }
}