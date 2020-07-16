import java.util.Scanner;
 
public class Main {
 
	
	public static void main(String[] args) {
 
		Scanner scn = new Scanner(System.in);
		int n=scn.nextInt();
		long m=scn.nextLong();
		long a=scn.nextLong();
		long b=scn.nextLong();
		long v=4_294_967_296L;
		long[] arr = new long[n];
		long x = 0;
		for(int i=0;i<arr.length;i++) {
			x = (((x%m)*a)+b)%v;
			arr[i]=x/256;
		}
		long best = -1, curr=arr[0], ans=0,last=arr[0];
		for(int i=1;i<arr.length;i++) {
			curr=arr[i];
			if(last<curr){
              ans += (curr-last);
            }
          last = curr;
		}
		System.out.println(ans);
	}
 
}