
import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int n = Integer.parseInt(br.readLine());
		long arr[] = new long[n];
		long low=Integer.MAX_VALUE;
		long high = Integer.MIN_VALUE;
					st = new StringTokenizer(br.readLine());

		for(int i=0;i<n;i++){
			arr[i]=Long.parseLong(st.nextToken());
			low=Math.min(low, arr[i]);
			high = Math.max(high, arr[i]);
		}
		//Arrays.sort(arr);
		double value=0;
		for(int i=0;i<n;i++){
			value = value + Math.log(arr[i]);
		}
		//long low=arr[0];
		long ans=0;
		//long high = arr[n-1]+1;
		while(low<=high){
			long mid = (low+high)/2;
			double temp = Math.log(mid) * n;
			if(value<temp){
				ans = mid;
				high=mid-1;
			}
			else{
				low=mid+1;
			}
		}
		System.out.println(ans);
	}

}
