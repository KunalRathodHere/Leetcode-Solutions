//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
        
        HashMap<Integer, Integer> remainder = new HashMap<>();
        
        int max_len = 0;
        int curr_sum = 0;
        
        for(int i=0; i<n; i++){
            
            curr_sum += a[i];
            
            int curr_remainder = (curr_sum % k  + k) % k;
        
            if(curr_sum %k == 0){
                max_len = Math.max(max_len, i + 1);
            }
            
            if(remainder.containsKey(curr_remainder)){
                max_len = Math.max(max_len, i - remainder.get(curr_remainder)  );
            } else{
                remainder.put(curr_remainder, i);
            }
            
        }
        
        return max_len;
        
       
    }
 
}


//{ Driver Code Starts.

// Driver class
class GFG {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String[] element = line1.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		   
		    int res = obj.longSubarrWthSumDivByK(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		    
		    
		}
	}
}



// } Driver Code Ends