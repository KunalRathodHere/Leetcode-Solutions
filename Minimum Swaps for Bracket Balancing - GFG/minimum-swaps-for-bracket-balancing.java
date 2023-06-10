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
        
        Stack<Character> st =new Stack<>();
        
        st.add(S.charAt(0));
        int cnt = 0;
        
        
        for(int i = 1; i<S.length(); i++){
            
            if(st.isEmpty()) st.add(S.charAt(i));
            
            else if(st.peek() == '[' && S.charAt(i) == ']'){
                 st.pop();
            }
            else if(st.peek() == '[' && S.charAt(i) == '['){
                st.add('[');
            }
            else if(st.peek() == ']' && S.charAt(i) == '['){
                cnt += st.size();
                st.pop();
            }
            else if(st.peek() == ']' && S.charAt(i) == ']'){
                st.add(']');
            }
            
        }
        return cnt;
        
    }
}