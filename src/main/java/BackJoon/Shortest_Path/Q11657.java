package BackJoon.Shortest_Path;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11657 {
    static int N;
    static int M;
    static int A;
    static int B;
    static int C;

    static ArrayList<Node> graph = new ArrayList<>();
    static long[] d;
    static int INF = 100000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        d = new long[N + 1];
        Arrays.fill(d, INF);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            graph.add(new Node(A, B, C));
        }

        if(bf(1)) {
            System.out.println(-1);
        }
        else {
            for (int i = 2; i <= N; i++) {
                if(d[i] == INF)
                    System.out.println(-1);
                else
                    System.out.println(d[i]);
            }
        }
    }

    public static boolean bf(int start) {
        boolean cycle = false;
        d[start] = 0;

        // 전체 n-1번의 라운드를 반복
        for (int i = 0; i <= N; i++) {
            // 매 반복마다 "모든 간선"을 확인
            for (int j = 0; j < M; j++) {
                int now = graph.get(j).index;
                int next = graph.get(j).next;
                int distance = graph.get(j).distance;

                // 시작점 최단경로가 무한대가 아닐 경우 && 시작점 최단경로 + 목적지까지 가중치가 목적지 최단경로보다 작을때
                if(d[now] != INF && d[now] + distance < d[next]) {
                    d[next] = d[now] + distance;
                    // 순회에서 음의 사이클 조회
                    if(i == N) {
                        cycle = true;
                    }
                }
            }
        }
        return cycle;
    }

    static class Node {
        int index;
        int next;
        int distance;

        public Node(int index, int next, int distance) {
            this.index = index;
            this.next = next;
            this.distance = distance;
        }

//        @Override
//        public int compareTo(Node o) {
//            if(this.distance < o.distance) {
//                return -1;
//            }
//            return 1;
//        }
    }
}
