//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends


class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public  int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        PriorityQueue<Job> pq = new PriorityQueue<>( (a,b) -> a.end - b.end );
        
        for(int i=0; i<n; i++){
            pq.add(new Job(start[i], end[i]));
        }
        
        int prev_start = pq.peek().start;
        int prev_end = pq.peek().end;
        
        int job_done =1;
        
        pq.remove();
        
        while(!pq.isEmpty()){
            Job curr = pq.remove();
            
            if(curr.start > prev_end){
                job_done++;
                prev_start = curr.start;
                prev_end = curr.end;
            }
        }
        return job_done;
        
        
    }
    
    
}

class Job{
    
    int start;
    int end;
    Job(int s, int e){
        start =s;
        end = e;
    }
    
}