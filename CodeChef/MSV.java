/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t= Integer.parseInt(br.readLine());
		while(t-- >0){
		    int n = Integer.parseInt(br.readLine());
		    String [] in= br.readLine().split(" ");
		    int [] arr= new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]= Integer.parseInt(in[i]);
		        
		    }
		    
		    int max =0;
		    int [] c= new int[1000000];
		    for(int i=0; i<n; i++){
		         max= Math.max(c[arr[i]], max);
		         for(int j=1; j<= (int)Math.sqrt(arr[i]); j++){
		             if(arr[i]%j==0){
		                 c[j]++;
		                 if(arr[i]/j != j){ 
		                    c[arr[i]/j]++;
		                 }
		             }
		         }
		    }
		    System.out.println(max);
		}
	}
}
