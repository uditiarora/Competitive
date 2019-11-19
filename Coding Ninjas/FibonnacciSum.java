import java.util.*;
public class Solution {
  static int mod = (int)Math.pow(10,9)+7;
public static long[][] pow(long m[][],long n){
  long f[][] = new long[][]{{1,1},{1,0}};
  if(n==0 || n==1){
    return f;
  }
  long temp[][] = new long[2][2];
  temp = pow(m,n/2);
  
  temp = multiply(temp,temp);
  if(n%2!=0){
    return multiply(temp,f);
  }
  return temp;
}
public static long[][] multiply(long F[][], long M[][])
{
  long x =  ((F[0][0]*M[0][0])%mod + (F[0][1]*M[1][0])%mod)%mod;
  long y =  ((F[0][0]*M[0][1])%mod + (F[0][1]*M[1][1])%mod)%mod;
  long z =  ((F[1][0]*M[0][0])%mod + (F[1][1]*M[1][0])%mod)%mod;
  long w =  ((F[1][0]*M[0][1])%mod + (F[1][1]*M[1][1])%mod)%mod;
 
  F[0][0] = x;
  F[0][1] = y;
  F[1][0] = z;
  F[1][1] = w;
  return F;
}

	public static long fiboSum(long m, long n) {
		// Write your code here
      long mat[][]=new long[][]{{1,1},{1,0}};
      long ans1[][]=new long[2][2];
      long ans2[][]=new long[2][2];
      
      ans1=pow(mat,m-1);
      ans2=pow(mat,m);
      long sum=0;
      long a = ans1[0][0];
      long b = ans2[0][0];
      for(long i=m;i<=n;i++){
        sum = (sum + a)%mod;
        long c = (a+b)%mod;
        a=b;
        b=c;
      }
      return sum;
      
	}
	
}