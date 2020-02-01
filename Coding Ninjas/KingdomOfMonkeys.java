import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
static ArrayList <Integer> adj[]=new ArrayList[100001];
    static long  input[]=new long [100001];
    static boolean [] visited=new boolean[100001];
    public static void main(String[] args) throws Exception {
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        int t=Integer.parseInt(line);
        while(t--!=0)
        {
            
            String [] st=(br.readLine()).split(" ");
            int n=Integer.parseInt(st[0]);
            int m=Integer.parseInt(st[1]);
            for(int i=1;i<=n;i++)
            {
            adj[i]=new ArrayList<Integer>();
            }
            for(int i=1;i<=m;i++)
            {
            st = (br.readLine()).split(" ");
            int a = Integer.parseInt(st[0]);
            int b = Integer.parseInt(st[1]);
            adj[a].add(b);
            adj[b].add(a);
            }
            st=(br.readLine()).split(" ");
            for(int i=1;i<=n;i++)
            {
            input[i]=Long.parseLong(st[i-1]);
            }
            for(int i=0;i<visited.length;i++)
            {
            visited[i]=false;
            }
            long res=bfshelper(n);
            System.out.println(res);
        }
    }
    public static long bfshelper(int n)
    {
    long max=Integer.MIN_VALUE;    
    for(int i=1;i<=n;i++)
    {
    if(!visited[i])
    {
        long sum=bfs(i, visited);
        if(sum>max)
        {
        max=sum;
        }
    }
    }
    return max;
    }
    public static long bfs(int start,boolean visited[])
    {
    Queue<Integer> qe=new LinkedList<Integer>();
    qe.add(start);
    visited[start]=true;
    long sum=input[start];
        //System.out.println(start);
        //System.out.println("hey");
    while(!qe.isEmpty())
    {
    	int popped=qe.poll();
    	//Iterator<Integer> it=adj[popped].listIterator();
        for(int i=0;i<adj[popped].size();i++)
        {
        	int next=adj[popped].get(i);
        	if(!visited[next])
        	{
        	    qe.add(next);
        	    visited[next]=true;
        	    sum+=input[next];
        	}
        }
    }
    return sum;
    }  
}