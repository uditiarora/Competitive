
public class Solution {
	
	
	
	public static int longestBitonicSubarray(int[] arr){

	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Return output and don't print it.
	 * Taking input and printing output is handled automatically.
	 */
      int n=arr.length;
      int lis[]=new int[n];
      int lds[]=new int[n];
      for(int i=0;i<n;i++){
        lis[i]= lds[i]=1;
        
      }
      for(int i=1;i<n;i++){
        for(int j=0;j<i;j++){
          if(arr[j]<arr[i] && lis[i]<lis[j]+1){
            lis[i] = lis[j]+1;
          }
        }
      }
      for (int i = n-2; i >= 0; i--){
            for (int j = n-1; j > i; j--){
                if (arr[i] > arr[j] && lds[i] < lds[j] + 1){
                    lds[i] = lds[j] + 1;
                }
            }
      }
      int max=lis[0]+lds[0]-1;
      for(int i=1;i<n;i++){
        int temp = lis[i]+lds[i]-1;
        if(temp>max){
          max=temp;
        }
      }
      return max;
	}
	
}
