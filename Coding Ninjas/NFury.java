import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      int arr[] = new int[1001];
      arr[1]=1;
      for(int i=2;i<=1000;i++){
        arr[i]=Integer.MAX_VALUE;
        for(int j=1;j*j<=i;j++){
          arr[i] = Math.min(arr[i],1+arr[i-j*j]);
        }
      }
      Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      while(t--!=0){
        int a = s.nextInt();
        System.out.println(arr[a]);
      }
      

	}

}