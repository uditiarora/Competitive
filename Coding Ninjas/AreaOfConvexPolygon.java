import java.util.*;

import java.io.*;
class Point{
	double x,y;
}
class Polygon{
	Point points[];
	public Polygon(int n){
		points = new Point[n];
	}
}
public class Main {
	public static double area(Polygon p,int n){
		double ans=0;
		for(int i=1;i<n-1;i++){
			double x1 = p.points[i].x - p.points[0].x;
			double y1 = p.points[i].y - p.points[0].y;
			double x2 = p.points[i+1].x - p.points[0].x;
			double y2 = p.points[i+1].y - p.points[0].y;
			double cross = x1 * y2 - x2 * y1;
			ans += cross;
			
		}
		return ans/2;
	}
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
      int n = s.nextInt();
      Polygon p = new Polygon(n);
      for(int i=0;i<n;i++){
    	  p.points[i] = new Point();
    	  p.points[i].x = s.nextInt();
      }
      for(int i=0;i<n;i++){
    	  p.points[i].y = s.nextInt();
      }
      System.out.println(Math.abs(area(p,n)));
      
      
	}

}