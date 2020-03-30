

Topics


Graphs - 2(Optional)
Deadline
Mar 16, 2019, 5:29 AM
Lecture
0.0%

Score 0/360

MST & Kruskals Introduction

Cycle Detection

Kruskal's Algorithm

Code : Kruskal's Algorithm
0/120

Kruskals Algorithm - Solution

Complexity of Kruskal's Algorithm

Prim's Algorithm

Code : Prim's Algorithm
0/120

Solution : Prim's Algorithm

Complexity of Prim's Algorithm

Dijkstra’s Algorithm

Code : Dijkstra's Algorithm
0/120

Solution : Dijkstra's Algorithm


ASK/VIEW DOUBT


SOLUTION


Problem
Result
Code : Prim's Algorithm
Send Feedback
Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the Minimum Spanning Tree (MST) using Prim's algorithm.
For printing MST follow the steps -
1. In one line, print an edge which is part of MST in the format -
v1 v2 w
where, v1 and v2 are the vertices of the edge which is included in MST and whose weight is w. And v1 <= v2 i.e. print the smaller vertex first while printing an edge.
2. Print V-1 edges in above format in different lines.
Note : Order of different edges doesn't matter.
Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)
Output Format :
MST
Constraints :
2 <= V, E <= 10^5
Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 1 3
1 2 1
0 3 5


Code Pair

1
import java.util.Scanner;
2
​
3
public class Solution {
4
​
5
    public static void main(String[] args) {
6
        Scanner s = new Scanner(System.in);
7
        int V = s.nextInt();
8
        int E = s.nextInt();
9
​
10
        /* Write Your Code Here
11
         * Complete the Rest of the Program
12
         * You have to take input and print the output yourself
13
         */
14
    }
15
}

CUSTOM INPUT


SUBMIT SOLUTION


PREVIOUS


NEXT


Python (3.5)
Java (SE 1.8)
C++ (g++ 5.4)
1
import java.util.Scanner;
2
​
3
public class Prims {
4
​
5
    private static void prims(int[][] adjacencyMatrix) {
6
        int v = adjacencyMatrix.length;
7
        boolean visited[] = new boolean[v];
8
        int weight[] = new int[v];
9
        int parent[] = new int[v];
10
        weight[0] = 0;
11
        parent[0] = -1;
12
        for(int i = 1; i < v; i++){
13
            weight[i] = Integer.MAX_VALUE;
14
        }
15
        for(int i = 0; i < v; i++){
16
            // Pick vertex with min weight
17
            int minVertex = findMinVertex(weight, visited);
18
            visited[minVertex] = true;
19
            // Explore its unvisited neighbors
20
            for(int j = 0; j < v; j++){
21
                if(adjacencyMatrix[minVertex][j] != 0 && !visited[j]){
22
                    if(adjacencyMatrix[minVertex][j] < weight[j]){
23
                        weight[j] = adjacencyMatrix[minVertex][j];
24
                        parent[j] = minVertex;
25
                    }
26
                }
27
            }
28
        }
29
        
30
        // Print edges of MST
31
        for(int i = 1; i < v; i++){
