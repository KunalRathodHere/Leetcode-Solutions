//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;


class GFG
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        int n;
        while(t-- > 0){
            n = sc.nextInt();
    
            Solution obj = new Solution();
            for(int i = 1; i <= n; i++)
            {
                int x =sc.nextInt();
                obj.insertHeap(x);
                System.out.println((int)Math.floor(obj.getMedian()));
            }
        }
        
        
    }
}


// } Driver Code Ends


class Solution
{
    
    static PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a);
    static PriorityQueue<Integer> min_heap = new PriorityQueue<>();
    
    
    
    //Function to insert heap.
    public static void insertHeap(int x)
    {
        // add your code here
        
        max_heap.add(x);
        
        balanceHeaps();
        
    }
    
    //Function to balance heaps.
    public static void balanceHeaps()
    {
       // add your code here
       
       if(max_heap.size() == min_heap.size() || (min_heap.size() + 1 == max_heap.size())  ){
           
           if(min_heap.size() + 1 == max_heap.size()){
               
               min_heap.add(max_heap.poll());
               max_heap.add(min_heap.poll());
               
               
           }
           
           return;
       } 
        else{
           int a = max_heap.remove();
           min_heap.add(a); 
        }
         
    }
    
    //Function to return Median.
    public static double getMedian()
    {
        // add your code here
        if(min_heap.size() == max_heap.size()){
            
            return (min_heap.peek() + max_heap.peek())/2;
            
        } else{
            return max_heap.peek();
        }
        
        
    }
    
}