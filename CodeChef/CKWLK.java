import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int loop = 0; loop < t; loop++) {
            long n = in.nextLong();
            boolean flag = true;
            long a = 0;
            long b = 0;
            while(n > 0){
                if(n % 2 == 0){
                    a++;
                    n = n/2;
                }else if(n % 5 == 0){
                    b++;
                    n = n/5;
                }else if(n == 1){
                    break;
                }else{
                    flag = false;
                    break;
                }
            }
            double x = a - b;
            double y = 2*b - a;
            if(a == 0 || b == 0 || x < 0 || y < 0)
                flag = false;
            if(!flag)
                System.out.println("No");
            else
                System.out.println("Yes");
        }
    }
}