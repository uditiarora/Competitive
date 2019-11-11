import java.lang.*;
public class solution {
static int v=0;
static int sum=0;
static int base=1;
	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
		// Write your code here
		
		int n =convertStringToInt(input);
		int i=0;
		int x=n;
		while(x!=0){
		    i++;
		    
		    x=x/10;
		}
		
		int arr[]=new int[i];
		for(int j=i-1;j>=0;j--){
		    arr[j]=n%10;
		    n=n/10;
		}
		
		String str[]=new String[i];
		for(int j=0;j<i;j++){
		    str[j] = ""+ (char)(96+arr[j]);
		}
		
		return get(str,0,arr);
		
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
	
	
	
	public static String[] get(String[] input,int index,int[] arr){
	    
	    if(index==input.length-1){
	        String s[] = new String[1];
	        s[0]=""+input[index];
	        return s;
	    }
	    
	    if(index==input.length-2){
	       int temp=arr[index]*10 + arr[index+1];
	       
	       if(temp<=26){
	           String s[]=new String[2];
	           s[0]=input[index]+input[index+1];
	           s[1]= "" + (char)(temp+96);
	           return s;
	       }
	       else{
	           String s[]=new String[1];
	           s[0]=input[index]+input[index+1];
	           return s;
	       }
	       
	    }
	    int j=0;
	    int temp = arr[index]*10 + arr[index+1];
	    
	    String getarr[] = get(input,index+1,arr);
	    String myarr[] = new String[getarr.length];
	    
	    for(int i=0;i<getarr.length;i++){
	        myarr[i]=input[index] + getarr[i];
	    }
	    if(temp<=26){
	        String getarr1[] = get(input,index+2,arr);
	        String myarr1[] = new String[getarr.length + getarr1.length];
	        for(int i=0;i<myarr1.length;i++){
	            if(i<getarr.length){
	                myarr1[i]= myarr[i];
	            }
	            else{
	                myarr1[i] =(char)(temp+96) +  getarr1[j];
	                j++;
	            }
	        }
	        return myarr1;
	    }
	    
	    return myarr;  
	}

}
