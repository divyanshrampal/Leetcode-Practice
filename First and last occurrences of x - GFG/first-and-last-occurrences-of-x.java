//{ Driver Code Starts
//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class GFG
{
    
    ArrayList<Long> find(long a[], int n, int d)
    {
        int left = 0;
        int right = a.length -1;
        
        int first = -1;
        int last = -1;
        
        while(left <= right)
        {
            int mid = (left+right)/2;
            
            if(d == a[mid])
            {
              first = mid;
              right = mid - 1;
            }
            
            if(d > a[mid])
            {
                left = mid + 1;
            }
            
            else if(d< a[mid])
            {
                right = mid - 1;
            }
            
        }
        
        left = 0;
        right = a.length -1;
        
        while(left <= right)
        {
            int mid = (left+right)/2;
            
            if(d == a[mid])
            {
              last = mid;
              left = mid + 1;
            }
            
            if(d > a[mid])
            {
                left = mid + 1;
            }
            
            else if(d< a[mid])
            {
                right = mid - 1;
            }
            
        }
        
        ArrayList<Long> ans = new ArrayList<>();
        ans.add((long)first);
        ans.add((long)last);
        
        return ans;
    }
}



//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
//            int n = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] q = line.trim().split("\\s+");
            int n =Integer.parseInt(q[0]);
            int x =Integer.parseInt(q[1]);
//            //int y =Integer.parseInt(q[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long arr[] = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Long.parseLong(a1[i]);
            }
            GFG ob = new GFG();
            ArrayList<Long> ans=ob.find(arr,n,x);
            System.out.println(ans.get(0)+" "+ans.get(1));
        }
    }
}

// } Driver Code Ends