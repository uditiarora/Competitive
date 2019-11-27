import java.util.*;
public class Solution {
	public static void util(int a,String ans,int n){
		if(n==1){
			for(int i=a+1;i<=9;i++){
				String temp = ans+ (char)(i+'0');
				System.out.print(temp+" ");
			}
			return;
		}
		for(int i=a+1;i<9;i++){
			String temp = ans + (char)(i+'0');
			util(i,temp,n-1);
		}
		
		
	}

	public static void printIncreasingNumber(int n) {
		/* Your class should be named Solution.
		 * Don't write main() function.
	 	* Don't read input, it is passed as function argument.
	 	* Print output as specified in the question
		*/
		
		util(0,"",n);
				
		
	}
}