import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      Scanner s=new Scanner(System.in);
		int t=s.nextInt();
      while(t--!=0){
        int a=s.nextInt();
        String b=s.next();
        int mod=s.nextInt();
     	int n =b.length();
        long temp=a;
        int ans=1;
        for(int i=n-1;i>=0;i--){
          if(b.charAt(i)=='1'){
            ans = (int)(((long)ans*temp)%mod);
          }
          else if(b.charAt(i)=='2'){
            long temp2=temp*temp;
            ans = (int)(((long)ans*temp2)%mod);
          }
          temp = ((temp%mod)*(temp%mod)*(temp%mod))%mod;
        }
        
     System.out.println(ans);
        
        
      }
	}

}