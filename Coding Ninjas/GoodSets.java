import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int mod = (int)Math.pow(10, 9)+7;
		while(t--!=0){
			int num = 750000;
			int ans[] = new int[num+1];
			int n = s.nextInt();
			int temp;
			for(int i=0;i<n;i++){
				temp = s.nextInt();
				ans[temp]=1;
			}
			for(int i=0;i<=num;i++){
				if(ans[i]>=1){
					for(int j=2*i;j<=num;j+=i){
						if(ans[j]>=1){
							ans[j] = (int)(((long)ans[i] + ans[j])%mod);
						}
					}
				}
			}
			int count=0;
			for(int i=0;i<=750000;i++){
				if(ans[i]>=1) {
					count = (int)(((long)count + ans[i])%mod);
				}
			}
			System.out.println(count);
		}
		
	}

}