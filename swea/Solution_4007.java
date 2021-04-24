package com.btype.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_4007 {
    static final int INF = 1000000000;
    static int N, M, X;
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
         
        int T = Integer.parseInt(br.readLine());
         
        for(int tc=1; tc<=T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 정점의 개수
            M = Integer.parseInt(st.nextToken()); // 간선의 개수
            X = Integer.parseInt(st.nextToken());
             
            List<List<Node>> adList = new ArrayList<>();
            List<List<Node>> adList2 = new ArrayList<>();
            // 인덱스를 1부터 하기 위해 임의로 한 개를 넣어둠  
            adList.add(new<Node> ArrayList());
            adList2.add(new<Node> ArrayList());
            for(int i=1; i<=N; i++) {
                adList.add(new<Node> ArrayList());
                adList2.add(new<Node> ArrayList());
            }
             
            while(M-- > 0) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                adList.get(u).add(new Node(v, cost));
                adList2.get(v).add(new Node(u, cost));
            }
             
            // dist[] INF로 초기화
            int[] dist = new int[N+1]; int[] dist2 = new int[N+1];
            Arrays.fill(dist, INF); Arrays.fill(dist2, INF);
 
            // 다익스트라 알고리즘
            dijkstra(X, adList, dist);
            dijkstra(X, adList2, dist2);
             
            int answer = Integer.MIN_VALUE;
            System.out.print("#" + tc + " ");
            for (int i=1; i <= N; i++) {
                // 연결된 정점이 아닌 경우 
                if(dist[i] >= INF || dist2[i] >= INF) continue;
                answer = Math.max(answer, dist[i] + dist2[i]);
            }
            System.out.println(answer);
        }
    }
     
    private static void dijkstra(int start, List<List<Node>> adList, int[] dist) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
         
        dist[start] = 0;
        pq.add(new Node(start, 0));
         
        while(!pq.isEmpty()) {
            Node current =  pq.poll();
            // 재방문 여부 확인
            if(visited[current.ID]) continue;
            visited[current.ID] = true;
            // 연결된 정점들을 확인 
            for(Node next : adList.get(current.ID)) {
                // 효율적인 처리를 위해 최소 거리 비용이 갱신되는 경우만 queue에 넣어줍니다.
                if(dist[next.ID] > dist[current.ID] + next.distance) {
                    // 최소 거리 비용 갱신
                    dist[next.ID] = dist[current.ID] + next.distance;
                    pq.add(new Node(next.ID, dist[next.ID]));
                }
            }
        }
    }
}
 
class Node implements Comparable<Node>{
    int ID;
    int distance;
     
    public Node(int ID, int distance) {
        this.ID = ID;
        this.distance = distance;
    }
     
    @Override
    public int compareTo(Node target) {
          // 작은 거리 비용이 먼저 오도록
          return this.distance - target.distance;
    }
}