//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Sorting
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Solution().inversionCount(arr, n));
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    long inversions = 0;
    // arr[]: Input Array
    // N : Size of the Array arr[]
    //Function to count inversions in the array.
     long inversionCount(long arr[], long N)
    {
        // Your Code Here
        
        mergeSort(arr, 0, N-1);
        return inversions;
        
    }
    
        void merge(long arr[], long l, long m, long r)
    {
         // Your code here
        
        long i = l;
        long j  = m + 1;
        
        int n1 = (int) ( m - l + 1);
        int n2 =    (int) (r - m);
        
        long[] L = new long[n1];
        long[] R = new long[n2];
        
        int tmp2 = (int) l;
        for(int tmp = 0; tmp < n1; tmp++){
            L[tmp] = arr[tmp2];
            tmp2++;
        }
        
        int tmp3 = (int) m+1;
        for(int tmp = 0; tmp < n2; tmp++){
            R[tmp] = arr[tmp3];
            tmp3++;
        }
        
        int k  = (int) l;
        
        int s1 = 0; 
        int s2 = 0;
        
        while(s1 < n1 && s2 < n2){
            
            if(L[s1] > R[s2]){
                inversions += (m - l - s1 +1);
                arr[k] = R[s2];
                s2++;
            }
            else if(L[s1] < R[s2]){
                arr[k] = L[s1];
                s1++;
            }
            else{
                arr[k] = L[s1];
                s1++;
            }
            
            k++;
            
        }
        
        while(s1 < n1){
            arr[k] = L[s1];
            s1++;
            k++;
            // inversions++;
        }
        
        while(s2 < n2){
            arr[k] = R[s2];
            s2++;
            k++;
        }
        
        return;
         
    }
    void mergeSort(long arr[], long l, long r)
    {
        //code here
        
        if(l < r){
            
            long m = l + (r - l)/2;
            
            mergeSort(arr, l, m);
            mergeSort(arr, m+ 1, r);
            
            merge(arr, l , m, r);
        }
        
        
    }

    
    
}