package _03_DFS_BFS;

import java.util.*;

public class BFS {
    static boolean[] visited;
    static boolean[][] graph;
    static StringBuilder sb = new StringBuilder();
    static int n,m,v;
    static void dfs(int start){
        visited[start] = true;
        sb.append(start + " ");
        for(int i = 1; i <= n; i++){
            if(graph[start][i] && !visited[i]){
                dfs(i);
            }
        }
    }
    static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now +  " ");
            for(int i = 1; i <= n; i++){
                if(graph[now][i] && !visited[i]){
                    q.offer(i);
                    visited[i] = true;
                }
            }

        }
    }
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        v = sc.nextInt();
        
        visited = new boolean[n+2];
        graph = new boolean[n+2][n+2];
        
        for(int i = 0; i < m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = true;
            graph[b][a] = true;
        }

        dfs(v);
        Arrays.fill(visited,false);
        sb.append("\n");
        bfs();
        System.out.println(sb.toString());
    }
}
