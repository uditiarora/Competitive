import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    // Complete the solve function below.
    static HashMap<Long, Boolean> m;
    static String solve(long n) {

        if(m.containsKey(n)){
            return "IsFibo";
        }
        return "IsNotFibo";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        m = new HashMap<Long,Boolean>();
        int i = 0;
        long a=0,b=1,c=0;
        long max = (long)Math.pow(10,10);
        m.put(a,true);
        m.put(b,true);
        while(c<=max){
            c = a + b;
            a = b;
            b = c;
            m.put(c,true);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int tItr = 0; tItr < t; tItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = solve(n);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
