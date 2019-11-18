import java.util.*;

public class Main {

   
	static int sieve[]=new int[2000001];
  	static boolean mark[]=new boolean[2000001];
  
  
  public static void util(int a){
    int temp=a;
    int lpd=sieve[a];
    mark[a]=true;
    ArrayList<Integer> ans=new ArrayList<>();
    ans.add(a);
    while(temp>1 && lpd>1){
      for(int i=a;i>1;i=i-lpd){
        if(mark[i]==false){
        	ans.add(i);
          mark[i]=true;
        }
      }
      while(temp%lpd==0){
        temp = temp/lpd;
      }
      
      lpd = sieve[temp];
      
    }
    Collections.sort(ans,Collections.reverseOrder());
    for(int i=0;i<ans.size();i++){
      System.out.print(ans.get(i)+" ");
    }
    
  }
  
  
  
	public static void main(String[] args) {
		// Write your code here
      for(int i=0;i<2000001;i++){
        sieve[i]=i;
      }
		for(int i=2;i<2000001;i++){
          if(sieve[i]==i){
            for(int j=i;j<2000001;j=j+i){
              sieve[j]=i;
            }
          }
        }
      
      Scanner s=new Scanner(System.in);
      int n =s.nextInt();
      for(int i=n;i>1;i--){
        if(mark[i]==false){
          util(i);
        }
      }
      System.out.print("1");
      
      
      
	}

}