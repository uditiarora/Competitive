import java.util.*;
public class solution {
static int mod = (int)Math.pow(10, 9)+7;
	public  long solve(int n){
		long dp1[] = new long[n+1];
		long dp2[]= new long[n+1];
		dp1[1]=1;
		for(int i=2;i<=n;i++){
			dp1[i] = ((2*dp1[i-1])%mod + dp2[i-1])%mod;
			dp2[i] = (3*dp1[i-1])%mod;
		}
		return dp2[n];
	}
	
}
