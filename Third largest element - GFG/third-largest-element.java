//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class ThirdLargestElement
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
			int n =sc.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++)
				arr[i] = sc.nextInt();
			Solution g = new Solution();
			System.out.println(g.thirdLargest(arr,n));
		t--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    int thirdLargest(int a[], int n)
    {
        if(n < 3){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
	    for(int i = 0; i < n; i++){
	        if(a[i] >= max){
	            thirdMax = secondMax;
	            secondMax = max;
	            max = a[i];
	        }
	        
	        else if(a[i] >= secondMax){
	            thirdMax = secondMax;
	            secondMax = a[i];
	        }
	        
	        else if(a[i] > thirdMax){
	            thirdMax = a[i];
	        }
	    }
	    
	    return thirdMax;
    }
}
