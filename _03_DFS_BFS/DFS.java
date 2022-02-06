package _03_DFS_BFS;

import java.util.*;

public class DFS {
    public static boolean[] visited = new boolean[1001];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    static void dfs(int start){
        //현재 노드를 방문 처리
        visited[start] = true;
        sb.append(start + " ");
        //현재 노드와 연결된 다른 노드들을 재귀적으로 방문
        for(int i = 0; i < graph.get(start).size(); i++){
            int y = graph.get(start).get(i);
            if(!visited[y]) dfs(y);
        }
        
    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now + " ");
            //해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int i = 0; i < graph.get(now).size(); i++){
                int y = graph.get(now).get(i);
                if(!visited[y]){
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
    static class Node implements Comparable<Node>{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Node other){
            if(this.x == other.x){
                return this.y - other.y;
            }
            return this.x - other.x;
            
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int m = sc.nextInt();
       int v = sc.nextInt();

       for(int i = 0; i <=n; i++){
           graph.add(new ArrayList<>());
       }
       ArrayList<Node> list = new ArrayList<>();
       for(int i = 0; i < m; i++){
           int a = sc.nextInt();
           int b = sc.nextInt();
           list.add(new Node(a,b));
       }
       Collections.sort(list);

       for(int i = 0; i < m; i++){
        Node node = list.get(i);
        graph.get(node.x).add(node.y);
        graph.get(node.y).add(node.x);
        }
       dfs(v);
       sb.append("\n");
       Arrays.fill(visited,false);
       bfs(v);
       System.out.println(sb.toString());
    }
}
