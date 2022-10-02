import java.io.*;
import java.util.*;

class Main {
    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int N,M;
    static String[][] graph;
    static Node R,B,Hole;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temps = br.readLine().split(" ");
        N = Integer.parseInt(temps[0]);
        M = Integer.parseInt(temps[1]);

        for (int i = 0; i < N; i++) {
            String[] strs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                graph[i][j] = strs[j];
                if (strs[j].equals("R")) {
                    R = new Node(i, j);
                } else if (strs[j].equals("B")) {
                    B = new Node(i, j);
                } else if (strs[j].equals("0")) {
                    Hole = new Node(i, j);
                }
            }
        }

        dfs(0, R, B);
    }

    static void dfs(int depth, Node R, Node B) {
        if(depth >= 10) return;

        for (int i = 0; i < 4; i++) {
            tilt(i, R, B);
        }
    }

    static void tilt(int i, Node R, Node B) {
        if (i == 0) {
            //왼쪽
            if (R.y < B.y) {//R이 더 왼쪽에 있을 때
                while (true) {
                    int rY = R.y;

                }
            }else {

            }
        } else if (i == 1) {
            //오른쪽
            tilt(i, R, B);
        } else if (i == 2) {
            //위
            tilt(i, R, B);
        } else {
            //아래
            tilt(i, R, B);
        }
    }

    //dfs로 현재 R,B의 위치에서 상 하 좌 우로 판을 기울여 보내본다.
    //판을 기울일 시에는 상이면 위, 하이면 아래 구슬이 먼저 움직이게 한다.
    //굴리는 경로에 0이 있을 경우, 그 depth를 바로 출력한다.
}
