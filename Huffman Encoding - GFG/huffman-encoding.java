//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        }
	}
}
// } Driver Code Ends


//User function Template for Java


class Solution {
    
    ArrayList<String> ans = new ArrayList<>();
    
    public void print(Node root, String curr){
        
        if(root.left == null && root.right == null && Character.isLetter(root.c))
        {
            ans.add(curr);
            return;
        }
        
          print(root.left, curr + '0');
          print(root.right, curr + '1');
    }
    
    
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        // Code here
        
        PriorityQueue<Node> pq =
            new PriorityQueue<>( new Comparator<Node>(){
            public int compare(Node a, Node b){
                if(a.data >= b.data){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        });
        
        for(int i=0; i<S.length(); i++){
            
            pq.add(new Node(f[i], S.charAt(i)  ));
            
        }
        
        while(pq.size() >1 ){
            
            Node left = pq.remove();
            Node right = pq.remove();
            
            Node temp_parent = new Node(left.data + right.data, '-');
            temp_parent.left = left;
            temp_parent.right = right;
            
            pq.add(temp_parent);
            
        }
        
        Node root = pq.remove();
        
        print(root, "");
        
        return ans;
        
        
    }
    
    
}

class Node{
    
    int data;
    char c;
    
    Node left;
    Node right;
    
    Node(int d, char cc){
        data = d;
        c = cc;
        left  = null;
        right = null;
    }
    
}