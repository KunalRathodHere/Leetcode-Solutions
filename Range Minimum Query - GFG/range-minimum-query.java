//{ Driver Code Starts
import java.util.*;
import java.lang.*;

class Minimum
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
              arr[i] = sc.nextInt();
              
              GfG gfg = new GfG();
            int Q = sc.nextInt();
            
            
            int st[] = gfg.constructST(arr, n);
            int l,r;
            for(int i = 0; i < Q; i++)
            {
                int a = sc.nextInt();
                int b = sc.nextInt();
                l = Math.min(a,b);
                r = Math.max(a,b);
                
                System.out.print(gfg.RMQ(st, n, l, r) + " ");
                
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


/* The functions which 
builds the segment tree */
class GfG
{
    
    static int st[];
    static int n_st;
    public static int[] constructST(int arr[], int n)
    {
        // Add your code here
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
 
        //Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, x) - 1;
 
        st = new int[max_size]; // Memory allocation
        
        construct(arr, 0, n-1, 0);
        

        return st;
    }
    
    public static int construct(int[] arr, int low, int high, int idx){
        
        if(low == high){
            st[idx] = arr[low];
            return arr[low] ;
        }
        
        int mid = low +  (high - low)/2;
        
        st[idx] = Math.min(  construct(arr, low, mid, 2 * idx + 1),
        construct(arr, mid + 1, high, 2 * idx + 2));
        
        
        return st[idx];
    }
    
    
    
    /* The functions returns the
      min element in the range
      from l and r */
    public static int RMQ(int st[], int n, int l, int r)
    {
       // Add your code here
       
       if(l < 0 || r >= n || l > r) return -1;
       
       return sol(st, l, r, 0, n-1, 0);
       
    }
    
    public static int sol(int st[], int l, int r, int curr_l, int curr_r, int idx){
        
        // System.out.println(curr_l + " " + curr_r);
        
        if(l <= curr_l && r >= curr_r){
            return st[idx];
        }
        
        if(curr_l > r || curr_r < l) return Integer.MAX_VALUE;
        
        int mid = curr_l + ( - curr_l + curr_r)/2;
        
        return Math.min(sol(st, l, r, curr_l, mid, 2 * idx + 1 ), 
        sol(st, l, r, mid+1, curr_r, 2 * idx + 2));
        
    }
    
    
    
}