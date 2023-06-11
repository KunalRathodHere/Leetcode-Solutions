//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int[] S = IntArray.input(br, N);
            
            
            int[] F = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.maxMeetings(N, S, F);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class mycomparator implements Comparator<meeting> {
    @Override public int compare(meeting o1, meeting o2)
    {
        if (o1.end < o2.end) {
 
            // Return -1 if second object is
            // bigger than first
            return -1;
        }
        else if (o1.end > o2.end)
 
            // Return 1 if second object is
            // smaller than first
            return 1;
 
        return 0;
    }
}

class meeting{
    
    int start;
    int end;
    int pos;
    
    meeting(int s, int e, int p){
        start = s;
        end = e;
        pos = p;
    }
    
}

class Solution {
    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        // code here
    
        List<meeting> arr = new ArrayList<>();
        
        for(int i=0; i<N; i++){
            arr.add(new meeting(S[i], F[i],i+1));
        }
        
        Collections.sort(arr, new mycomparator());
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        ans.add(arr.get(0).pos);
        
        int end_time = arr.get(0).end;
        
        for(int i= 1; i<arr.size(); i++){
            
            if(arr.get(i).start > end_time){
                ans.add(arr.get(i).pos);
                end_time = arr.get(i).end;
            }
            
        }
        
        Collections.sort(ans);
        
        return ans;
        
        
    }
}
        
