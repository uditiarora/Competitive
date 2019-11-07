public class solution {
	public static void printSubsets(int input[]) {
		// Write your code
      int arr[]=new int[0];
      help(input,arr,0);
	}
  
  public static void help(int input[],int ans[],int index){
    if(index==input.length){
      for(int i=0;i<ans.length;i++){
        System.out.print(ans[i]+" ");
      }
      System.out.println();
      return;
    }
    
    int arr[]=new int[ans.length+1];
    int i=0;
    for(;i<ans.length;i++){
      arr[i]=ans[i];
    }
    arr[i]=input[index];
    help(input,ans,index+1);
    help(input,arr,index+1);
    
    
  }
  
  
}
