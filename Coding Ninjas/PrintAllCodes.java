import java.lang.*;
public class solution {
static int v=0;
static int sum=0;
static int base=1;
	public static void printAllPossibleCodes(String input) {
		// Write your code here
        
        int n = convertStringToInt(input);
        print(n,"");
        
        
	}
	
	
		public static int convertStringToInt(String input){
	     int  n=input.length();
        int a;
        base=(int)Math.pow(10,n-1-v);
        if(v<n){
            a=((int)input.charAt(v)-48);
            sum=sum+a*base;
            
            v++;
            convertStringToInt(input);
        }
        return sum;
	}
	
	public static void print(int input,String ans){
	    
	    if(input==0){
	        System.out.println(ans);
	        return;
	    }
	    int x = input/10;
	    int n=input%10;
	    print(input/10,(char)(n+96)+ans);
	    if(x>0){
	        	    int temp= (x%10)* 10 + n;

	        if(temp<=26){
	        print(x/10,(char)(temp+96) + ans);
	    }
	    }
	    
	    
	}
	
}
