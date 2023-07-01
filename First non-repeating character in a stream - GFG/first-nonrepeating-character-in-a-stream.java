//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            out.println(ans);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        
        List<Character> dll = new ArrayList<>();
        
        boolean[] repeated = new boolean[256];
        
        StringBuilder ans=new StringBuilder();

        
        for(int i=0; i<A.length(); i++){
            
            char curr= A.charAt(i);
            
            if(repeated[curr ] == false){
                
                if(dll.contains(curr))
                {
                    dll.remove((Character) curr);
                
                    repeated[curr] = true;
                }
                else{
                    dll.add(curr);
                    
                }
            }
            
            if(dll.size()!= 0){
                ans.append(dll.get(0));
            } else{
                ans.append("#");
            }
            
        }
        
        return ans.toString();
        
    }
}