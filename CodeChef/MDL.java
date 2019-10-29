import java.util.*;
import java.lang.*;
import java.io.*;
/*

*/
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scanner = new Scanner(System.in);
        int tests = scanner.nextInt();
        for(int test=0; test<tests; test++){
            int n = scanner.nextInt();
            int temp=0,max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, mini=0, maxi=0;
            for(int i=0;i<n;i++){
                temp = scanner.nextInt();
                if(temp > max){
                    max= temp;
                    maxi= i;
                }
                if(temp < min){
                    mini=i;
                    min=temp;
                }
            }
            System.out.println( (maxi>mini ? min+" "+ max : max+" "+ min ) );
        }
	}
	
	
}
