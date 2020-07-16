import java.util.*;
public class Main {
    public static void main(String args[] ) throws Exception {
        
        Scanner s = new Scanner(System.in);
        int q=s.nextInt();
        for(int t=0;t<q;t++)
        {
            int n=s.nextInt();
            String s1[]=(s.next()).split(":");
            int in=Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
            s1=(s.next()).split(":");
            int wake=Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
            s1=(s.next()).split(":");
            int open=Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
            int travel=s.nextInt();
            int select=s.nextInt();
            int f[][]=new int[n][2];
            for(int i=0;i<n;i++)
            {
                s1=(s.next()).split(":");
                f[i][0]=Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
                s1=(s.next()).split(":");
                f[i][1]=Integer.parseInt(s1[0])*60+Integer.parseInt(s1[1]);
            }
            /*System.out.println(in+" "+wake+" "+open+" "+travel+" "+select);
            for(int i=0;i<n;i++)
            {
                System.out.println(f[i][0]+" "+f[i][1]);
            }*/
            if(n==0 || wake>in || open>in)
            {
                System.out.println("Case "+(t+1)+": -1");
                continue;
            }
            int consume=2*travel+select;
            int min=Integer.MAX_VALUE;
            int friend=-1;
            int max=0;
            if(wake+travel<=open)
                max=open-travel;
            else //if(wake<=open && wake+travel>=open)
                max=wake;
            for(int i=0;i<n;i++)
            {
                if(max+consume<f[i][0] && max+consume<min && max+consume<in)
                {
                    min=max+consume;
                    friend=i;
                    //System.out.println("1min :"+min+" friend : "+friend);
                }
                if(wake<f[i][1] && open<f[i][1] && f[i][1]+consume<in && f[i][1]+consume<min)
                {
                    min=f[i][1]+consume;
                    friend=i;
                    //System.out.println("2min :"+min+" friend : "+friend);
                }
                else if(max>f[i][1] && max+consume<in && max+consume<min)
                {
                    min=max+consume;
                    friend=i;
                    //System.out.println("3min :"+min+" friend : "+friend);
                } 
            }
            if(friend==-1)
                System.out.println("Case "+(t+1)+": -1");
            else
                System.out.println("Case "+(t+1)+": "+(friend+1));
        }
 
    }
}