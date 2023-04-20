//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public int[] check(String a, String b){
        
        int n = a.length();
        int m = b.length();
        int i =0; 
        
        int[] ans = new int[2];
        while(i<n && i<m){
            
            if(a.charAt(i) != b.charAt(i)){
                ans[0] = a.charAt(i) - 'a';
                ans[1] = b.charAt(i) - 'a';
                return ans;
            }
            else{
                i++;
            }
            
        }
        
        return new int[0];
        
    }
    
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[K];
        
        for(int i =0; i<K; i++){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i =0; i<N-1; i++){
            
            int[] seq = check(dict[i], dict[i+1]);
            
            if(seq.length == 0){
                continue;
            }
            
            adj.get(seq[0]).add(seq[1]);
            
            indeg[seq[1]]++;
            
        }
        
        Queue<Integer> q = new LinkedList<Integer>();
        
        for(int i =0; i<K; i++){
            
            if(indeg[i] == 0){
                q.add(i);
            }
            
        }
        
        Stack<Integer> s = new Stack<Integer>();
        
        
        while(!q.isEmpty()){
            
            int curr = q.remove();
            s.push(curr);
            
            ArrayList<Integer> arr = adj.get(curr);
            
            for(int i: arr){
                indeg[i]--;
                if(indeg[i] == 0){
                    q.add(i);
                }
            }
            
        }
    
        // int[] ans = new int[K];
        String ans = "";
        int i =0; 
        while(!s.isEmpty()){
            int c = s.pop();
            
            ans =  Character.toString(c + 'a') + ans;
            
            i++;
        }
        
        // System.out.println(ans);
        return ans;
        // return ans;
    }
}