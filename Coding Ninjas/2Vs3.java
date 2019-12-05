import java.util.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
 
class FastScanner {
	
    private InputStream mIs;
	private byte[] buf = new byte[1024];
	private int curChar;
	private int numChars;
 
	public FastScanner() {
		this(System.in);
	}
 
	public FastScanner(InputStream is) {
		mIs = is;
	}
 
	public int read() {
		if (numChars == -1)
			throw new InputMismatchException();
		if (curChar >= numChars) {
			curChar = 0;
			try {
				numChars = mIs.read(buf);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
			if (numChars <= 0)
				return -1;
		}
		return buf[curChar++];
	}
 
	public String nextLine() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isEndOfLine(c));
		return res.toString();
	}
 
	public String nextString() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = read();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public long nextLong() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		long res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public int nextInt() {
		int c = read();
		while (isSpaceChar(c))
			c = read();
		int sgn = 1;
		if (c == '-') {
			sgn = -1;
			c = read();
		}
		int res = 0;
		do {
			if (c < '0' || c > '9')
				throw new InputMismatchException();
			res *= 10;
			res += c - '0';
			c = read();
		} while (!isSpaceChar(c));
		return res * sgn;
	}
 
	public boolean isSpaceChar(int c) {
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public boolean isEndOfLine(int c) {
		return c == '\n' || c == '\r' || c == -1;
	
	}	
}
public class Main {
    static int[] segment;
    static int[] arr;
    static int[] pow;
    Main(int n){segment= new int[4*n];  arr= new int[4*n];
        pow= new int[2*n+10];
        pow[0]=1;
        for(int i=1;i<=2*n;i++)
            pow[i]=(pow[i-1]*2)%3;
    }
    
    static void update(int node ,int start ,int end ,int x){
        //System.out.println("In U");
        if(start==end){
            segment[node]=1;
            arr[x]=1;
            
        }    
        else{
        int mid=(start+end)/2;
        
        if(x>=start && x<=mid)    
            {
                update(2*node ,start ,mid ,x );
            }
        else
            {
                update(2*node+1 ,mid+1 ,end ,x );
            }    
        
        segment[node]= (segment[2*node]*pow[end-mid]+segment[2*node+1] )%3;
        }
        
    }
    
    static void build(int node ,int start ,int end){
  //   System.out.println(node+" "+start+" "+end);
        if(start==end)
        {
            segment[node]=arr[start];
        }
        else
        {
        int mid=(start+end)/2;
        build(2*node ,start ,mid);    
        build(2*node+1 ,mid+1 ,end);    
        
        segment[node]=(segment[2*node]*pow[end-mid]+segment[2*node+1])%3;    
        }
    }
    
    static int Query(int node ,int start ,int end ,int l ,int r){
       //  System.out.println(node+" "+start+" "+end);
      // System.out.println("In Q");
        if(r<start || l>end) return 0;
        
        if(l<=start && r>=end)
            return (segment[node]*pow[r-end])%3;
        else{
        int mid=(start+end)/2;
        int a=Query(2*node,start,mid,l,r);
        int b=Query(2*node+1,mid+1,end,l,r);
            return (a+b)%3;    
        }
    }
    
    public static void main(String args[] ) throws Exception {
        FastScanner s = new FastScanner();
        int n = s.nextInt();
       Main test= new Main(n);
        arr[0]=0;
        int i;
      //System.out.println("Here D");
        String fs=s.nextString();
        for( i=1;i<=n;i++)
            arr[i]=(int)(fs.charAt(i-1)-'0');
        //    System.out.println("Here D");
        build(1,1,n);
      //  for( i=1;i<2*n;i++) System.out.println(i+" "+segment[i]);
       //System.out.println("B done");
        int q = s.nextInt();
       
        while(q-->0)
        {
            int a=s.nextInt();
            
            if(a==0){
                int l=s.nextInt();
                int r=s.nextInt();
            System.out.println(Query(1,1,n,l+1,r+1));
          //  System.out.println("BQ done");    
            }
            else{
            int y=s.nextInt();
            update(1,1,n,y+1);
            //System.out.println("BU done");
                }
        }
    }
}