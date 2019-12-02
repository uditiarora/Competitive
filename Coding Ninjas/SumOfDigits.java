import java.util.*;
import java.io.*;
import java.io.InputStreamReader;
public class Main {
	
	static int sum(int a[],int n)
    {
        
        if (n < 10)
          return (n * (n + 1) / 2);
      
       
        int d = (int)(Math.log10(n));
      
      
        int p = (int)(Math.ceil(Math.pow(10, d)));
      
        
        int msd = n / p;
      
        
        return (msd * a[d] + (msd * (msd - 1) / 2) * p +  
              msd * (1 + n % p) + sum(a,n % p));
    }
	
	
	
	
	public static void main(String[] args){
		int d = 9;
		int dp[] = new int[10];
		dp[0] = 0;
		dp[1] = 45;
		for(int i=2;i<=9;i++){
			dp[i] = dp[i-1] * 10 + 45 * (int)(Math.ceil(Math.pow(10, i-1)));
			
		}
		Scanner s = new Scanner(System.in);
		int a = 0;
		int b = 0;
		while(true){
			a = s.nextInt();
			b = s.nextInt();
			if(a==-1 && b==-1){
				break;
			}
			System.out.println(sum(dp,b)-sum(dp,a-1));
		}
		
      
	}
}

