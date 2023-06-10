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
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minimumNumberOfSwaps(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int minimumNumberOfSwaps(String S){
        // code here
        
        int left = 0;
        int right = 0;
        int swap =0;
        int imm = 0;
        
        for(int i =0; i<S.length(); i++){
            
            char curr = S.charAt(i);
            
            if(curr == '['){
                left++;
                if(imm> 0){
                    swap+= imm;
                    imm--;
                }
                
            }
            else{
                right++;
                
                imm = (right - left);
            }
            
        }
        
        return swap;
        
    }
}