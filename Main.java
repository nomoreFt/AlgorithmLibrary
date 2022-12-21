import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Main {
    static int k;
    static int[][] S;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        S = new int[k][k];
        ans = new int[k];
        String[] split = br.readLine().split("");
        int idx = 0;
        for (int i = 0; i < k; i++) {
            for (int j = i; j < k; j++) {
                if (split[idx].equals("+")) {
                    S[i][j] = 1;
                }
                if (split[idx].equals("-")) {
                    S[i][j] = -1;
                }
                if (split[idx].equals("0")) {
                    S[i][j] = 0;
                }
                idx++;
            }
        }

        dfs(0);
        for (int i=0; i<k; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println();

    }
    static boolean dfs(int idx) {
        if (idx == k) {
            return true;
        }
        if (S[idx][idx] == 0) {
            ans[idx] = 0;
            return checkPossible(idx) && dfs(idx+1);
        }
        for (int i = 1; i <= 10; i++) {
                ans[idx] = S[idx][idx] * i;
            if(checkPossible(idx) && dfs(idx+1)) return true;
        }
        return false;
    }

    private static boolean checkPossible(int idx) {
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += ans[i];
            int sign = S[i][idx];

            if (sign < 0) {
                if(sum >= 0) return false;
            }
            if (sign > 0) {
                if(sum <= 0) return false;
            }
            if (sign == 0) {
                if(sum != 0) return false;
            }
        }
        return true;
    }
}

