//{ Driver Code Starts
import java.util.*;

class Merge_Sort
{
    //method to print the elements of the array
	static void printArray(int arr[])
    {
        StringBuffer sb=new StringBuffer("");
        int n = arr.length;
        for (int i=0; i<n; ++i)
            sb.append(arr[i]+" ");
        System.out.println(sb.toString());
    }

    

	public static void main(String args[])
	{
	    //taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking testcases
		int T = sc.nextInt();
		while(T>0)
		{
		    //taking elements count
			int n = sc.nextInt();
			
			//creating an object of class Merge_Sort
			Merge_Sort ms = new Merge_Sort();
			
			//creating an array of size n
			int arr[] = new int[n];
			
			//adding elements to the array
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();

            
			Solution g = new Solution();
			
			//calling the method mergeSort
			g.mergeSort(arr,0,arr.length-1);

            //calling the method printArray
			ms.printArray(arr);
		T--;
		}
	}
}



// } Driver Code Ends


class Solution
{
    void merge(int arr[], int l, int m, int r)
    {
         // Your code here
        
        int i = l;
        int j  = m + 1;
        
        int n1 = m - l + 1;
        int n2 = r - m;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        int tmp2 = l;
        for(int tmp = 0; tmp < n1; tmp++){
            L[tmp] = arr[tmp2];
            tmp2++;
        }
        
        int tmp3 = m+1;
        for(int tmp = 0; tmp < n2; tmp++){
            R[tmp] = arr[tmp3];
            tmp3++;
        }
        
        int k  = l;
        
        int s1 = 0; 
        int s2 = 0;
        
        while(s1 < n1 && s2 < n2){
            
            if(L[s1] > R[s2]){
                arr[k] = R[s2];
                s2++;
            }
            else if(L[s1] < R[s2]){
                arr[k] = L[s1];
                s1++;
            }
            else{
                arr[k] = L[s1];
                s1++;
            }
            
            k++;
            
        }
        
        while(s1 < n1){
            arr[k] = L[s1];
            s1++;
            k++;
        }
        
        while(s2 < n2){
            arr[k] = R[s2];
            s2++;
            k++;
        }
        
        return;
         
    }
    void mergeSort(int arr[], int l, int r)
    {
        //code here
        
        if(l < r){
            
            int m = l + (r - l)/2;
            
            mergeSort(arr, l, m);
            mergeSort(arr, m+ 1, r);
            
            merge(arr, l , m, r);
        }
        
        
    }
}
