import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++)
		{
			int m = sc.nextInt();
			int d = sc.nextInt();
			boolean flag = false;
			int temp = d;
			
			while(temp>0)
			{
				int dig = temp%10;
				if(dig>=m)
				{
					flag = true;
					break;
				}
				temp /=10;
			}
			
			if(flag)
				arr[i] = Integer.MAX_VALUE;
			
			else
			{
				if(m ==10)
					arr[i] = d;
				
				else
				{
					int sum = 0;
					int index = 0;
					while(d>0)
					{
						sum = sum+(d%10)*(int)(Math.pow(m,index));
						d/=10;
						index++;
					}
					
					arr[i] = sum;
				}
			}
			
		}
		Arrays.sort(arr);
		int i=0;
		long finalsum = 0;
		while(i<arr.length && arr[i]!=Integer.MAX_VALUE)
		{
			int t = arr[i];
			long count=1;
			
			while(i<arr.length-1 && arr[i+1] == arr[i])
			{
				count++;
				i++;
			}
			if(count ==2)
				finalsum+=1;
			else if(count>2)
			{
				long c = (count *(count-1)) / 2;
				finalsum+=c;
			}
			i++;
		}
		System.out.println(finalsum);
    }
}