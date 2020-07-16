import java.util.*;
class pair implements Comparable<pair>{
  int start,finish;
  public int compareTo(pair temp){
    return this.finish - temp.finish;
  }
}
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      pair[] arr = new pair[n];
      for(int i=0;i<n;i++){
        arr[i] = new pair();
        arr[i].start= s.nextInt();
        arr[i].finish = s.nextInt();
        
      }
      
      Arrays.sort(arr);
      int start = arr[0].start,finish=arr[0].finish, ans=1;
      for(int i=1;i<n;i++){
        if(arr[i].start>finish){
          start = arr[i].start;
          finish = arr[i].finish;
          ans++;
        }
      }
      System.out.println(ans);
	}

}