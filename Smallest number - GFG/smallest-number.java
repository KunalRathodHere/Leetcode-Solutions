//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] inp=read.readLine().split(" ");
            int S=Integer.parseInt(inp[0]);
            int D=Integer.parseInt(inp[1]);

            Solution ob = new Solution();
            System.out.println(ob.smallestNumber(S,D));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String smallestNumber(int S, int D){
        // code here
        
        // if(S == 0) return "0";
        
        if(S > D*9) return "-1";
        
        int num = S;
        String ans = "";
        
        num--;
        
        for(int i= D-1; i>0; i--){
            // System.out.println(ans);
            if(num > 9){
                // System.out.println("here");
                ans = "9" + ans;
                num-=9;
            } else{
                ans = Integer.toString(num) + ans;
                num = 0;
            }
            
        }
        
        
        ans = Integer.toString(1 + num) + ans;
        
        return ans;
    }
}