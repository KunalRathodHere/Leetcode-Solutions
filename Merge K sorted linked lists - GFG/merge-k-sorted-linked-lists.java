//{ Driver Code Starts
import java.util.*;

class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}


class GfG
{
    public static void printList(Node node)
    {
        while(node != null)
        {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-- > 0)
        {   
            int N = sc.nextInt();
            
            Node []a = new Node[N];
            
            for(int i = 0; i < N; i++)
            {
                int n = sc.nextInt();
                
                Node head = new Node(sc.nextInt());
                Node tail = head;
                
                for(int j=0; j<n-1; j++)
                {
                    tail.next = new Node(sc.nextInt());
                    tail = tail.next;
                }
                
                a[i] = head;
            }
            
            Solution g = new Solution();
             
            Node res = g.mergeKList(a,N);
            if(res!=null)
                printList(res);
            System.out.println();
        }
    }
}
// } Driver Code Ends


/*class Node
{
    int data;
    Node next;
    
    Node(int key)
    {
        data = key;
        next = null;
    }
}
*/

// a is an array of Nodes of the heads of linked lists
// and N is size of array a


class Solution
{
    //Function to merge K sorted linked list.
    Node mergeKList(Node[]arr,int K)
    {
        //Add your code here.
        if(K == 0) return null;
        
        Node dummy = new Node(-1);
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
    return o1.data - o2.data;
  });
        
        for(int i=0; i<K; i++){
            
            Node curr = arr[i];
            if(curr != null){
                pq.add(curr);
            }
        }
        
        Node prev = dummy;
        while(!pq.isEmpty())
        {
            
            Node curr = pq.remove();
            prev.next = curr;
            prev = curr;
            
            if(curr.next != null){
                pq.add(curr.next);
            }
            
        }
        
        return dummy.next;
    }
}
