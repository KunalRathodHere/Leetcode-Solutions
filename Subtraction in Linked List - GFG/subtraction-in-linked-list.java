//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.subLinkedList(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* Structure of Linked list node

class Node
{
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

*/

class Solution
{
    
    Node reverse(Node head){
        
        if(head == null || head.next == null) return head;
        
        Node prev = null;
        Node curr = head;
        Node next = head.next;
        
        while(curr != null)
        {
            
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr =next;
            
        }
        
        return prev;
        
    }
    
     Node subLinkedList(Node l1, Node l2)
    {
        // code here
        
        Node a = l1, b = l2;
        boolean l1_bigger = true;
        boolean equal = true;
        
        while( a!= null && a.data == 0) a = a.next;
        while( b != null && b.data == 0) b = b.next;
        
        Node aa = a, bb = b;
        
        while( a != null && b != null){
            
            if(equal &&  a.data > b.data) {
                equal = false;
            } else if(equal && a.data < b.data){
                equal = false;
                l1_bigger = false;
            }
            a = a.next;
            b = b.next;
        }
        
        Node bigger, smaller;
        
        if(a == null && b == null){
            if(l1_bigger){
                bigger = aa;
                smaller = bb;
            } else{
                bigger = bb;
                smaller = aa;
            }
        }
        
        else if(a != null){
            bigger = aa;
            smaller = bb;
        } else{
            bigger = bb;
            smaller = aa;
        }
        
        Node first = reverse(bigger);
        Node second = reverse(smaller);
        
        Node subtracted = subtract(first, second);
        
        Node final_ans = reverse(subtracted);
        
        while(final_ans != null && final_ans.data == 0){
            final_ans = final_ans.next;
        }
        
        if(final_ans == null) return (new Node(0));
        
        return final_ans;
        
    }
    
    Node subtract(Node bigger, Node smaller){
        
        Node b = bigger, s = smaller;
        Node dummy = new Node(-1);
        Node curr = dummy;
        
        while(s != null){
            
            if(b.data >= s.data){
                
            }
            else {
                
                Node find = b;
                b.data = b.data + 10;
                find = find.next;
                while(find != null && find.data == 0){
                    find.data = 9;
                    find = find.next;
                }
                if(find != null) find.data = find.data - 1;
                
                
                
                
            }
    
            curr.next = new Node((b.data - s.data));
            b = b.next;
            s = s.next;
            curr = curr.next;
            
        }
        
        while(b != null){
            curr.next = new Node(b.data);
            b = b.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
}