//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String St[] = read.readLine().split(" ");
            
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
            
            String S[] = read.readLine().split(" ");
            
            int[] arr = new int[N];
            
            for(int i=0 ; i<N ; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.splitArray(arr,N,K));
        }
    }
}
// } Driver Code Ends


class Solution {
    
    static boolean isPossible(int[] arr, int min_possible, int k){
        
        int total_arrays = 1;
        int curr_sum = 0;
        
        for(int i=0; i<arr.length; i++){
            
            curr_sum += arr[i];
            if(curr_sum > min_possible){
                total_arrays++;
                curr_sum = arr[i];
            }
            
        }
        
        return (total_arrays <= k);
    }
    
    static int splitArray(int[] arr , int N, int K) {
        // code here
        
        int total = 0;
        int max = 0;
        
        for(int i=0; i<N;i++){
            total += arr[i];
            max = (arr[i] > max) ? arr[i] : max;
            
        }
        
        int start = max;
        int end = total;
        int ans = -1;
        while(start <= end){
            
            int mid = start + (end - start)/2;
            
            if(isPossible(arr, mid, K)){
                
                end = mid -1;
                ans = mid;
            }
            else{
                start = mid + 1;
            }
        }
        
        return ans;
    }
};