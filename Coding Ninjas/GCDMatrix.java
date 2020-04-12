import java.util.*;
import java.io.*;
public class Main {

	static int a[] = new int[100005];
 static  int b[] = new int[100005];
	public static void main(String[] args) throws IOException{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n = Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int q = Integer.parseInt(st.nextToken());
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<n;i++){
        a[i] = Integer.parseInt(st.nextToken());
      }
      st = new StringTokenizer(br.readLine());
      for(int i=0;i<m;i++){
        b[i] = Integer.parseInt(st.nextToken());
      }
 		for(int k=0;k<q;k++){
          //
 			//int arr[] = new int[100005];
          int m1[] = new int[100005];
          int m2[] = new int[100005];
          int count[] = new int[100005];
          int r1,c1,r2,c2;
          st = new StringTokenizer(br.readLine());
          r1 = Integer.parseInt(st.nextToken());
          c1 = Integer.parseInt(st.nextToken());
          r2 = Integer.parseInt(st.nextToken());
          c2 = Integer.parseInt(st.nextToken());
          for(int i=r1;i<=r2;i++){
            count[a[i]]++;
          }
          
          for(int i=1;i<=100000;i++){
            for(int j=i;j<=100000;j=j+i){
              m1[i] += count[j];
            }
          }
          int count2[] = new int[100005];
          for(int i=c1;i<=c2;i++){
            count2[b[i]]++;
          }
          for(int i=1;i<=100000;i++){
            for(int j=i;j<=100000;j=j+i){
              m2[i] += count2[j];
            }
          }
          
          long ans[] = new long[100005];
          for(int i=100000;i>=1;i--){
            ans[i] = (long)m1[i]*m2[i];
            for(int j=2*i;j<=100000;j=j+i){
              ans[i] -= ans[j];
              
            }
          }
          int res=0;
          for(int i=1;i<=100000;i++){
            if(ans[i]>0){
              res++;
            }
          }
          System.out.println(res);
        }     
	}

}