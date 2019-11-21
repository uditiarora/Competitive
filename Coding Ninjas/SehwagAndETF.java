import java.util.*;

public class Main {
	static int[] prime =new int[1000002];
	static int[] arr=new int[100001];
	static int[] brr=new int[100001];
	static int mod = (int)Math.pow(10, 9)+7;
	public static void main(String[] args) {
		// Write your code here
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i=1;i<=1000000;i++){
			prime[i]=i;
		}
		for(int i=2;i<=1000000;i++){
			if(prime[i] == i){
				for(int j=2;j*i<=1000000;j++){
					prime[j*i] = (i-1)*prime[j*i]/i;
				}
				prime[i]=i-1;
				list.add(i);
			}
		}
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		int l = list.size();
		while(t--!=0){
			int a=s.nextInt();
			int b =s.nextInt();
			int k =s.nextInt();
			int c=0;
			if(b <= 1000000) {
	        	for(int i = a; i <= b; i++) {
	        		if(prime[i]%k == 0) {
	        			c++;
	        		}
	        	}
	    		System.out.printf("%.6f",(double)(c)/(double)(b-a+1));
	    		System.out.println();
	        	continue;
	    	}
			for(int i = a; i <= b; i++) {
	        	arr[i-a] = i;
	        	brr[i-a] = i;
	    	}
			for(int i=0;i<l;i++){
				int y = (a/list.get(i))*list.get(i);
	        	for(int j = y; j <= b; j += list.get(i)) {
	            	if(j < a) {
	                	continue;
	            	}
	            	while(brr[j-a]%list.get(i) == 0) {
	                	brr[j-a] /= list.get(i);
	            	}
	            	arr[j-a] /= (list.get(i));
	            	arr[j-a] *= (list.get(i)-1);
	        	}
			}
			for(int i = a; i <= b; i++) {
	        	if(arr[i-a] == i) {
	            	arr[i-a] = i-1;
	            	if(arr[i-a]%k == 0) {
	            		c++;
	            	}
	            	continue;
	        	}
	        	else if(brr[i-a] != 1) {
	            	arr[i-a] /= brr[i-a];
	            	arr[i-a] *= (brr[i-a]-1);
	        	}
	        	if(arr[i-a]%k == 0) {
	        		c++;
	        	}
	    	}
	    	System.out.printf("%.6f",(double)(c)/(double)(b-a+1));
	    	System.out.println();
	   	
			
		}
      
	}

}