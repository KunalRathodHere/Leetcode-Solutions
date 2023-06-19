//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

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

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    Node mergeSort(Node head)
    {
        // add your code here
        
        return mergesort(head);
        
        
        
    }
    
    Node mergesort(Node head){
        
        if(head == null) return null;
        if(head.next == null) return head;
        
        
        Node mid_prev = head;
        Node end_prev = head;
        Node mid = head;
        Node end = head;
        
        while(end != null && end.next != null){
            mid_prev = mid;
            end_prev = end;
            mid = mid.next;
            end = end.next.next;
            
        }
        
        mid_prev.next = null;
        
        // System.out.println("head " + head.data + " mid " + mid.data );
        Node sortedA =  mergesort(head);
        Node sortedB =  mergesort(mid);
        
        // System.out.println("after");
        // System.out.println("head " + sortedA.data + " mid " + sortedB.data );
        
        Node newhead = merge(sortedA, sortedB);
        // if(newhead != null) System.out.println("new head" + newhead.data);
        
        return newhead;
    }
    
    Node merge(Node A, Node B){
        
        if(A == null) return B;
        if(B == null) return A;
        
        
        Node dummyhead = new Node(-1);
        
        Node curr = dummyhead;
        Node a = A; Node b= B;
        
        while(a  != null && b != null){
            // System.out.println(curr.data);
            if(a.data <= b.data){
                
                curr.next = a;
                a = a.next;
                curr = curr.next;
                
            } else{
                
                curr.next = b;
                b = b.next;
                curr = curr.next;
                
            }
            
        }
        
        while(a != null){
            curr.next = a;
            curr = curr.next;
            a = a.next;
        }
        
        while(b != null){
            
            curr.next = b;
            b = b.next;
            curr = curr.next;
            
        }
        
        return dummyhead.next;
        
    }
    
    
}


