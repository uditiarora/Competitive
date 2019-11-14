import java.util.Scanner;
class temp{
  int x,y,gcd;
}
public class Main {
	
  public static temp gcd2(int a,int b){
      if(b==0){
      temp temp1 =new temp();
      temp1.x=1;
      temp1.y=0;
      temp1.gcd=a;
      return temp1;
    }
    
    temp temp1 = gcd2(b,a%b);
    temp ans =new temp();
    ans.x = temp1.y;
    ans.y = (temp1.x - (a/b)*temp1.y);
    ans.gcd=temp1.gcd;
    return ans;
  }
  
	public static int gcdF(int a,int b){
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
        int b = s.nextInt();
        int d = s.nextInt();
        int tmp = gcdF(a,b);
        if(d%tmp != 0){
          System.out.println("0");
          continue;
        }
		if(d==0){
          System.out.println("1");
          continue;
        }
       	a = a/tmp;
        b = b/tmp;
        d = d/tmp;
        int g = gcd2(b,a).y;
        long mod = (g%a + a)%a;
        long tmp2 = ((d%a)*mod)%a;
        if(d < tmp2*b){
          System.out.println("0");
          continue;
        }
        
        long n = (d/b - tmp2)/a;
        System.out.println(n+1);
        
      }
      
      
	}

}