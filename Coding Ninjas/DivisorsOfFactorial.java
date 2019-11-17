import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = 50000;
      boolean arr[] = new boolean[n+1];
      Arrays.fill(arr,true);
      for(int i=2;i*i <=n;i++){
        if(arr[i]==true){
          for(int j = 2*i ;j<=n;j+=i){
            arr[j] = false;
          }
        }
      }
      
      ArrayList<Integer> prime = new ArrayList<Integer>();
      prime.add(2);
      for(int i=3;i<=n;i+=2){
        if(arr[i]) prime.add(i);
      }
      
      int t = s.nextInt();
      int mod = (int)Math.pow(10,9) + 7;
      while(t--!=0){
        int a = s.nextInt();
        int x = prime.size();
        long count = 0,ans=1;
        for(int i=0;i<x && prime.get(i)<=a;i++){
          int k = prime.get(i);
          count = 0;
          while(a/k!=0){
            count = (count + (a/k))%mod;
            k = k * prime.get(i);
          }
          ans = (ans*((count+1)%mod))%mod;
        }
        
        System.out.println(ans%mod);
      }
      
      
	}

}