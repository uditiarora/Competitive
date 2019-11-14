import java.util.*;
public class Solution {

	public static int balancedTreesOfHeightH(int h){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
            if(h==0 || h==1) return 1;

      int mod = (int)Math.pow(10,9) + 7;
	
      int arr[] = new int[h+1];
      arr[0]=arr[1]=1;
      for(int i=2;i<=h;i++){
        
        int x = arr[i-1];
        int y = arr[i-2];
        int temp1 = (int)(((long)x*x)%mod);
        int temp2 = (int)(((long)x*y*2)%mod);
        arr[i] = (int)(((long)temp1 + temp2)%mod);
        //System.out.println(arr[i]);
      }
      return arr[h];
      
	}
}