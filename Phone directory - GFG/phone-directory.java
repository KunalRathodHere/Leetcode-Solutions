//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode{
    
    TrieNode[] child = new TrieNode[26];
    boolean isEnd;
    
    TrieNode(){
        
        for(int i=0; i< 26; i++){
            child[i] = null;
        }
        
        isEnd = false;
        
    }
    
}

class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
        // code here
        
        TrieNode root = new TrieNode();
        
        for(int i=0; i<contact.length; i++){
            
            construct(root, contact[i]);
            
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        
        search(ans, s, root);
        
        return ans;
        
    }
    
    static void search(ArrayList<ArrayList<String>> ans, String query, TrieNode root){
        
        int levels = query.length();
        
        TrieNode curr = root;
        String outside = "";
        for(int i=0; i<levels; i++){
            
            //go to this level and print all then traverse till the end 
            outside += query.charAt(i);
            ArrayList<String> curr_list = new ArrayList<>();
            int idx = query.charAt(i) - 'a';
            
            if(curr.child[idx] == null){
                curr_list.add("0");
                ans.add(curr_list);
                break;
            }
            
            curr = curr.child[idx];
            
            traverseAll(curr, outside, curr_list);
            ans.add(curr_list);
            
        }
        
        while(ans.size() < query.length()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("0");
            ans.add(temp);
        }
        
        
    }
    
    static void traverseAll(TrieNode curr, String str, ArrayList<String> ans){
        
        if(curr.isEnd){
            ans.add(str);
        }
        
        for(int i=0; i<26; i++){
            
            if(curr.child[i] != null){
                traverseAll(curr.child[i], str + (char) (i + 'a'), ans);
            }
            
        }
        
    }
    
    static void construct(TrieNode root, String s){
        
        int levels = s.length();
        TrieNode curr = root;
        
        for(int i=0; i<levels; i++){
            
            int idx = s.charAt(i) - 'a';
            
            if(curr.child[idx] == null){
                curr.child[idx] = new TrieNode();
            }
            
            curr = curr.child[idx];
            
        }
        
        curr.isEnd = true;
    }
    
}