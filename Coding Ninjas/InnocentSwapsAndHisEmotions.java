import java.util.*;

public class Main {

	static long[] power = new long[1000001];	
  	static long[] fact = new long[1000001];
  static int mod = (int)Math.pow(10,9)+7;
  
  
  public static long pow(long a,long b){
    long ans=1;
    long temp1=a;
    long temp2=b;
    while(temp2!=0){
      if(temp2%2==1){
        ans = (ans*temp1)%mod;
      }
      temp1 = (temp1*temp1)%mod;
      temp2 = temp2/2;
    }
    return ans;
  }
  
	public static void main(String[] args) {
		// Write your code here
      int n=1000000;
      power[0]=1;
      fact[0]=1;
		for(int i=1;i<=n;i++){
          power[i]= (long)(((long)2*power[i-1])%mod);
          fact[i] = (long)(((long)i*fact[i-1])%mod);
        }
      Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      while(t--!=0){
        int a=s.nextInt();
        int b=s.nextInt();
        long temp1 = pow(fact[a-b],mod-2);
        long temp2 = pow(fact[b],mod-2);
        long ans = (((((fact[a] * temp1)%mod) * temp2)%mod) * power[b])%mod;
        System.out.println(ans);
      }
      
      
	}

}