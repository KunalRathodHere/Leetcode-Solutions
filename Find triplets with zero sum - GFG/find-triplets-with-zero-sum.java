//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        
        Arrays.sort(arr);
        
        for(int i=0; i<n; i++){
            boolean ans = find(arr, i, -1 * arr[i]);
            if(ans) {
                
                // System.out.println(arr[i]);
                return true;
            }
        }
        
        return false;
    }
    
    public boolean find(int[] arr, int skip, int target){
        
        int left = 0;
        int right  = arr.length -1;
        
        while(left < right){
            
            if(left == skip ){
                left++;
                continue;
            }
            if(right == skip){
                right--;
                continue;
            }
            
            if(arr[left] + arr[right] == target) {
                // System.out.println(arr[left]+ " here " + arr[right] );
            
                return true;
            }
            
            if(arr[left] + arr[right] < target) left++;
            else if(arr[left] + arr[right] > target) right--;
            
        }
        
        return false;
    }
}