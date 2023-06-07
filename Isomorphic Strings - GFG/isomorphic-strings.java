//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.*;


public class Driver {
    
    public static void main(String[] args)throws IOException {
       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0)
        {
            String s1 = br.readLine();
            String s2 = br.readLine();
            
            Solution obj = new Solution();
            
            boolean a = obj.areIsomorphic(s1,s2);
            if(a)
            System.out.println(1);
            else
            System.out.println(0);
        }
    }
    
}

// } Driver Code Ends


class Solution
{
    //Function to check if two strings are isomorphic.
    public static boolean areIsomorphic(String s,String t)
    {
        // Your code here
        
        char[] s1 = new char[256];
        char[] s2 = new char[256];
        
        if(s.length() != t.length()) return false;
        
        Arrays.fill(s1, '0');
        Arrays.fill(s2, '0');
        for(int i=0; i<s.length(); i++){
            
            int curr = s.charAt(i);
            int curr2 = t.charAt(i);
            if(s1[curr] != '0' && s1[curr] != t.charAt(i)) return false;
            if(s2[curr2] != '0' && s2[curr2] != s.charAt(i)) return false;

            s1[curr] = t.charAt(i);
            s2[curr2] = s.charAt(i);
            
        }
        
        return true;
    }
}