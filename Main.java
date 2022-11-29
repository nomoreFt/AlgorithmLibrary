import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static final int BLANK = 0;
    static final int WALL = -1;
    static final int PRISON = 1;
    static final int DOOR = 2;

    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {-1, 0, 1, 0};

    static int[][] map = new int[105][105];
    static int h,w;

    public static void main(String[] args) throws IOException {

        int t;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            Node helper = new Node(0, 0);
            Node prison1 = new Node(-1, -1);
            Node prison2 = new Node(-1, -1);

            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken()) + 2;
            w = Integer.parseInt(st.nextToken()) + 2;

            for (int i = 1; i < h - 1; i++) {

                String s = "." + br.readLine() + ".";//양 옆을 공백으로 취급

                for (int j = 0; j < w; j++) {
                    char c = s.charAt(j);
                    if (c == '.') {
                        map[i][j] = BLANK;
                    } else if (c == '*') {
                        map[i][j] = WALL;
                    } else if (c == '$') {
                        map[i][j] = PRISON;
                        if (prison1.x == -1) {//처음 감지되면 1번죄수
                            prison1 = new Node(i, j);
                        } else {
                            prison2 = new Node(i, j);
                        }
                    } else if (c == '#') {
                        map[i][j] = DOOR;
                    }
                }
            }

            for (int j = 0; j < w; j++) {
                map[0][j] = map[h - 1][j] = BLANK;
            } map 00 01 01 03 04
                map
        }
    }
    class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}