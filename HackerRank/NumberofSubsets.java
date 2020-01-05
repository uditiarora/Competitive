import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    public static int mod = 1000000007;

    public static long exp(long b, long e, long m) {
    long r = 1;
    while (e > 0) {
      if ((e&1) == 1) r = (r * b) % m;
      b = (b * b) % m;
      e >>= 1;
    }
    return r;
  }
  
  public static long solve(long N) {
    long total = exp(2, (exp(2, N, mod-1) - N % (mod - 1) + mod - 1) % (mod - 1), mod);
    return total;
  }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = solve(n);
            int res = (int)(result%mod);
            bufferedWriter.write(String.valueOf(res));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
