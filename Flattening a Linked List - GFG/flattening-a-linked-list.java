//{ Driver Code Starts
import java.util.Scanner;
import java.util.*;
import java.io.*;

class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}


class Flatttening_A_LinkedList
{	
    Node head;
	
	void printList(Node node)
    {
        //Node temp = head;
        while (node != null)
        {
            System.out.print(node.data + " ");
            node =node.bottom;
        }
        System.out.println();
    }
	public  static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		Flatttening_A_LinkedList list = new Flatttening_A_LinkedList();
		while(t>0)
		{
			int N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0;i<N;i++)
				arr[i] = sc.nextInt();
			
			Node temp = null;
			Node tempB = null;
			Node pre = null;
			Node preB = null;	
			int flag=1;
			int flag1=1;
			for(int i=0; i<N;i++)
			{
				int m = arr[i];
				m--;
				int a1 = sc.nextInt();
				temp = new Node(a1);
				if(flag == 1)
				{
					list.head = temp;
					pre = temp;
					flag = 0;
					flag1 = 1;
				}
				else
				{
					pre.next = temp;
					pre = temp;
					flag1 = 1;
				}
				
				for(int j=0;j<m;j++)
				{
					int a = sc.nextInt();
					tempB = new Node(a);
					if(flag1 == 1)
					{
						temp.bottom = tempB;
						preB = tempB;
						flag1 = 0;
					}
					else
					{
						preB.bottom = tempB;
						preB = tempB;
					}
				}
				
			}
			//list.printList();
			GfG g = new GfG();
			Node root = g.flatten(list.head);
			list.printList(root);
		
		t--;
		}
	}	
}
// } Driver Code Ends


/*Node class  used in the program
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
*/
/*  Function which returns the  root of 
    the flattened linked list. */
class GfG
{
    
    Node merge(Node first, Node second){
        // if only one element is present in 1st list
        if(first.bottom == null){
            first.bottom = second;
            return first;
        }
        
        Node curr1 = first;
        Node next1 = first.bottom;
        Node curr2 = second;
        
        while(next1 != null && curr2 != null){
             if(curr2.data >= curr1.data && curr2.data <= next1.data){
                 
                 curr1.bottom = curr2;
                 Node next2 = curr2.bottom;
                 curr2.bottom = next1;
                 curr1 = curr2 ;
                 curr2 = next2;
                  
             }
            else{
                curr1 = next1;
                next1 = next1.bottom;
                
                if(next1 == null){
                    curr1.bottom = curr2;
                    return first;
                }
            }
        }
        
        return first;
        
    }
    
    Node mergeTwoLists(Node list1, Node list2) {
        if(list1 == null){
            return list2;
        }
        
        if(list2 == null){
            return list1;
        }
        
        if(list1.data <= list2.data){
            return merge(list1, list2);
        }
        
        else{
            return merge(list2, list1);
        }
        
    }
    
    
    Node flatten(Node root)
    {
        if(root == null || root.next == null){
            return root;
        }

        return mergeTwoLists(root, flatten(root.next));
        
    }
}