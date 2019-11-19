import java.util.Scanner;

public class Main {

	  static int mod = (int)Math.pow(10,9)+7;
  static int mod2=mod-1;
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
  long x =  ((F[0][0]*M[0][0])%mod2 + (F[0][1]*M[1][0])%mod2)%mod2;
  long y =  ((F[0][0]*M[0][1])%mod2 + (F[0][1]*M[1][1])%mod2)%mod2;
  long z =  ((F[1][0]*M[0][0])%mod2 + (F[1][1]*M[1][0])%mod2)%mod2;
  long w =  ((F[1][0]*M[0][1])%mod2 + (F[1][1]*M[1][1])%mod2)%mod2;
 
  F[0][0] = x;
  F[0][1] = y;
  F[1][0] = z;
  F[1][1] = w;
  return F;
}
public static int expo(int a,long b){
  long temp=a;
  long temp2 = b;
  int ans =1;
  if(a==0){
    return 0;
  }
  if(b==0){
    return 1;
  }
  while(temp2!=0){
    if(temp2%2==1){
      ans = (int)(((long)ans*temp)%mod);
    }
    temp = ((temp) * (temp))%mod;
    temp2 = temp2/2;
  }
  return ans;
}
	public static void main(String[] args) {
		// Write your code here
	
      Scanner s=new Scanner(System.in);
      long m[][]=new long[][]{{1,1},{1,0}};
      int t=s.nextInt();
      while(t--!=0){
        int a=s.nextInt();
        int b=s.nextInt();
        int n=s.nextInt();
        if(n==0){
          System.out.println(a);
          continue;
        }
        if(n==1){
          System.out.println(b);
          continue;
        }
        long ans1[][]=new long[2][2];
        long ans2[][]=new long[2][2];
        ans1=pow(m,n-2);
        ans2=pow(m,n-1);
        long fn1=ans1[0][0];
        long fn2=ans2[0][0];
        //System.out.println(fn1+" "+fn2);
        int temp1 = expo(a+1,fn1);
        int temp2 = expo(b+1,fn2);
        //System.out.println(temp1+" "+temp2);
        int ans = (int)(((long)(temp1) * (temp2))%mod);
        
        if(ans<0){
        	ans =ans+mod;  
        }
        ans = ans-1;
        
        
        System.out.println(ans);
      }
      
      
      
      
	}

}