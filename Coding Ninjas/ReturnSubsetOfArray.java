public class solution {

	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
		// Write your code here
		return help(input,0);
	}
  public static int[][] help(int input[],int index){
    if(index==input.length){
      int[][] arr=new int[1][0];
      return arr;
    }
    
    
    int[][] getarr = help(input,index+1);
    int[][] myarr=new int[2*getarr.length][];
    int k=0;
    for(int i=0;i<getarr.length;i++){
      myarr[k] = new int[getarr[i].length];
      
      for(int j=0;j<myarr[k].length;j++){
        myarr[k][j]=getarr[i][j];
      }
      k++;
      
    }
    for(int i=0;i<getarr.length;i++){
      myarr[k] = new int[getarr[i].length+1];
      myarr[k][0]=input[index];
      for(int j=1;j<myarr[k].length;j++){
        myarr[k][j]=getarr[i][j-1];
      }
      k++;
      
    }
    
    return myarr;
    
    
  }
  
  
  
}
