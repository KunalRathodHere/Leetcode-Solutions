//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int K; 
            K = Integer.parseInt(br.readLine());
            
            
            int[] Arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.kthLargest(N, K, Arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kthLargest(int N, int K, int[] Arr) {
        // code here
        int[] prefix_sum = new int[N+1];
        prefix_sum[0] = 0;
        prefix_sum[1] =  Arr[0];
        for(int i=2; i<=N; i++){
            prefix_sum[i] = Arr[i-1] + prefix_sum[i-1];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        
        for(int i=1; i<=N; i++){
            for(int j = i; j<=N; j++){
                
                pq.add(prefix_sum[j] - prefix_sum[i-1]);
                
                if(pq.size() > K) pq.remove();
                
            }
        }

        return pq.peek();
        
        
    }
}
        
