//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
    		System.out.println (new Sol().countRev (s));
        }
        
    }
}
// Contributed By: Pranay Bansal

// } Driver Code Ends


//User function Template for Java

class Sol
{
    int countRev (String str)
    {
        Stack<Character> st = new Stack<Character>();
        int ans = 0;
     
        // Step 2: Run a loop for each character of the string
        for (int i = 0; i < str.length(); i++) {
           
            // Step 2.1: If ' { ' encountered push it to the
            // stack
            if (str.charAt(i) == '{')
                st.add(str.charAt(i));
            // Step 2.2: If ' } ' is encountered
            else {
                // Step 2.2.1: If stack has a '{' present for
                // '}' encountered, pop from the stack.
                if (!st.isEmpty())
                    st.pop();
               
                // Step 2.2.2: If stack is empty, change '}' to
                // '{' and push it to stack and increment ans by
                // 1
                else {
                    st.add('{');
                    ans++;
                }
            }
        }
        // Step 3: if stack size is odd return -1.
        if (st.size() % 2 != 0)
            return -1;
       
        // Step 4: Increment ans by ( stackSize/2 ).
        ans += st.size() / 2;
     
        return ans;
    }
}
 