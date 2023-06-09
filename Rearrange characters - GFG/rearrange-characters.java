//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			while (t-- > 0) {
				String str = br.readLine();
				Solution ob= new Solution();
				String str1 = ob. rearrangeCharacters(str);
				
        		int flag=1;
        	    int[] c = new int[26];
        	    Arrays.fill(c,0);
        	    for(int i=0; i<str.length(); i++)
        	        c[str.charAt(i)-'a']+=1;
        	    int f = 0;
        	    int x = (str.length()+1)/2;
        	    for(int i=0; i<26; i++)
        	    {
        	        if(c[i]>x)
        	            f = 1;
        	    }
        	    if(f == 1)
        	    {
        	        if(str1=="-1")
        	            System.out.println(0);
            	    else
            	        System.out.println(1);
        	    }
        	    else
        	    {
            	    int[] a = new int[26];
        	        Arrays.fill(a,0);
            	    int[] b = new int[26];
        	        Arrays.fill(b,0);
            	    for(int i=0; i<str.length(); i++)
            	        a[str.charAt(i)-'a']+=1;
            	    for(int i=0; i<str1.length(); i++)
            	        b[str1.charAt(i)-'a']+=1;
            	        
            	    for(int i=0; i<26; i++)
            	        if(a[i]!=b[i])
            	            flag = 0;
            	    
            	    for(int i=0;i<str1.length();i++)
            	    {
            		    if(i>0)
            		        if(str1.charAt(i-1)==str1.charAt(i))
            			        flag=0;
            	    }
            	    if(flag==1)
            		    System.out.println(1);
            	    else
            	        System.out.println(0);
        	    }
			}
		} catch (Exception e) {

		}
	}
}
// } Driver Code Ends


class Solution
{
	public String rearrangeCharacters(String str) {
	
		//code here
		
		int[] arr = new int[26];
		Arrays.fill(arr, 0);
		int max = 0;
		int idx = 0;
		
		for(int i=0; i<str.length(); i++){
		    arr[str.charAt(i) - 'a']++;
		
		    if(arr[str.charAt(i) - 'a'] > max ){
		        max = arr[str.charAt(i) - 'a'];
		        idx = str.charAt(i) - 'a' ;
		    }
		}
		
		if(str.length()%2 == 0 && max> str.length()/2) return "-1";
		
		else if(str.length()%2 != 0 && max > (str.length()+ 1)/2) return "-1";
		
		char[] ans = new char[str.length()];
				

		int repeat = 0;
		while(arr[idx]-->0){
		    ans[repeat] = (char) (idx + 'a') ;
		    repeat += 2;
		    
		}
		
		for(int i=0; i<26; i++){
		    
		    while(arr[i]-- > 0){
		        
		        if(repeat >= str.length()) repeat = 1;
		        
		        ans[repeat] = (char) (i + 'a');
		    repeat+=2;
		        
		    }
		    
		}
		
// 		System.out.println(ans);
		return String.valueOf(ans);
		
		
		
	}
}