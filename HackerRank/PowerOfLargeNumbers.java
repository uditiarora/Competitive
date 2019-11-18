import java.io.*;
import java.util.*;

public class Solution {
    private static Scanner in;
    private static java.util.regex.Pattern pattern;

    private static void InitStatic() {
        in = new Scanner(System.in);
        pattern = java.util.regex.Pattern.compile("[0-9]+");
    }

    private static long readInt() {
        if (in == null) InitStatic();
        return in.nextInt();
    }
        

    private static long readIntMod(long X) {
        if (in == null) InitStatic();
        String str = in.next(pattern);
        long result = 0;
        long pow10 = 1;
        for (int i = str.length() - 1; i >= 0; --i) {
            long digit = (long)(str.charAt(i) - '0');
            result = (result + pow10 * digit) % X;
            pow10 = (pow10 * 10) % X;
        }
        return result;
    }

    private static long powMod(long A, long B, long X) {
        long answer = 1;
        long powerTwo = A;
        A = A % X;
        while (B != 0) {
            if (B % 2 != 0) {
                answer = (answer * powerTwo) % X;
            }
            powerTwo = (powerTwo * powerTwo) % X;
            B /= 2;
        }
        return answer;
    }

    public static void main(String[] args) {
        long N = readInt();
        long X = 1000000007;
        for (int i = 0; i < N; ++i) {
            long A = readIntMod(X);
            long B = readIntMod(X - 1);
            int answer = (int) powMod(A, B, X);
            System.out.printf("%d\n", answer);
        }
    }
    
}