//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class DriverClass
{
	public static void main(String args[]) 
	{
	   Scanner sc = new Scanner(System.in);
	   int t = sc.nextInt();
	   int range[];
	   while(t-- >0)
	   {
	     int n = sc.nextInt();
	     int k = sc.nextInt();
	     int arr[][] = new int[k][n];
	       for(int i = 0; i < k; i++)
	       {
	        for(int j = 0; j < n; j++)
	               arr[i][j] = sc.nextInt();
	       }
	       range = new Solution().findSmallestRange(arr, n, k);
	       System.out.println(range[0] + " " + range[1]);
	   }
	}
}

// } Driver Code Ends


class Num{
    
    int row;
    int col;
    int val;
    Num(int v, int r, int c){
        val = v;
        row = r;
        col = c;
    }
    
}

class Solution
{
	static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    //add your code here
	    
	    PriorityQueue<Num> pq = new PriorityQueue<>( (a, b) -> a.val - b.val );
	    
	    int min = Integer.MAX_VALUE;
	    int max = Integer.MIN_VALUE;
	    int range = Integer.MAX_VALUE;
	    
	    for(int i=0; i<k; i++){
	        
	        min = Math.min(arr[i][0], min);
	        max = Math.max(arr[i][0], max);
	        
	        pq.add(new Num(arr[i][0], i, 0));
	        
	    }
	        
	   range = max - min;
	   
	   int curr_max = max;
	   int curr_min = min;
	   while(!pq.isEmpty()){
	       
	       
	       Num curr = pq.remove();
	       curr_min = curr.val;
	       
	       
	       if(curr_max - curr_min < range){
	           range = curr_max - curr_min;
	           max = curr_max;
	           min = curr_min;
	       }
	       
	       if(curr.col == n-1){
	           break;
	       }
	       
	       Num new_num = new Num(arr[curr.row][curr.col + 1], curr.row, curr.col + 1);
	       
	       if(new_num.val > curr_max){
	           curr_max = new_num.val;
	           
	       }
	       pq.add(new_num);
	       
	   }
	    
	    int[] ans = {min, max};
	    
	    return ans;
	    
	}
	
}