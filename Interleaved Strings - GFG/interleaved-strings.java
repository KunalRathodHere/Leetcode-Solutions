//{ Driver Code Starts
//initial code
import java.util.*;
import java.lang.*;
class InterLeaveString
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0)
        {
            String a =sc.next();
            String b = sc.next();
            String c = sc.next();
            Solution g=new Solution();
        
            System.out.println(g.isInterLeave(a,b,c)==true?1:0);
            t--;
        }
    }
}


// } Driver Code Ends


/*you are required to complete this method */
class Solution {
	public boolean isInterLeave(String a,String b,String c)
	{
            //Your code here
            
            int[][][] dp = new int[a.length()+1][b.length()+1][c.length()+1];
            
            for(int[][] temp: dp){
                for(int[] temp2 : temp) Arrays.fill(temp2, -1);
            }
            
            
            return fcn(a, b, c, a.length()-1, b.length()-1, c.length()-1, dp);
            
	}
	public boolean fcn(String a, String b, String c, int i, int j, int k, int[][][] dp){
	    
	    if(k < 0 && (i <0 && j<0)) return true;
	    if(k < 0) return false;
	    
	    boolean ans = false;
	   // if( i < 0 && j < 0) return true;
	    
	    if(dp[i+1][j+1][k+1] != -1) return dp[i+1][j+1][k+1] == 0 ? false : true; 
	    
	    char aa= ' ', bb =  ' ', cc = ' ';
	      cc = c.charAt(k);
	    if(i >= 0) aa = a.charAt(i);
	    if(j >= 0) bb = b.charAt(j);
	    
	    if( i >= 0 &&  cc == aa){
	        ans = ans || fcn(a, b, c, i-1, j, k-1, dp);
	        
	    } 
	   if( j >= 0 && cc == bb){
	        ans = ans || fcn(a, b, c, i, j-1, k-1, dp);
	    }
	    
	    if(aa != cc && bb != cc)  {
	        dp[i+1][j+1][k+1] = 0;
	        return false;
	    }
	    
	    dp[i+1][j+1][k+1] = (ans == true) ? 1 : 0;
	    
	    return ans;
	}
	
}

