//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N=sc.nextInt();
			ArrayList<Integer> arr = new ArrayList<>();
			for(int i = 0; i < N ; i++){
			    arr.add(sc.nextInt());
			}
            Solution ob = new Solution();
         
            ArrayList<Integer> ans = ob.subsetSums(arr,N);
            Collections.sort(ans);
            for(int sum : ans){
                System.out.print(sum+" ");
            }
            System.out.println();
        }  
    }
}

// } Driver Code Ends


//User function Template for Java//User function Template for Java
class Solution{
    
    ArrayList<Integer> ans = new ArrayList<>();
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int N){
        // code here
        
        ans.add(0);
        function(0, arr, 0);
        
        Collections.sort(ans);
        
        return ans;
        
        
    }
    
    int function(int idx, ArrayList<Integer> arr, int currsum){
        
        if(idx >= arr.size()) return 0;
        
        // if(idx == arr.size()-1) ans.add(currsum);
        
        int a =  function(idx +1, arr, currsum + arr.get(idx));
        int b =  function(idx+ 1, arr, currsum);
        
        
        ans.add(currsum + arr.get(idx));
        // System.out.println(currsum);
        return -1;
    }
}