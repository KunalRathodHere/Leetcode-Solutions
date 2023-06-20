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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] A = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.minSwaps(n, A);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public  int minSwaps(int n, int[] A) {
        // code here
    
        int[] in_order = new int[n];
        int i= 0;
        
        Stack<Integer> st = new Stack<>();
        
        int curr= 0;
        int node = A[curr];
        
        while(!st.isEmpty() || curr < n ){
            
            // int node = A[curr];
            
            while(curr < n){
                
                st.add(curr);
                // node = left(curr);
                curr = curr * 2 + 1;
                
                
            }
            
            
            
            curr = st.pop();
            in_order[i] = A[curr];
            i++;
            
            curr = curr * 2 + 2;
            
        }
        
        Arrays.sort(A);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int j=0; j<n;j++){
            map.put(A[j], j);
        }
        
        int swaps = 0;

        int j =0;
        
        while(j < n){
            
            while(A[j] != in_order[j]){
                
                int real = map.get(in_order[j]);
                
                int temp = in_order[real];
                in_order[real] = in_order[j];
                in_order[j] = temp;
                swaps++;
                
            }
            j++;
            
        }
        
        
        
        return swaps;
       
        // return 0;
    }
    
    int left(int i, int[] A){
        
        int l = 2 * i + 1;
        if(l >= A.length) return -1;
        
        return A[l];
        
    }

    int right(int i, int[] A){
        
        int r = 2 * i + 2;
        if(r >= A.length) return -1;
        
        return A[r];
    }
    
    
    
}
        
