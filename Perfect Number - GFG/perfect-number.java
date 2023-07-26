//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.isPerfect(N));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    
    
    int isPerfect(int N) {
        
        int[] dp = new int[10];
        dp[0] = 1;
        
        for(int i = 1; i < 10; i++){
            dp[i] = i*dp[i-1];
        }
        
        
        int temp = N;
        int sum = 0;
        
        while(temp != 0){
            int rem = temp % 10;
            sum += dp[rem];
            temp /= 10; 
        }
        
        return sum == N? 1:0;
    }
}



