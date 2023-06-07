//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Sol
{
    public int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<B.size(); i++){
            set.add(B.get(i));
        }
        
        boolean ans = fcn(0,  A, set);
        if(ans) return 1;
        else return 0;
    
    }
    
    public boolean fcn(int idx, String A, HashSet<String> set){
        
        if(idx == A.length()) return true;
        
        boolean curr_ans = false;
        for(int end = idx+1; end <= A.length(); end++){
            
            String curr_substring = A.substring(idx, end);
            if(set.contains(curr_substring)){
                curr_ans = curr_ans || fcn(end, A, set);
                if(curr_ans) return true;
                
            }
            
        }
        return curr_ans;
        
        
    }
    
    
}