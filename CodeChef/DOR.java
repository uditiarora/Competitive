import java.util.*;
import java.io.*;
import static java.lang.Long.*;

 class Codechef{
    
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(in.readLine());
        StringBuilder Ans=new StringBuilder("");
        while(t-->0){
            String ss[]=in.readLine().split(" ");
            long L=parseLong(ss[0]);
            long R=parseLong(ss[1]);
            String l=toBinaryString(L);
            String r=toBinaryString(R);
            StringBuilder ans=new StringBuilder("");
            int f=0;
            int lL=l.length();int rL=r.length();
            if(lL<rL){
                for(int i=0;i<rL;i++){
                    ans.append("1");
                }
            }
            else{
                for(int i=0;i<lL;i++){
                    if(f==1){
                        ans.append("1");
                        continue;
                    }
                    if(l.charAt(i)!=r.charAt(i)){
                        f=1;
                        ans.append("1");
                    }
                    else{
                        ans.append(l.charAt(i));
                    }
                }
            }
            String temp=ans.toString();
            long decimal=parseLong(temp,2);
 
            Ans.append(decimal+"\n"); 
        }
        System.out.println(Ans);
    }
}