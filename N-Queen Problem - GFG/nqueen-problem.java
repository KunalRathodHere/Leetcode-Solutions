//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.nQueen(n);
            if(ans.size() == 0)
                System.out.println("-1");
            else {
                for(int i = 0;i < ans.size();i++){
                    System.out.print("[");
                    for(int j = 0;j < ans.get(i).size();j++)
                        System.out.print(ans.get(i).get(j) + " ");
                    System.out.print("] ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[][] board = new int[n][n];
        for(int[] temp: board) Arrays.fill(temp, 0);
        
        play(0, board, new ArrayList<>(), ans );
        
        return ans;
        
    }
    
    public boolean isPossible(int row, int col, int[][] board){
        
        for(int r =0; r< board.length; r++){
            if(r != row && board[r][col] ==1) return false;
            if(r != col && board[row][r] == 1) return false;
        }
        
        //diagonal 1 
        //where increase both of them
        
        int n = board.length;
        
        int  r1 = row, c1 = col;
        
        while(r1 < n && c1 < n){
            if(board[r1++][c1++] ==1) return false;
            
            
        }
        
        r1 = row; c1 = col;
        while(r1 >= 0 && c1 >= 0)
        {
            if(board[r1--][c1--] == 1) return false;
        }
        
        r1 = row; c1 = col;
        while(r1 < n && c1>= 0){
            if(board[r1++][c1--] == 1) return false;
        }
        
        r1 = row; c1 = col;
        while(r1>=0 && c1< n){
            if(board[r1--][c1++] == 1) return false;
        }
        
        
        return true;
    }
    
    public void play(int row, int[][] board, ArrayList<Integer> cols, 
    ArrayList<ArrayList<Integer>> ans){
        
        if(row == board.length){
            // Collections.reverse(cols);
            ans.add(new ArrayList<>(cols));
            return;
        }
        
        for(int col = 0; col < board.length; col++){
            
            if(isPossible(row, col, board)){
                board[row][col] = 1;
                cols.add(col+1);
                
                play(row + 1, board, cols, ans);
                
                board[row][col] = 0;
                cols.remove(cols.size()-1);
            }
            
        }
        
        return;
        
    }
}