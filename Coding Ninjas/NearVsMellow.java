import java.util.*;
public class solution {

	public static void main(String[] args) {
		// Write your code here	
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int arr[]=new int[n];
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		if(n<3){
			System.out.println("0");
			return;
		}
		Arrays.sort(arr);
		int temp=arr[n-1];
		int ans=0;
		for(int i=0;i<n-1;i++){
			ans = ans+ arr[n-2]-arr[i];
		}
		System.out.println(ans);
		
	}
}
