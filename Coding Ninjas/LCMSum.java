public class Solution {

static double arr[]=new double[1000001];
	public static void func(long n)
	{

		// Write your code here
      for(int i=0;i<=n;i++){
        arr[i]=i;
      }
      
      for(int i=2;i<=n;i++){
        if(arr[i]==i){
          for(int j=2*i;j<=n;j=j+i){
            arr[j] = arr[j]*(1 - 1.0/arr[i]);
          }
          arr[i]=i-1;
        }
      }
      long ans=0;
      for(int i=1;i<=n;i++){
        if(n%i==0){
          ans =(long)(ans + i*arr[i]);
        }
      }
      ans = ans+1;
      ans = ans*n/2;
      System.out.println(ans);
	}
		
}
