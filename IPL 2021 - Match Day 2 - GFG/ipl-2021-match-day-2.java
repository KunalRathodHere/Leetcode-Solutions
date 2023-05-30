//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String args[]) {
        // taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total number of elements
            int n = sc.nextInt();

            // taking size of subArrays
            int k = sc.nextInt();

            // Declaring and Intializing an array of size n
            int arr[] = new int[n];

            // adding all the elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            // Calling the method max_of_subarrays of class solve
            // and storing the result in an ArrayList
            ArrayList<Integer> res = new Solution().max_of_subarrays(arr, n, k);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Pair{
    int idx;
    int val;
    
    Pair(int i, int v){
        idx = i;
        val = v;
    }
}

class Solution {
    static ArrayList<Integer> max_of_subarrays(int arr[], int n, int k) {
        // Your code here
        
        
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);
        
        
        for(int i=0; i<k; i++){
            pq.add(new Pair(i, arr[i]));
        }
        
        // pq.add(pq.peek().val);
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(pq.peek().val);
        for(int i = k; i<n; i++){
            
            pq.add(new Pair(i, arr[i]));
            
            while(pq.peek().idx <= i-k){
                pq.remove();
            }
            
            ans.add(pq.peek().val);
            
        }
        
        return ans;
    }
}