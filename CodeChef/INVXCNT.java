/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    	public static void util(int bit, ArrayList<Integer> arr, int[][] inv){
		if(arr.size()==0 || bit<0){
			return;
		}
		int n = arr.size();
		int zero_inv = 0, one_inv = 0;
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> zero = new ArrayList<Integer>();
		
		for(int i=0;i<n;i++){
			if((arr.get(i) & (1<<bit)) == 1){
				one.add(arr.get(i));
				one_inv++;
				inv[bit][1] += zero_inv;
			}
			else{
				zero.add(arr.get(i));
				zero_inv++;
				inv[bit][0] += one_inv;
			}
			
		}
		util(bit-1,one,inv);
		util(bit-1,zero,inv);
	}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t--!=0){
			int n = s.nextInt();
			int q = s.nextInt();
			int inv[][] = new int[50][2];
			ArrayList<Integer> arr = new ArrayList<Integer>();
			int temp;
			for(int i=0;i<n;i++){
				temp = s.nextInt();
				arr.add(temp);
			}
			util(30,arr,inv);
			
			for(int i=0;i<q;i++){
				int k = s.nextInt();
				int ans= 0;
				for(int j=0;j<31;j++){
					if((k & (1<<j))==1){
						ans += inv[j][1];
					}
					else{
						ans += inv[j][0];
					}
				}
				System.out.println(ans);
			}
		}
	}
}
