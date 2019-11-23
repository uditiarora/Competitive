import java.util.Scanner;

public class Main {

	public static int get(int a[]){
       int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
 
        for (int i = 0; i < size; i++)
        {
            max_ending_here = max_ending_here + a[i];
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }
	public static void main(String[] args) {
		// Write your code here
		
      Scanner s = new Scanner(System.in);
      int m =s.nextInt();
      int n=s.nextInt();
      int arr[][]=new int[m][n];
      int dp[] = new int[m];
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
          arr[i][j]=s.nextInt();
        }
      }
      int max = Integer.MIN_VALUE;
      for(int l=0;l<n-1;l++){
        for(int i=0;i<m;i++){
          dp[i]=arr[i][l];
        }
        for(int r=l+1;r<n;r++){
          int temp = get(dp);
          if(temp>max){
            max=temp;
          }
          for(int j=0;j<m;j++){
            dp[j] = dp[j] + arr[j][r];
          }
        }
      }
      
      System.out.println(max);
      
	}

}