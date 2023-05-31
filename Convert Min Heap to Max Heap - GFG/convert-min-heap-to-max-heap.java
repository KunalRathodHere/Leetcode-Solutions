//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
     void convertMinToMaxHeap(int N, int arr[]) {
    // code here
        buildheap(arr, N);
    }
    
    void buildheap(int[] arr, int N){
        
        int limit = N/2 + 1;
        
        for(int i= limit; i>=0; i--){
            heapify(arr, N, i);
        }
        
    }
    
    void heapify(int[] arr, int N, int i){
        
        int curr = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        int max = i;
        if(left < N && arr[left] > arr[max]){
            // left = max;
            max = left;
            
        }
        if(right < N && arr[right] > arr[max]){
            // right = max;
            max = right;
        }
        
        if(max != i){
            int temp = arr[i];
            arr[i]= arr[max];
            arr[max] = temp;
            heapify(arr, N, max);
            
        }
        
    }
}
     