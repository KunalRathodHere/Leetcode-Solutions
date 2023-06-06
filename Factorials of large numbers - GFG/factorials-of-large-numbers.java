//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int N = sc.nextInt();
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.factorial(N);
            for (Integer val: ans) 
                System.out.print(val); 
            System.out.println();
        }   
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<Integer> factorial(int N){
        //code here
        
        int[] res = new int[1000000];
        res[0] = 1;
        int res_size = 1;
        for(int i =1; i<=N; i++ ){
            res_size = multiply(res, i, res_size);
        }
        
        // System.out.println(res_size);
        // for(int i=0; i<100; i++){
        //     System.out.println(res[i]);
        // }
        // for(int i=res_size -1; i>=0; i--)
        
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=res_size -1; i>=0; i--){
            ans.add(res[i]);
        }
        
        return ans;
        
    }
    
    public int multiply(int[] res, int x, int res_size){
        
        int carry = 0;
        int val = 0;
        
        for(int i=0; i< res_size; i++){
            
            int curr = res[i] * x + carry;
            carry = curr /10;
            val = curr % 10;
            
            res[i] = val;
            
        }
        
        while(carry != 0){
            
            val = carry %  10;
            carry = carry / 10;
            res[res_size] = val;
            res_size++;
            
        }
        
        return res_size;
        
        
        
        
        
    }
    
}