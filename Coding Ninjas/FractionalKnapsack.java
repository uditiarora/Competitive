import java.util.*;
class work implements Comparable<work>{
  int t,x,y;
  public int compareTo(work temp){
    if(this.t == temp.t){
      if(this.y == temp.y){
        return this.x - temp.x;
      }
      return temp.y - this.y;
    }
    return this.t - temp.t;
  }
}
public class Main {

	
	public static void main(String[] args) {
		// Write your code here
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      long d = s.nextLong();
      work arr[] = new work[n];
      for(int i=0;i<n;i++){
        arr[i] = new work();
        arr[i].t = s.nextInt();
        arr[i].x = s.nextInt();
        arr[i].y = s.nextInt();
        
      }
      Arrays.sort(arr);
      long cost=0,area=0;
      int best=0,last=0;
      for(int i=0;i<n;i++){
        long temp = (long)(best) * (arr[i].t - last);
        area += temp;
        if(area>=d){
          break;
        }
        
        if(best < arr[i].y){
          best = arr[i].y;
          cost += arr[i].x;
        }
        
        last = arr[i].t;
        
      }
      System.out.println(cost);
      
	}

}