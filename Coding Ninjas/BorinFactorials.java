import java.util.*;

public class Main {

	public static int pow(int a,int b){
      int ans=1;
      int x=b+2;
      while(b!=0){
        if(b%2 == 1){
          ans = (ans*a)%x;
        }
        a = (a*a)%x;
        b=b/2;
      }
      return ans;
    }
	public static void main(String[] args) {
		// Write your code here
			Scanner s =new Scanner(System.in);
      int t=s.nextInt();
      while(t--!=0){
      int a=s.nextInt();
      	int b=s.nextInt();
        if(a>=b){
          System.out.println("0");
          continue;
        }
      	int ans=-1;
        for(int i=a+1;i<b;i++){
          ans= (ans * pow(i,b-2))%b;
        }
      ans = ans+b;
              System.out.println(ans);

      }
	}

}