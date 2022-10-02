### 백준의 N과 M으로 알아보는 순열과 조합 뽑기
3
> 순열
 
<details> <summary> <h1>-모두 출력하는 순열 (동일 수 중복) </h1> </summary>

[N과M 1](https://www.acmicpc.net/problem/15649)       
        
[##_Image|kage@JKOul/btrt0M7qsbk/kddfgxNs0LO7KiBWUkD5zK/img.png|CDM|1.3|{"originWidth":1030,"originHeight":459,"style":"alignCenter"}_##]

```java
static class Permutation{
        int n;
        int r;
        int now[];
        ArrayList<ArrayList<Integer>> result;

        public Permutation(int n, int r){
            this.n = n;
            this.r = r;
            now = new int[r];
            result = new ArrayList<>();
        }

        public void perm(int[] arr, int depth){
            if(depth == r){
                for(int i = 0; i < now.length; i++){
                    System.out.print(now[i] + " ");
                }
                System.out.println();
                return;
            }
            for(int i = 0; i < n; i++){ //방문 처리 없이 모두 처리한다.
                now[depth] = arr[i];
                perm(arr, depth+1);
            }
        }
    }
```
  
</details>  

<details> <summary> <h1>-모두 출력하는 순열 (동일 수 배제) </h1> </summary>
        
[N과M 3](https://www.acmicpc.net/problem/15651)           

[##_Image|kage@JKOul/btrt0M7qsbk/kddfgxNs0LO7KiBWUkD5zK/img.png|CDM|1.3|{"originWidth":1030,"originHeight":459,"style":"alignCenter"}_##]

```java
static class Permutation{
        int n;
        int r;
        int now[];
        ArrayList<ArrayList<Integer>> result;

        public Permutation(int n, int r){
            this.n = n;
            this.r = r;
            now = new int[r];
            result = new ArrayList<>();
        }

        public void perm(int[] arr, int depth){
            if(depth == r){
                for(int i = 0; i < now.length; i++){
                    System.out.print(now[i] + " ");
                }
                System.out.println();
                return;
            }
            for(int i = 0; i < n; i++){ //방문 처리 없이 모두 처리한다.
                 if(visited[i]) continue;
                 output[depth] = arr.get(i);
                 visited[i] = true;
                 dfs(depth+1);
                 visited[i] = false;
            }
        }
    }

     //변수
    static boolean visited[];
    static ArrayList<Integer> arr = new ArrayList<>();
    static int n,r;

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        visited = new boolean[n];

        for(int i = 1; i <=n; i++){
            arr.add(i);
        }
       Permutation p = new Permutation(n, r);
       p.perm(arr.stream().mapToInt(Integer::intValue).toArray(), 0);
       // Combination comb = new Combination(n, r);
        //comb.comb(arr, 0, 0, 0);

    }
}
```

 </details>                                                     

<details> <summary> <h1>-idx로 진행하는 수열(중복수 허용) </h1> </summary>  
        
[N과M 4](https://www.acmicpc.net/problem/15652)           
 
![image](https://user-images.githubusercontent.com/37995817/155260357-f6ca2059-67a9-4cd1-8c6b-72608aa885af.png)

```java
import java.util.*;

public class Main {

    static class Permutation {
        int n;
        int r;
        int now[];
        ArrayList<ArrayList<Integer>> result;

        public Permutation(int n, int r) {
            this.n = n;
            this.r = r;
            now = new int[r];
            result = new ArrayList<>();
        }

        public void perm(int[] arr, int idx, int depth) {
            if (depth == r) {
                for (int i = 0; i < now.length; i++) {
                    System.out.print(now[i] + " ");
                }
                System.out.println();
                return;
            }
            for (int i = idx; i < n; i++) {
                now[depth] = arr[i];
                perm(arr, i, depth + 1);
            }
        }
    }

    static boolean visited[];
    static ArrayList<Integer> arr = new ArrayList<>();
    static int n, r;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        visited = new boolean[][]{new boolean[n]};

        for (int i = 1; i <= n; i++) {
            arr.add(i);
        }
        Permutation p = new Permutation(n, r);
        p.perm(arr.stream().mapToInt(Integer::intValue).toArray(), 0, 0);
    }
}
```
 
 </details>                                                     
  
---

> 조합

<details> <summary> <h1>-기본 조합 </h1> </summary>   

[N과M 2](https://www.acmicpc.net/problem/15650)             
        

[##_Image|kage@05rcz/btrt6e2TJYE/U4dzQPIMcoUZD3yh3PM2X0/img.png|CDM|1.3|{"originWidth":1052,"originHeight":376,"style":"alignCenter"}_##]

```java
    static class Combination{
        int n;
        int r;
        int[] now;
        ArrayList<ArrayList<Integer>> result;
        
        public Combination(int n, int r){
            this.n = n;
            this.r = r;
            now = new int[r];
            result = new ArrayList<>();
        }
        
        public void comb(ArrayList<Integer> arr, int depth, int target, int idx){
            if(depth == r){
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0; i < now.length; i++){
                    System.out.print(arr.get(now[i]) + " ");
                }
                System.out.println();
                return;
            }
            if(target == n) return;
            now[idx] = target;
            comb(arr,depth+1,target+1,idx+1);
            comb(arr,depth,target+1,idx);
        }
    }

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        
        Combination comb = new Combination(n, r);
        comb.comb(arr, 0, 0, 0);

    }
}
```

</details>
