//{ Driver Code Starts
import java.lang.*;
import java.io.*;
import java.util.*;
class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	 
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int t = Integer.parseInt(br.readLine()); 

        while(t-- > 0){
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr= new int[size];
            for(int i = 0;i<size;i++){
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr));
        }
	 }
	 
}

// } Driver Code Ends


class Solution{
    static int minJumps(int[] arr){
        // your code here
        int n = arr.length;
        // int max_steps_possible = arr[0];
        // int max_distance_reached = arr[0];
        // int dist_from_last_jump = arr[0];
        // int jumps = 1;
        // int n= arr.length;
        
        // for(int i=1; i<n; i++){
            
        //     if(i == n-1) return jumps;
            
        //     max_distance_reached = Math.max(max_distance_reached, arr[i]  + i);
        //     max_steps_possible--;
        //     if(max_steps_possible == 0){
        //         jumps++;
                
        //         if(i >= max_distance_reached) return -1;
        //         max_steps_possible = max_distance_reached - i;
                
        //     }
        // }
            
        // return -1;    
            if (n <= 1) // If there is only one element or the array
                // is empty, we have reached the end of the
                // array with 0 jumps
        return 0;
    if (arr[0] == 0) // If the first element is 0, we can't
                     // move forward
        return -1;
 
    int maxReach
        = arr[0]; // Stores the maximum index that can be
                  // reached with the current jump
    int steps
        = arr[0]; // Stores the number of steps that can be
                  // taken from the current index
    int jumps
        = 1; // Stores the number of jumps taken so far
 
    for (int i = 1; i < n; i++) {
        if (i == n - 1) // If we have reached the end of the
                        // array, return the number of jumps
                        // taken so far
            return jumps;
        maxReach
            = Math.max(maxReach,
                  i + arr[i]); // Update the maximum index
                               // that can be reached with
                               // the current jump
        steps--; // Decrement the number of steps that can
                 // be taken from the current index
        if (steps == 0) { // If no more steps can be taken
                          // from the current index, we need
                          // to take another jump
            jumps++; // Increment the number of jumps taken
                     // so far
            if (i >= maxReach) // If the current index is
                               // greater than the maximum
                               // index that can be reached,
                               // return -1
                return -1;
            steps = maxReach - i; // Update the number of
                                  // steps that can be taken
                                  // from the current index
        }
    }
    return -1; // If we haven't reached the end of the

    }
}