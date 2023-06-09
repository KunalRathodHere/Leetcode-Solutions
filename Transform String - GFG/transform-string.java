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
        if(A.length() != B.length()) return -1;
        
        int i = A.length()-1;
        int j = B.length() - 1;
        int cnt = 0;
        
        int count[] = new int[256];
 
        // count characters in A
        // subtract count for every character in B
        for (i = 0; i < A.length(); i++) {
            count[A.charAt(i)]++;
            count[B.charAt(i)]--;
        }
 
        // Check if all counts become 0
        for (i = 0; i < 256; i++)
            if (count[i] != 0)
                return -1;
 
        i = A.length() - 1;
        j = B.length() - 1;
        
        String ans = "";
        String front = "";
        while( i >= 0){
            
            if(A.charAt(i) != B.charAt(j)){
                
                
                cnt++;
                i--;
            }
            else{
                
                ans = A.charAt(i) + ans;
                i--;
                j--;
            }
        }
        
        // System.out.println(front);
        // front =  + ans;
        // System.out.println(front + " " + j);
        // int ii = A.length()-1;
        // int jj = B.length()-1;
        
        // while(ii >= 0){
        //     if(front.charAt(ii) == B.charAt(jj)){
        //         ii--;
        //         jj--;
        //     }
        //     else{front
        //         return -1;
        //     }
        // }
        
        return cnt;
    }
}