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
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class TrieNode{
    
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
    
    TrieNode(){
        
        for(int i=0; i<26; i++){
            children[i] = null;
        }
        
    }
    
}

class Solution
{
    public static void insert(TrieNode root, String key){
        
        TrieNode curr = root;
        
        for(int level =0; level < key.length(); level++){
            
            int char_idx = key.charAt(level)- 'a';
            
            if(curr.children[char_idx] == null){
                curr.children[char_idx] = new TrieNode();
            }
            curr = curr.children[char_idx];
            
        }
        
        curr.isEnd = true;
        
    }
    
    public static boolean search(TrieNode root, String key){
        
        TrieNode curr = root;
        
        for(int level =0; level < key.length(); level++){
            
            int char_idx = key.charAt(level) - 'a';
            
            if(curr.children[char_idx] == null) return false;
            
            curr = curr.children[char_idx];
            
        }
        
        if(curr == null) return false;
        if(curr.isEnd == false) return false;
        
        return true;
        
    }
    
    
    public static int wordBreak(String A, ArrayList<String> B )
    {
        //code here
        //make trie for all
        //insert
        //serach 
        //simple in and out
        
        TrieNode root = new TrieNode();
        for(int i=0; i<B.size(); i++){
            insert(root, B.get(i));
        }
        
        boolean ans =  function(0, A, root);
        return (ans) ? 1 : 0;
        
    }
    
    public static boolean function(int idx, String A, TrieNode root){
        
        if(A.length() == 0) return true;
        
        for(int i = 1; i<A.length()+1; i++){
            
            boolean parition = search(root, A.substring(0, i)) && function(i, A.substring(i), root);
            if(parition) return true;
            
        }
        
        return false;
    }
    
    
}