public class solution {
	
	public static String[] permutationOfString(String input){
		// Write your code here
		
		return permutate(input);
	
		
	}
	public static int fact(int n){
	    int ans=1;
	    for(int i=1;i<=n;i++){
	        ans = ans*i;
	    }
	    return ans;
	    
	}
	
	
 	 public static String[] permutate(String input){
 	     
 	     int k=0;
 	     String[] myarr = new String[fact(input.length())];
 	     
 	     if(input.length()==1){
 	         String[] s=new String[1];
 	         s[0]= "" + input.charAt(0);
 	         return s;
 	     }
 	     
 	     for(int i=0;i<input.length();i++){
 	         String substr;
 	         if(i==input.length()-1){
 	             substr = input.substring(0,input.length()-1);
 	         }
 	         else{
 	        substr = input.substring(0,i) + input.substring(i+1,input.length());
 	         }
 	         String[] getarr = permutate(substr);
 	         int x=0;
 	         for(x=0;x<getarr.length;x++){
 	             myarr[k] =input.charAt(i)+ getarr[x];
 	             
 	         k++;
 	         }
 	     }
 	     
 	     return myarr;
 	 }
	
}
