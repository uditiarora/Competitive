import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0)
		{
		    int n = sc.nextInt();
		    int k = sc.nextInt();
		    int p = sc.nextInt();
		    
		    int a[] = new int[n];
		    
		    int min = Integer.MAX_VALUE;
		    int minAt = 0;
		    
		    int max = 0;
		    int maxAt = 0;
		    int answer = 0;
		    
		    for(int i=0; i<n; i++)
		    {
		        a[i] = sc.nextInt();
		        if(a[i] < min)
		        {
		            min = a[i];
		            minAt = i;
		        }
		        
		        if(a[i] > max)
		        {
		            max = a[i];
		            maxAt = i;
		        }
		    }
		    
		    if(p == 0)
		    {
		        if(k%2 != 0)
		        {
		            answer = a[maxAt];
		        }
		        else
		        {
		            answer = a[1];
                    answer = Math.max(answer, a[n-2]);
                    for(int i=1; i<n-1; i++)
                    {
                        answer = Math.max(answer, Math.min(a[i-1], a[i+1]));
                    }
		        }
		    }
		    else
		    {
		        if(k%2 != 0)
		        {
		            answer = a[minAt];
		        }
		        else
		        {
		            answer = a[1];
                    answer = Math.min(answer, a[n-2]);
                    for(int i=1; i<n-1; i++)
                    {
                        answer = Math.min(answer, Math.max(a[i-1], a[i+1]));
                    }
		        }
		    }
		    System.out.println(answer);
		    t--;
	    }
	}
}
