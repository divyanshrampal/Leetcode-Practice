//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.is_AutomorphicNumber(n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String is_AutomorphicNumber(int n)
    {
        int square = n*n;
        
        while(n != 0){
            int rem1 = n % 10;
            int rem2 = square % 10;
            if(rem1 != rem2){
                return "Not Automorphic";
            }
            
            n /= 10;
            square /= 10;
        }
        
        
        return "Automorphic";
        
        
    }
}