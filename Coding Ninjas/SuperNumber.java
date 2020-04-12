import java.util.*;

public class Main {
	public static long gcd(long a,long b){
		if(b==0){
			return a;
		}
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t--!=0){
			long a = s.nextLong();
			long b = s.nextLong();
			long d = s.nextLong();
			long low=0;
			long high=Math.max(a,b)*d;
			long temp = (a*b)/gcd(a,b);
			while(low<high){
				long mid = (low+high)/2;
				long temp2 = mid/a + mid/b - mid/temp;
				if(temp2<d){
					low = mid+1;
					
				}
				else{
					high=mid;
				}
			}
			System.out.println(high);

		}
      
      
	}
}