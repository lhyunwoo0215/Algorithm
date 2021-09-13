package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

    static class Edge implements Comparable<Edge>{
        int v, weight;
        public Edge(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            // TODO Auto-generated method stub
            return Integer.compare(this.weight, o.weight);
        }

    }

    static int V, E;
    static int start;
    static ArrayList<Edge>[] adj;
    static Edge[] min;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(br.readLine())-1;
        adj = new ArrayList[V];
        for(int i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }
        min = new Edge[V];
        visited = new boolean[V];

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            adj[Integer.parseInt(st.nextToken())-1].add(new Edge(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())));
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for(int i = 0; i < V; i++) {
            if( i == start ) {
                min[i] = new Edge(i, 0);
            }
            else {
                min[i] = new Edge(i, 987654321);
            }
            pq.add(min[i]);
        }
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            for( Edge next : adj[edge.v] ) {
                if( !visited[next.v] && min[next.v].weight > min[edge.v].weight + next.weight ) {
                    min[next.v].weight = min[edge.v].weight + next.weight;
                    pq.remove(min[next.v]);
                    pq.add(min[next.v]);
                }
            }
            visited[edge.v] = true;
        }

        for(Edge m : min) {
            sb.append(m.weight == 987654321 ? "INF" : m.weight).append("\n");
        }
        System.out.println(sb.toString());
    }
    static String src="5 6\n" +
            "1\n" +
            "5 1 1\n" +
            "1 2 2\n" +
            "1 3 3\n" +
            "2 3 4\n" +
            "2 4 5\n" +
            "3 4 6";
}
