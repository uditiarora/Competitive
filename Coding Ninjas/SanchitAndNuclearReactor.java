import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
			Scanner s=new Scanner(System.in);
      	int n = s.nextInt();
      while(n--!=0){
        long t=s.nextLong();
        long m=s.nextLong();
        long k =(long)(t/m);
        long ans=1;
        if(k%2==1){
          ans=m-1;
        }
        else{
          ans=1;
        }
        t=t%m;
        for(int i=1;i<=t;i++){
          ans = (ans*i)%m;
        }
        System.out.println(ans);
      }
	}

}