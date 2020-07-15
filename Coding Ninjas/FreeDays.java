import java.io.*;
import java.util.*;

public class Main {
	static int[] a;
	static int[][] memory;
	public static int min(int a,int b)
	{
		if(a>b)
		{
			return b;
		}
		return a;
	}	
	public static int compute(int ind,int prev)
	{
		if(ind==a.length)
		{
			return 0;
		}
		if(memory[prev][ind]!=-1)
		{
			return memory[prev][ind];
		}
		int ans = 0;
		ans = compute(ind+1,0)+1;
		if((prev==0||prev==2)&&(a[ind]==1||a[ind]==3))
		{
			ans = min(ans,compute(ind+1,1));
		}
		if((prev==0||prev==1)&&(a[ind]==2||a[ind]==3))
		{
			ans = min(ans,compute(ind+1,2));
		}
		return memory[prev][ind] = ans;
	}
	public static void main(String args[]) throws Exception 
		{
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			a = new int[n];
			memory = new int[3][n];
			for(int i=0;i<=2;i++)
			Arrays.fill(memory[i],-1);
			for(int i=0;i<n;i++)
			{
				a[i] = sc.nextInt();
			}
			System.out.println(compute(0,0));
			
		}
	
 
}