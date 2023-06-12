//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        Solution obj = new Solution();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String A = read.readLine().trim();
            
            String ans = obj.chooseandswap(A);
            System.out.println(ans);
        }
    }
}


// } Driver Code Ends


//User function Template for Java



class Solution{
    
    
    String chooseandswap(String A){
        // Code Here
    //     int n = A.length();
    //     char[] str = A.toCharArray();
        
    //         int i, j = 0;
       
    // // To store the first index of
    // // every character of str
    // int []chk = new int[26];
    // for (i = 0; i < 26; i++)
    //     chk[i] = -1;
   
    // // Store the first occurring
    // // index every character
    // for (i = 0; i < n; i++)
    // {
   
    //     // If current character is appearing
    //     // for the first time in str
    //     if (chk[str[i] - 'a'] == -1)
    //         chk[str[i] - 'a'] = i;
    // }
   
    // // Starting from the leftmost character
    // for (i = 0; i < n; i++)
    // {
    //     boolean flag = false;
   
    //     // For every character smaller than str[i]
    //     for (j = 0; j < str[i] - 'a'; j++)
    //     {
   
    //         // If there is a character in str which is
    //         // smaller than str[i] and appears after it
    //         if (chk[j] > chk[str[i] - 'a'])
    //         {
    //             flag = true;
    //             break;
    //         }
    //     }
   
    //     // If the required character pair is found
    //     if (flag)
    //         break;
    // }
    
    // // System.out.println(i + " " + j);
    // // If swapping is possible
    // if (i < n-1)
    // {
   
    //     // Characters to be swapped
    //     char ch1 = str[i];
    //     char ch2 = (char) (j + 'a');
   
    //     // For every character
    //     for (i = 0; i < n; i++)
    //     {
   
    //         // Replace every ch1 with ch2
    //         // and every ch2 with ch1
    //         if (str[i] == ch1)
    //             str[i] = ch2;
   
    //         else if (str[i] == ch2)
    //             str[i] = ch1;
    //     }
    // }
   
    // return String.valueOf(str);

        int[] first_appear = new int[26];
        
        Arrays.fill(first_appear, -1);
        
        for(int i=0; i<A.length(); i++){
            if(first_appear[A.charAt(i) - 'a'] == -1)
                first_appear[A.charAt(i) - 'a' ] = i;
            
        }
        
        boolean found = false;
        int i =0, j = 0;
        for( i=0; i<A.length() ; i++){
            
            
            for( j=0; j<A.charAt(i) - 'a'; j++){
                int end = A.charAt(i) - 'a';
                // System.out.println("end == " + end);
                // System.out.println("A.charAt(i) - 'a' " + A.charAt(i) );
                // System.out.println(j + " " + end);
                if(first_appear[j] > first_appear[end]){
                    found = true;
                    
                    break;
                }
                
            }
            
            if(found) break;
            
        }
        
        char[] str = A.toCharArray();
        // System.
        
        // System.out.println(i + " " + j);
        
        if(i < str.length ){
        char two = (char) (j + 'a') ; 
        char one = str[i];
        // System.out.println(two + " " + one);
        
        for(int k=0; k<str.length; k++){
            
            if(str[k] == one) str[k] = two;
            else if(str[k] == two) str[k] = one;
        }
        }
        return String.valueOf(str);
        
    }
    
}