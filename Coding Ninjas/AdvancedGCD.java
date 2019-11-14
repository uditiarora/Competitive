import java.util.Scanner;

public class Main {
	public static int gcd(int a,int b)
	{
		// Write your code here
      
      if(a<b){
        int temp = a;
        a = b;
        b = temp;
      }
      
      while(b!=0){
        int temp = b;
        b = a%b;
        a = temp;
      }
      return a;
	}		
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t--!=0){
        int a = s.nextInt();
        String b = s.next();
        int n = b.length();
        int x=0;
        if(a==0) {
          System.out.println(b.substring(0));
          a = 10;
          continue;
        }
        for(int i=0;i<n;i++){
          x = (x*10 + b.charAt(i) - '0')%a;
          
        }
        
        System.out.println(gcd(a,x));
      }
      
	}

}