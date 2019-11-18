import java.util.*;
public class Solution {

  	public static int[][] pow(int[][] m,int n){
      int f[][] = new int[][]{{1,1},{1,0}};
      if(n==1 || n==0){
        return f;
      }
      int[][] temp = new int[2][2];
        temp = pow(m,n/2);
      temp = multiply(temp,temp);
      if(n%2==1){
        temp = multiply(temp,f);
      }
      return temp;
    }
  
	public static int factorial(int n){
      int m[][] = new int[][]{{1,1},{1,0}};
      m = pow(m,n-1);
      return m[0][0];
    }
  
  public static int[][] multiply(int F[][], int M[][])
{
  int x =  F[0][0]*M[0][0] + F[0][1]*M[1][0];
  int y =  F[0][0]*M[0][1] + F[0][1]*M[1][1];
  int z =  F[1][0]*M[0][0] + F[1][1]*M[1][0];
  int w =  F[1][0]*M[0][1] + F[1][1]*M[1][1];
 
  F[0][0] = x;
  F[0][1] = y;
  F[1][0] = z;
  F[1][1] = w;
  return F;
}

	public static void main(String[] args) {
		
		/* Your class should be named Solution.
	 	* Read input as specified in the question.
	 	* Print output as specified in the question.
		*/
		Scanner s = new Scanner(System.in);
     
        int n = s.nextInt();
        System.out.println(factorial(n));
      
		
	}

}
