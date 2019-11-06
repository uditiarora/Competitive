
public class Solution {
	
		
     public static int staircase(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */	
       if(n==1 || n==0){
         return 1;
       }
       if(n<0){
         return 0;
       }
       int count=0;
       for(int i=1;i<=3 && i<=n;i++){
         count=count + staircase(n-i);
       }
	return count;
	}
	
}