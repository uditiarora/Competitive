import java.util.*;

public class Main {
public static void solve(long l,long b,ArrayList<Integer> prime){
  boolean arr[]=new boolean[(int)(b-l+1)];
  for(int i=0;i<arr.length;i++){
    arr[i]=true;
  }
  for(int i=0;(prime.get(i)*(long)(prime.get(i)))<=b;i++){
   	int temp = prime.get(i);
    long base = (l/temp)*temp;
    if(base<l){
      base=base+temp;
    }
    for(long j=base;j<=b;j=j+temp){
      arr[(int)(j-l)]=false;
    }
    if(base==temp){
      arr[(int)(base-l)]=true;
    }
  }
  
  
  for(int i=0;i<arr.length;i++){
    if(arr[i]==true){
      long temp=i+l;
      System.out.println(temp);
    }
  }
  
}
	
	public static void main(String[] args) {
		// Write your code here
		ArrayList<Integer> prime=new ArrayList<Integer>();
      boolean sieve[]=new boolean[100001];
      for(int i=0;i<100001;i++){
        sieve[i]=true;
      }
      for(int i=2;i*i<100001;i++){
        if(sieve[i]==true){
          for(int j=i*i;j<100001;j=j+i){
            sieve[j]=false;
          }
          
        }
      }
      prime.add(2);
      for(int i=3;i<100001;i=i+2){
        if(sieve[i]==true){
          prime.add(i);
        }
      }
      Scanner s = new Scanner(System.in);
      int t=s.nextInt();
      while(t--!=0){
        long a=s.nextLong();
        long b=s.nextLong();
        solve(a,b,prime);
      }
      
      
	}

}