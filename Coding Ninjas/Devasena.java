
 
import java.util.*;
import java.lang.*;
import java.io.*;
 

public class Main
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw=new PrintWriter(System.out);
	public static void main (String[] args) throws java.lang.Exception
	{
	    int t=Integer.parseInt(br.readLine());
	    for(int q=1;q<=t;q++)
	    {
	        int n=Integer.parseInt(br.readLine());
	        StringTokenizer st=new StringTokenizer(br.readLine());
	        int a[]=new int[n];
	        long f[]=new long[100001];
	        long s[]=new long[100001];
	        int maxa=-1;
	        long ans=1;
	        for(int i=0;i<n;i++)
	        {
	            a[i]=Integer.parseInt(st.nextToken());
	            maxa=Math.max(maxa,a[i]);
	            f[a[i]]++;
	        }
	        for(int i=maxa;i>=1;i--)
	        {
	            long p1=f[i];
	            long p2=0;
	            for(int j=2;j*i<=maxa;j++)
	            {
 		            p1+=f[i*j];
 		            p2=(p2+s[i*j])%(1000000007-1);
	            }
	            long subsets=(binpow(2,p1,1000000007-1)-1-p2+1000000007-1)%(1000000007-1);
	            ans=(ans*binpow(i,subsets,1000000007))%1000000007;
                s[i]=subsets;
	        }
	        pw.println(ans);
	    }
	    
		// your code goes here
		pw.close();
	}
	public static long binpow(long a, long b, long m)
	{
	    long res=1;
	while(b!=0) {
 
         if((b&1)!=0)
		res=(res*a)%m;
 
	   a=(a*a)%m;
	   b>>=1;
 
	}
	return res;
	}
}
 
