//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.countRevPairs(N, arr);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int countRevPairs(int N, int arr[]) {
        // Code here
        
        mergeSort(0, N-1, arr);
        
        return cnt;
        
    }
    
    int cnt = 0;
    
    public void mergeSort(int low, int high, int[] arr){
        
        if(low < high){
        
        int mid = low + (high - low)/2;
        
        mergeSort(low, mid , arr);
        mergeSort(mid + 1, high, arr);
        
        merge(low, mid, high, arr);
        }        
    }
    
    public void merge(int low, int mid, int high, int[] arr){
        
        int[] left = new int[mid - low + 1];
        int[] right = new int[high - mid];
        
        for(int i = low,  j =0; i<= mid; i++, j++)
        {
            left[j] = arr[i];
        }
        
        for(int i = mid + 1, j =0; i<= high; i++, j++){
            right[j] = arr[i];
        }
        
        int a = left.length;
        int b = right.length;
        int i= 0, j =0, k = low;
        
        while(i < a && j < b){
            
            if(left[i] > right[j] * 2){
                
                // System.out.println()
                
                cnt += (a - i );
                j++;
            } else{
                i++;
            }
            
        }
        i =0; j =0;
        
        while(i < a && j < b){
            if(left[i] >= right[j]){
                arr[k++] = right[j];
                j++;
            } else{
                arr[k++] = left[i];
                i++;
            }
        }
        
        while(i < a){
            arr[k++] = left[i++];
        }
        
        while(j < b){
            arr[k++] = right[j++];
        }
        
    }
    
    
}