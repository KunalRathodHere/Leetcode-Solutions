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
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    public List<String> find_permutation(String S) {
        // Code here
        
        char[] c = S.toCharArray();
        
        Arrays.sort(c);
        int n= S.length();
        
        boolean[] ans = new boolean[n];
        
        function(c, ans, n, "");
        return fans;
    }
    
    List<String> fans = new ArrayList<>();
    
    public void function(char[] c, boolean[] map, int n, String curr){
        
        if(curr.length() == n) {
            fans.add(curr);
            return;
        }
        
        
        
        for(int i=0; i<n; i++){
            
            if(map[i] == true || (i > 0 && (c[i] == c[i-1]) && (map[i-1] == true))) continue;
            
            if(map[i] == false   ){
                // if(i > 0 && c[i] == c[i-1] && map[i] == true) continue;
                
                map[i] = true;
                function(c, map, n, curr + c[i]);
                map[i] = false;
            }
        }
        
        return;
    }
    
}