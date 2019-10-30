/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner s = new Scanner(System.in);
		int t;
		t = s.nextInt();
		for(int tc = 0; tc < t; tc++){
		    PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		    int n, m;
		    n=s.nextInt();
		    m=s.nextInt();
		    int arr[] = new int[n+1];
		    for(int i=0;i<n;i++){
		        q.add(0);
		    }
		   
		    boolean flag = false;
		    for(int i=0;i<m;i++){
		        int a = s.nextInt();
		     
		        if(q.peek() == arr[a]){
		        	
		            int x = q.peek();
		            q.poll();
		            q.add(x+1);
		            arr[a]++;
		        }else{
		            flag=true;
		           
		        }
		    }
		    if(flag){
		        System.out.println("NO");
		    }else{
		        System.out.println("YES");
		    }
		    
		}
		
		PriorityQueue<Integer> p = new PriorityQueue<>();
		
	}
}