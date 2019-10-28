/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	 BufferedReader inp = new BufferedReader (new InputStreamReader(System.in));
    int T= Integer.parseInt(inp.readLine());
    for(int z=0 ; z < T ; z++){
        String[] s1 = inp.readLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        long k = Long.parseLong(s1[1]);
        ArrayList<Integer> list = new ArrayList<>();
        String[] s = inp.readLine().split(" ");
        for(String str : s){
            list.add(Integer.parseInt(str));
        }
    
        long count1=0;
        long count2 =0;
        for(int i=0 ; i < n ; i++){
            int r=0;
            int l=0;
            for(int j = i+1 ; j < n ; j++){
                if(list.get(i) > list.get(j)) r++;
            }
            for(int p = 0 ; p <i ; p++){
                if(list.get(i) > list.get(p)){
                    l++;
                }
            }
            count1 += r;
            count2 += 2*r + l;
        }
    
            if(k%2!=0){
                System.out.println(((k*((k-1)/2))*(count2 - count1)) + (count1*k) );
            }else{
                System.out.println((((k-1)*(k/2))*(count2 - count1)) + (count1*k) );
            }
            
            

      }
	}
}
