import java.io.*;
import java.math.BigInteger;
import java.util.*;


public class Solution {

    void solve() throws IOException {
        int n=nextInt();
        int sum=0;
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=nextInt();
            sum+=a[i];
        }
        int cur=0;
        for(int i=0;i<n;i++){
            cur+=a[i];
            if(sum%cur==0){
                int s=0;
                boolean good=true;
                for(int j=i+1;j<n;j++){
                    s+=a[j];
                    if(s==cur)s=0;
                    if(s>cur)break;
                }
                if(s!=0&&s!=cur)good=false;
                if(good)out.print(cur+" ");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Solution().run();
    }

    void run() throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
//		reader = new BufferedReader(new FileReader("input.txt"));
        tokenizer = null;
        out = new PrintWriter(new OutputStreamWriter(System.out));
//		out = new PrintWriter(new FileWriter("output.txt"));
        solve();
        reader.close();
        out.flush();

    }

    BufferedReader reader;
    StringTokenizer tokenizer;
    PrintWriter out;

    int nextInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    long nextLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    double nextDouble() throws IOException {
        return Double.parseDouble(nextToken());
    }

    String nextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }
}