//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        
        PriorityQueue<Stock> pq = new PriorityQueue<>( (a, b) -> a.price - b.price );
        
        for(int i=0; i<n; i++){
            pq.add(new Stock(price[i], i+1));    
        }
        
        
        int ans =0;
        while(!pq.isEmpty() && k>0){
            
            Stock curr = pq.remove();
            
            if(curr.price * curr.num <= k){
                ans += curr.num;
                k -= curr.price * curr.num;
            }
            else{
                int max_buy = k / curr.price;
                ans += max_buy;
                
                k-= curr.price * max_buy;
                
            }
        }
        
        return ans;
        
    }
}
        
class Stock{
    
    int price;
    int num;
    
    Stock(int p, int n){
        price = p;
        num = n;
    }
    
}