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
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t--!=0){
			int n = s.nextInt();
			int arr[] = new int[n];
			for(int i=0;i<n;i++){
				arr[i] = s.nextInt();
			}
			boolean flag = false;
			int ans[] = new int[3];
			int j = 0;
			Arrays.sort(arr);
			for(int i = (n-1)-n/4;i>=0;i = i-(n/4)){
				if(arr[i] == arr[i+1]){
					flag = true;
				}
				ans[j++] = arr[i+1]; 
			}
			if(flag == true){
				System.out.println("-1");
				continue;
			}
			else{
				System.out.println(ans[2] + " "+ ans[1]+" "+ ans[0]);
			}
		}
	}
}
