//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        PriorityQueue<Job> pq = new PriorityQueue<>( (a, b) -> b.profit - a.profit );
        
        for(int i=0; i<n; i++){
             
            pq.add(arr[i] );
            
        }
        
        boolean[] time = new boolean[n];
        Arrays.fill(time, false);
        int job_done = 0;
        int profit = 0;
        while(!pq.isEmpty()){
            
            Job curr = pq.remove();
            
            int time_limit = curr.deadline;
            
            while(time_limit>0){
                if(time[time_limit-1] == true) time_limit--;
                else if(time[time_limit-1] == false) {
                    
                    // System.out.println(time_limit + " " + curr.id);
                    time[time_limit-1] = true;
                    job_done += 1;
                    profit+= curr.profit;
                    break;
                }
            }
        }
        
        return new int[]{job_done, profit};
        
        
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/