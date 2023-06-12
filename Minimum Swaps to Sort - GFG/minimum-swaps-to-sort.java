//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        int[] real = new int[n];
        for(int i=0; i<n; i++) real[i] = nums[i];
        
        Arrays.sort(real);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(real[i], i);
        }
        
        int i=0;
        int cnt =0;
        
        while(i < n){
            
            if(real[i] == nums[i]){
                i++;
            } 
            else{
                // System.out.println(i);
            while( real[i] != nums[i]   ){
                
                int num = nums[i];
                //7
                int num_idx = map.get(num);
                //idx
                //swapping
                int temp = nums[num_idx];
                nums[num_idx] = num;
                nums[i] = temp;
                
                cnt++;
                
            }
            }
            
        }
        
        return cnt;
        
    }
}