import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int prime[] = new int[1000001];
      int n = 1000000;
      
      for(int i=2;i <= n+1;i++){
        if(prime[i]==0){
          prime[i]=1;
          for(int j = i*2;j<=n;j+=i){
            prime[j]++;
          }
        }
      }
      
      
      int t = s.nextInt();
      while(t--!=0){
        int a = s.nextInt();
        int b = s.nextInt();
        int k = s.nextInt();
       int count=0;
       for(int i=a;i<=b;i++){
         if(prime[i] == k){
           count++;
         }
       }
        
        System.out.println(count);
      }
      
      
	}

}