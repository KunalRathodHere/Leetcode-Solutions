//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    public static boolean isMerged(int[] a, int[] b, int[] merged){
        if(a.length + b.length != merged.length)
            return false;
        
        int[] m = new int[merged.length];
        int i = 0;
        for(int e : a)
            m[i++] = e;
        for(int e : b)
            m[i++] = e;
        Arrays.sort(m);
        int[] mergedCopy = Arrays.copyOf(merged, merged.length);
        Arrays.sort(mergedCopy);
        if(!Arrays.equals(m, mergedCopy))
            return false;
        
        for(i = 1; i < merged.length; i++){
            if(merged[i] > merged[(i-1)/2])
                return false;
        }
        
        return true;
    }
    
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int m = Integer.parseInt(stt.nextToken());
            int a[] = new int[n];
            int b[] = new int[m];
            int merged[];
            
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            String inputLine1[] = br.readLine().trim().split(" ");
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(inputLine1[i]);
            }
            
            
            Solution obj = new Solution();
            int[] copyA = Arrays.copyOf(a, a.length), copyB = Arrays.copyOf(b, b.length);
            merged = obj.mergeHeaps(a, b, n, m);
            
            boolean flag = isMerged(copyA, copyB, merged);
            System.out.println(flag ? 1 : 0);
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    public int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here
        
        int[] ans = new int[n + m];
        
        for(int i=0; i<n; i++){
            ans[i]= a[i];
        }
        
        for(int i = n ; i< n + m ; i++){
            ans[i] = b[i-n];
        }
        
        buildheap(ans, n + m);
        return ans;
    }
    
    public void buildheap(int[] ans , int n){
        int limit = (n/2)-1;
        
        for(int i = limit; i>=0; i--){
            heapify(ans, i, n);
        }
    }
    
    public void heapify(int[] ans, int i, int n){
        
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        int max = i;
        
        if(left < n && ans[left] > ans[max] ){
            max = left;
        }
        if(right < n && ans[right] > ans[max]){
            max = right;
        }
        
        if(max != i){
            int temp = ans[i];
            ans[i] = ans[max];
            ans[max] = temp;
            heapify(ans, max, n);
        }
        
        
        
    }
    
}