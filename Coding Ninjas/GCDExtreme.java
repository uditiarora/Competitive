import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
      int n=1000000;
      long arr[]=new long[n+1];
      arr[1]=1;
	  for (int i=2; i<=n; i++)
    {
        if (arr[i]==0)
        {
            arr[i] = i-1;
            for (int j = (i<<1); j<=n; j+=i)
            {
                if (arr[j]==0)
                    arr[j] = j;
 
                arr[j] = (arr[j]/i)*(i-1);
            }
        }
    }
      
      long res[]=new long[n+1];
      for(int i=1;i<=n;i++){
        for(int j=2;i*j<=n;j++){
          res[i*j] = res[i*j]+i*arr[j];
        }
      }
      for(int i=2;i<=n;i++){
        res[i]=res[i]+res[i-1];
      }
      Scanner s=new Scanner(System.in);
      while(true){
        
        int a=s.nextInt();
        if(a==0){
          	break;
        }
        System.out.println(res[a]);
      }
      
      
      
	}

}