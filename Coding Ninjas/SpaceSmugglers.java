import java.util.*;
import java.lang.*;
import java.io.*;
public class Main{
    public static void main(String[] args) {
        InputReader fi=new InputReader(System.in);
        int i,j,n,m,base,ariel,u,v;
        long cost;
        n=fi.nextInt();
        m=fi.nextInt();
        base=fi.nextInt();
        ariel=fi.nextInt();
        Graph g=new Graph(n,m);
        Graph gR=new Graph(n,m);
        for (i=1;i<=m ;i++ ) {
            u=fi.nextInt();
            v=fi.nextInt();
            cost=fi.nextLong();
            g.addEdge(u,v,cost);
            gR.addEdge(v,u,cost);
        }
        long simple_s[]=g.Dijisktra(base);
        long simple_ariel[]=g.Dijisktra(ariel);
        long rev_s[]=gR.Dijisktra(base);
        long rev_ariel[]=gR.Dijisktra(ariel);
        long ans=Integer.MAX_VALUE;
 
        for (i=1;i<=n ;i++ ) {
           if (i!=base && i!=ariel) {
                ans=Math.min(ans,simple_s[i]+simple_ariel[i]+rev_s[i]+rev_ariel[i]);
            }
        }
        if(ans==Integer.MAX_VALUE)
        ans=-1;
        
       /* System.out.println(" simple s");
        g.printArray(simple_s);
        System.out.println(" simple ariel");
        g.printArray(simple_ariel);
        System.out.println(" reverse s");
        g.printArray(rev_s);
        System.out.println(" reverse ariel");
        g.printArray(rev_ariel);*/
 
 
        System.out.println(ans);
    }
}
 
class Graph{
    int n,m;
    ArrayList<Node> adj[];
    Graph(int n,int m){
        this.n=n;
        this.m=m;
        adj=new ArrayList[n+1];
        for (int i=0;i<=n ;i++ ) {
            adj[i]=new ArrayList<Node>();
        }
    }
    void addEdge(int i,int j,long weight){
        adj[i].add(new Node(j,weight));
    }
    long[]  Dijisktra(int s)
    {
        PriorityQueue<Node> pq=new PriorityQueue<>();
        long  dis[]=new long[n+1];
        boolean visit [] =new boolean[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        pq.add(new Node(s,0));
        dis[s]=0;
        long ans=0;
        while(!pq.isEmpty()){
            Node temp=pq.peek();
            pq.remove();
            int vertex=temp.vertex;
            Iterator <Node> it=adj[vertex].iterator();
            if(!visit[vertex]){
                while(it.hasNext()){
                    Node curr=it.next();
                    if (dis[curr.vertex] > dis[temp.vertex] + curr.cost ) {
                        dis[curr.vertex] = dis[temp.vertex] + curr.cost;
                        pq.add(new Node(curr.vertex,dis[curr.vertex]));
                    }
                }
            }
            visit[vertex]=true;
        }
        return dis;
    }
    void printArray(long [] arr){
        for(int i=1;i<=n;i++){
            System.out.print(arr[+i] + " ");
        }
        System.out.println();
 
    }
}
 
 
class Node implements Comparable<Node>{
    int vertex;
    long cost;
    Node(int vertex, long  cost){
        this.vertex = vertex; this.cost = cost;
    }
 
    public int compareTo(Node x){
        return Long.compare(this.cost, x.cost);
    }
}
class InputReader {
private InputStream stream;
private byte[] buf = new byte[8192];
private int curChar, snumChars;
private SpaceCharFilter filter;
 
public InputReader(InputStream stream) {
    this.stream = stream;
}
 
public int snext() {
    if (snumChars == -1)
        throw new InputMismatchException();
    if (curChar >= snumChars) {
        curChar = 0;
        try {
            snumChars = stream.read(buf);
        } catch (IOException e) {
            throw new InputMismatchException();
        }
        if (snumChars <= 0)
            return -1;
    }
    return buf[curChar++];
}
 
public int nextInt() {
    int c = snext();
    while (isSpaceChar(c))
        c = snext();
    int sgn = 1;
    if (c == '-') {
        sgn = -1;
        c = snext();
    }
    int res = 0;
    do {
        if (c < '0' || c > '9')
            throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
    } while (!isSpaceChar(c));
    return res * sgn;
}
 
public long nextLong() {
    int c = snext();
    while (isSpaceChar(c))
        c = snext();
    int sgn = 1;
    if (c == '-') {
        sgn = -1;
        c = snext();
    }
    long res = 0;
    do {
        if (c < '0' || c > '9')
            throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
    } while (!isSpaceChar(c));
    return res * sgn;
}
 
public int[] nextIntArray(int n) {
    int a[] = new int[n+1];
    for (int i = 1; i <= n; i++)
        a[i] = nextInt();
    return a;
}
 
public String readString() {
    int c = snext();
    while (isSpaceChar(c))
        c = snext();
    StringBuilder res = new StringBuilder();
    do {
        res.appendCodePoint(c);
        c = snext();
    } while (!isSpaceChar(c));
    return res.toString();
}
 
public boolean isSpaceChar(int c) {
    if (filter != null)
        return filter.isSpaceChar(c);
    return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
}
 
public interface SpaceCharFilter {
    public boolean isSpaceChar(int ch);
}
}