//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transform (A, B));
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transform (String A, String B)
    {
        // code here
        
        int[] arr = new int[256];
        if(A.length() != B.length()){
            return -1;
        }
        
        for(int i =0; i<A.length(); i++){
            arr[A.charAt(i)]++;
            arr[B.charAt(i)]--;
        }
        
        for(int i=0; i<256; i++){
            if(arr[i] != 0) return -1;
        }
        
        int i =A.length()-1;
        int j = i;
        int res = 0;
        while(i>=0){
            
            if(A.charAt(i) !=  B.charAt(j)){
                res++;
                i--;
            } else{
                i--;
                j--;
            }
            
        }
        
        return res;
        
    }
}