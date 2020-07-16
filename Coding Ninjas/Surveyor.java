import java.util.*;

import java.io.*;
class Point{
	int x,y;
}
class Polygon{
	Point points[];
	public Polygon(int n){
		points = new Point[n];
	}
}
public class Main {
	public static int area(Polygon p,int n){
		int ans=0;
		for(int i=1;i<n-1;i++){
			int x1 = p.points[i].x - p.points[0].x;
			int y1 = p.points[i].y - p.points[0].y;
			int x2 = p.points[i+1].x - p.points[0].x;
			int y2 = p.points[i+1].y - p.points[0].y;
			int cross = x1 * y2 - x2 * y1;
			ans += cross;
			
		}
		return ans/2;
	}
	public static void main(String[] args) throws IOException{
		// Write your code here
		Scanner s = new Scanner(System.in);
		String str = s.next();
		int n = str.length();
		Polygon p = new Polygon(n);
		p.points[0] = new Point();
		int ans=0;
		for(int i=1;i<n;i++){
			p.points[i] = new Point();
			char temp = str.charAt(i-1);
			int inp = s.nextInt();
			if(temp == 'E'){
				p.points[i].x = p.points[i-1].x + inp;
				p.points[i].y = p.points[i-1].y;
				
			}
			else if(temp == 'W'){
				p.points[i].x =  p.points[i-1].x - inp;
				p.points[i].y = p.points[i-1].y;
				
			}
			else if(temp == 'N'){
				p.points[i].x = p.points[i-1].x;
				p.points[i].y = p.points[i-1].y + inp;
				
			}
			else if(temp == 'S'){
				p.points[i].x = p.points[i-1].x;
				p.points[i].y = p.points[i-1].y - inp;
				
			}
			//ans += (p.points[i].x - p.points[i-1].x) * p.points[i-1].y;
		}
		System.out.println(Math.abs(area(p,n)));
	}

}