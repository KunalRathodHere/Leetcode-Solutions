//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());
        while(t-- > 0){
            String s = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.firstRepChar(s));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    String firstRepChar(String s) 
    { 
        // code here
        char[] arr = new char[26];
        
        Arrays.fill(arr, '0');
        
         
        for(int i=0; i<s.length(); i++){
            
            // System.out.println(s.charAt(i) + "  " + arr[s.charAt(i) - 'a'] ) ;
            if(arr[s.charAt(i) - 'a'] != '0') {
                
                return Character.toString(s.charAt(i));
                
            }
            else arr[s.charAt(i) - 'a'] = '1';
        }
        
        
        
        return "-1";
    }
} 