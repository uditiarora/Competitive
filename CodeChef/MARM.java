/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner S=new Scanner(System.in);
		int a,b,t=S.nextInt();
		long n, k;
		while(t-- > 0)
		{
			n=S.nextLong();
			long[] arr=new long[(int)n];
			k=S.nextLong();
			for(int i=0;i<n;i++)
				arr[i]=S.nextLong();
			if(n%2==1 && k>n/2)
				arr[(int)n/2]=0;
			k=k%(3*n);
			for(long i=0;i<k;i++)
			{
				a=(int)(i%n);
				b=(int)(n-(i%n)-1);
				arr[a] = arr[a]^arr[b];
			}
			for(int i=0;i<n;i++)
				System.out.println(arr[i]);
		}
	}
}
