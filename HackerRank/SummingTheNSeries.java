import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the summingSeries function below.
     */
     static int mod = (int)Math.pow(10,9)+7;
    static int summingSeries(long n) {
        /*
         * Write your code here.
         */
         int ans = (int)(((n%mod) * (n%mod))%mod);
         return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(scanner.nextLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            long n = Long.parseLong(scanner.nextLine().trim());

            int result = summingSeries(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }
}
