import java.util.*;

class Solution {
    public static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
        
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t>0) {
            t--;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            boolean flag=false;
            if (a>c || b>c) {
                int d = gcd(a,b);
                if (d%c==0 || c%d==0) {
                    flag=true;
                }
            }
            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}