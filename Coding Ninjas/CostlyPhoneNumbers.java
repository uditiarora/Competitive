import java.util.*;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int t = s.nextInt();
      while(t--!=0){
        int arr[] = new int[10];
        for(int i=0;i<10;i++){
          arr[i] = s.nextInt();
        }
        int l = s.nextInt();
        String str = s.next();
        
        for(int i=0;i<10;i++){
          for(int j=i+1;j<10;j++){
            arr[(i+j)%10] = Math.min(arr[(i+j)%10],arr[i] + arr[j]);
          }
        }
        int ans = 0;
        for(int i=0;i<l;i++){
          ans += arr[str.charAt(i)-'0'];
        }
        System.out.println(ans);
      }
	}

}