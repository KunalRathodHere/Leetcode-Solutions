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
        ArrayList<Job> jobs = new ArrayList<>();
        
        for(int i =0; i< arr.length; i++){
            jobs.add(new Job(i+1, arr[i].deadline, arr[i].profit));
        }
        
        
        Collections.sort(jobs, (a,b) -> b.profit - a.profit);
        
        // for(int i =0; i<jobs.size(); i++) System.out.println(jobs.get(i).profit);
        
        boolean results[] =  new boolean[n];
        int job[] = new int[n];
        int ans[] = new int[2];
        
        for(int i =0; i<n; i++){
            int j = Math.min(n-1, jobs.get(i).deadline -1);
            
            for(; j>=0; j--){
                if(results[j] == false){
                    results[j] = true;
                    job[j] = jobs.get(i).id;
                    
                    ans[0] ++;
                    ans[1] += jobs.get(i).profit;
                    break;
                }
            }
        }
        
        
        
        return ans;
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