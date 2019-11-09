public class solution {
	public static void printSubsetsSumTok(int input[], int k) {
		// Write your code here
      int arr[]=new int[0];
		help(input,k,0,arr);
	}
  
  public static void help(int input[],int k,int index,int res[]){
    if(index==input.length){
      if(k==0){
        for(int i=0;i<res.length;i++){
          System.out.print(res[i]+" ");
        }
        System.out.println();
      }
      return;
    }
    
    int temp[]=new int[res.length+1];
    int i=0;
    for(;i<res.length;i++){
      temp[i]=res[i];
    }
    temp[i]=input[index];
    help(input,k-input[index],index+1,temp);
    help(input,k,index+1,res);
    
    
  }
  
  
  
  
}
