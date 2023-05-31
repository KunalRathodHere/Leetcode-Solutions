//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    
    int left(int i){
        return 2 * i + 1;
    }
    
    int right(int i){
        return 2 * i + 2;
    }
    
    
    
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)
    {
        // Your code here
        int range = (n/2) -1;
        
        for(int i =range; i>=0; i--){
            heapify(arr, n, i);
        }
    }
 
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)
    {
        // Your code here
        int left = left(i);
        int right = right(i);
        
        int max = i;
        
        if(left < n && arr[left] > arr[max]){
            max = left;
        }
        if(right < n && arr[right] > arr[max]){
            max = right;
        }
        
        if(max != i){
            int temp = arr[i];
            arr[i]= arr[max];
            arr[max] = temp;
            heapify(arr, n, max);
        }
        
        
    }
    
    //Function to sort an array using Heap Sort.
    public void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        
        int temp = n;
        
        while(temp>1){
            int max = arr[0];
            int end = temp -1;
            arr[0] = arr[end];
            arr[end]= max;
            temp--;
            heapify(arr, temp, 0);
        }
        
    }
 }
 
 
