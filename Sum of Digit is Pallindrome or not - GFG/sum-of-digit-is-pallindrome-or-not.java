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
            System.out.println(ob.isDigitSumPalindrome(N));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    int sum(int n){
        
        int sum = 0;
        while(n != 0){
            sum += n%10;
            n /= 10;
        }
        
        return sum;
    }
    
    boolean check(int n){
        
        int save = n;
        int rev = 0;
        while(n != 0){
            int rem = n % 10;
            rev = rev*10 + rem;
            n = n / 10;
        }
        
        return rev == save;
    }
    
    int isDigitSumPalindrome(int N) {
        
        int digitSum = sum(N);
        boolean isPalindrome = check(digitSum);
        
        return isPalindrome==true?1:0;
    }
}