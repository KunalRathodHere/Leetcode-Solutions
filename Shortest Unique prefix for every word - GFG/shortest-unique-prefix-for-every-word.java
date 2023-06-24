//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class TrieNode{
    
    TrieNode[] children = new TrieNode[26];
    int no_of_child = 0;
    boolean isEnd = false;
    
    TrieNode(){
        
        for(int i=0; i<26; i++){
            children[i] = null;
        }
    }
}




class Solution {
    
    static void insert(TrieNode root, String key){
        
        int level = 0;
        TrieNode curr = root;
        
        for(level = 0; level < key.length(); level++){
            
            int char_idx = key.charAt(level) - 'a';
            
            if(curr.children[char_idx] == null){
                
                curr.children[char_idx] = new TrieNode();
                
            }
            curr.no_of_child++;
            curr = curr.children[char_idx];
        }
        
        curr.isEnd = true;
        
    }
    
    static String prefix(TrieNode root, String key){
        
        int level = 0;
        int length = key.length();
        TrieNode curr = root;
        
        for(level =0; level < length; level++){
            
            int char_idx = key.charAt(level) - 'a'; 
            curr = curr.children[char_idx];
            
            if(curr.no_of_child <= 1){
                return key.substring(0, level + 1);
            }
            
        }
        
        return key;
        
        
    }
    
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        
        TrieNode root = new TrieNode();
        
        for(int i=0; i<arr.length; i++){
            insert(root, arr[i]);
        }
        
        String[] ans = new String[arr.length];
        
        for(int i =0; i<arr.length; i++){
            
            ans[i] = prefix(root, arr[i]);
            
        }
        
        return ans;
    }
};