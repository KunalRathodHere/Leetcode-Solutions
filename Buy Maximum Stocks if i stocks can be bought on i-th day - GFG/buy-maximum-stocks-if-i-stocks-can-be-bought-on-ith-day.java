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


class pair{
    int p;
    int day;
    
    pair(int pp, int dd){
        p = pp;
        day = dd;
    }
}


class sortpair implements Comparator<pair>{
    public int compare(pair a, pair b){
        return a.p - b.p;
    }
}

class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        
        ArrayList<pair> list= new ArrayList<>();
        
        for(int i =0; i<n; i++){
            list.add(new pair(price[i], i+1));
        }
        
        Collections.sort(list, new sortpair());
        
        int ans =0;
        
        for(int i =0; i<list.size(); i++){
            
            int stocks = Math.min(list.get(i).day, k/ list.get(i).p);
            ans += stocks;
            
            k -= stocks * list.get(i).p;
            
        }
        
        return ans;
    }
}
        
