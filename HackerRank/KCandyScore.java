import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int MOD = (int)1e9;
        int Z = 2005;
        long[][] C = new long[Z + 1][Z + 1];
        C[0][0] = 1;
        for (int i = 1 ; i<= Z ; i++) {
            C[i][0] = 1;
            for (int k = 1 ; k <= Z ; k++)
                C[i][k] = (C[i-1][k] + C[i-1][k-1]) % MOD;
        } 
        int t = sc.nextInt();
        for (int i=0 ; i<t ; i++) {
            int n = sc.nextInt();
            int k = sc.nextInt();   
            System.out.println(C[n + k - 1][n - 1]);
        }     
        
    }
}