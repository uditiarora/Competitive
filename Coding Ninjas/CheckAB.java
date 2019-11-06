public class Solution {

	public static boolean checkAB(String input) {
		// Write your code here
		if(input.charAt(0)!='a'){
		    return false;
		}
		return check(input,0);

	}
	
	public static boolean check(String input, int start){
	   int n=input.length();
	    boolean res=false;
	    if(start==n){
	        return true;
	    }
	    if(start==n-1){
	        if(input.charAt(n-1)=='a'){
	            return true;
	        }
	       else if(input.charAt(n-1)=='b' && input.charAt(n-2)=='b'){
	           return true;
	       }
	       else{
	           return false;
	       }
	    }
	    if(start==n-2 && input.charAt(n-2)=='a'){
	        if(input.charAt(n-1)=='a'){
	            return true;
	        }
	        else{
	            return false;
	        }
	    }
	    
	     if(start==n-2 && input.charAt(n-2)=='b'){
	        if(input.charAt(n-1)=='b'){
	            return true;
	        }
	    }
	    
	    
	    
	    if(input.charAt(start)=='a'){
	        if(input.charAt(start+1)=='b' && input.charAt(start+2)=='b'){
	            res= check(input,start+1);
	        }
	        else if(input.charAt(start+1)=='a'){
	            res=check(input,start+1);
	        }
	        else{
	            return false;
	        }
	    }
	    if(input.charAt(start)=='b' && input.charAt(start+1)=='b' ){
	        if(input.charAt(start+2)=='a'){
	            res= check(input,start+2);
	        }
	        else{
	            return false;
	        }
	    }
	    return res;
	}
}
