public class solution {

	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int k) {
		// Write your code here
		return util(input,k,0);
	}
  
  	public static int[][] util(int input[],int k,int i){
       if(i==input.length){
    	  if(k==0){
    		  return new int[1][0];
    		  
    	  }
    	  else{
    		  return new int[0][0];
    	  }
      }
     
      int[][] get = util(input,k-input[i],i+1);
      int[][] get1 = util(input,k,i+1);
      int x = get.length + get1.length;
      int ans[][] = new int[x][];
      int c=0;
      for(int j=0;j<get.length;j++){
        ans[c] = new int[get[j].length + 1];
        ans[c][0] = input[i];
        for(int l=1;l<ans[c].length;l++){
          ans[c][l] = get[j][l-1];
        }
        c++;
      }
      for(int j=0;j<get1.length;j++){
        ans[c] = new int[get1[j].length];
        for(int l=0;l<ans[c].length;l++){
          ans[c][l] = get1[j][l];
        }
        c++;
      }
      return ans;
    }
  
  
}
