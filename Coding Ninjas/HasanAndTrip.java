import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s = new Scanner(System.in);
      int n =s.nextInt();
      int x[]=new int[n];
      int y[]=new int[n];
      int f[]=new int[n];
      double dp[]=new double[n];
      for(int i=0;i<n;i++){
        x[i] = s.nextInt();
        y[i]=s.nextInt();
        f[i]=s.nextInt();
      }
      dp[0]=f[0];
      for(int i=1;i<n;i++){
        dp[i]=Integer.MIN_VALUE;
        for(int j=0;j<i;j++){
          double temp = Math.sqrt((double)(x[i]-x[j])*(x[i]-x[j]) + (double)(y[i]-y[j])*(y[i]-y[j]));
          dp[i] = Math.max(dp[i],dp[j]-temp);
          
        }
        dp[i]=dp[i]+f[i];
        
      }
      System.out.printf("%.6f",dp[n-1]);
      System.out.println();

	}

}