import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static int solve(int n, int m) {
        int x = (int)Math.sqrt(Math.floor(m)) + 1;
        boolean primes[] = new boolean[x+1];
        for(int i=2;i*i<=m;i++){
            if(primes[i]==false){
                for(int j=2*i;j<=x;j+=i){
                    primes[j] = true;
                }
            }
        }

        boolean act[] = new boolean[m-n+1];
        for(int i=2;i*i<=m;i++){
            if(!primes[i]){
                int lo = n/i * i;
                
                if(lo<n){
                    lo += i;
                }
                if(lo==i){
                    lo += i;
                }
                for(int j = lo;j<=m;j+=i){
                    act[j-n] = true;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<=m-n-2;i++){
            if(!act[i] && !act[i+2]){
                ans++;
            }
        }
    return ans;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int result = solve(n, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
