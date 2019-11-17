import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {



    private static final Scanner scanner = new Scanner(System.in);

    public static long gcd(long a, long b){
        if(b==0){
            return a;
        }
        return gcd(b, a%b);
    }

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] a = new long[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long aItem = Integer.parseLong(aItems[i]);
            a[i] = aItem;
        }

        // Write Your Code Here
        long[] left = new long[n+1];
        long[] right = new long[n+1];
        for(int i = 0;i < n;i++){
            left[i+1] = gcd(left[i], a[i]);
        }
        for(int i = n-1;i >= 0;i--){
            right[i] = gcd(right[i+1], a[i]);
        }
        for(int i = 0;i < n;i++){
            long g = gcd(left[i], right[i+1]);
            if(a[i] % g != 0){
                System.out.println(g);
                return;
            }
        }
        scanner.close();
    }
}
