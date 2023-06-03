//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.segregateElements(a, n);
            
            for(int i=0;i<n;i++)
            System.out.print(a[i]+" ");
            
            System.out.println();
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void segregateElements(int arr[], int n)
    {
        // Your code goes here
        // int j = arr.length - 1;
        // int i = arr.length - 1;
        
        // while(j >= 0){
        //     if(arr[j] > 0){
        //         j--;
        //     }
        //     else{
        //         for(int k = j; k<i; k++){
        //             int temp = arr[k];
        //             arr[k] = arr[k+1];
        //             arr[k+1] = temp;
        //         }
        //         j--;
        //         i--;
        //     }
        // }
        int[] ans = new int[n];
        int i =0;
        for(int j=0; j<n; j++){
            if(arr[j] >=0){
                ans[i] = arr[j];
                i++;
            }
        }
        
        for(int j =0; j<n; j++){
            if(arr[j] <0){
                ans[i] = arr[j];
                i++;
            }
        }
        for(int j=0; j<n; j++){
            arr[j] = ans[j];
        }
                
        
    }
}