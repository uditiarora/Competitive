import java.util.Scanner;

public class Main {

	
	public static void main(String[] args) {
		// Write your code here
	Scanner s =new Scanner(System.in);
      int arr[]=new int[1000001];
     	int k=2;
      arr[1]=1;
      for(int i=2;i<=100;i++){
        int temp = i*i*i;
        for(int j=temp;j<=1000000;j=j+temp){
          arr[j]=-1;
        }
      }
      for(int i=2;i<=1000000;i++){
        if(arr[i]!=-1){
          arr[i]=k++;
        }
      }
      int t=s.nextInt();
      int x=1;
      while(t--!=0){
        
        int n = s.nextInt();
        if(arr[n]==-1){
          System.out.println("Case "+x+": Not Cube Free");
        }
        else{
          System.out.println("Case "+x+": "+arr[n]);
        }
        x++;
      }
      
      
	}

}