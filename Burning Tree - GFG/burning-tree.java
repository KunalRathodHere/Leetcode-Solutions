//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    /*class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }*/
    
    public  int minTime(Node root, int target) 
    {
        // Your code goes here
        
        HashMap<Node, Node> map =new HashMap<>();
        
        Node t = findT(root, target, map);
        
        dfs(t, map, 0, new HashSet<Node>());
        
        return max-1;
        
    }
     int max = 0;
    public  void dfs(Node n, HashMap<Node, Node> map, int k, HashSet<Node> visited){
        
        if(n == null){
            
            max = Math.max(max, k);
            return;
        }
        
        if(visited.contains(n)) return;
        else visited.add(n);
        
        // System.out.println(n.data + " " + k);
        
        dfs(n.left, map, k+1, visited);
        dfs(n.right, map, k+1, visited);
        
        if(map.containsKey(n)){
            dfs(map.get(n), map, k+1, visited);
        }
        
        
        return;
        
    }
    
    
    public  Node findT(Node root, int target, HashMap<Node, Node> map){
        
        if(root == null) return null;
        if(root.data == target) return root;
        
        if(root.left != null){
            map.put(root.left, root);
        }
        if(root.right != null){
            map.put(root.right, root);
        }
        
        Node left = findT(root.left, target, map);
        Node right = findT(root.right, target, map);
        
        if(left != null) return left;
        else if(right != null) return right;
        return null;
        
    }
    
}