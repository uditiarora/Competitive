public class solution {

	public static void permutations(String input){
		// Write your code here
      	print(input,"");
	}
  
  
  public static void print(String input,String ans){
    if(input.length()==0){
      System.out.println(ans);
      return;
    }
    int n = input.length();
    for(int j=0;j<n;j++){
      String temp = input.substring(0,j) + input.substring(j+1,n);
      print(temp,input.charAt(j)+ans);
    }
    
    
    
  }
}
