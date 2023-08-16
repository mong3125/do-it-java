import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 재료의 개수
        int M = Integer.parseInt(br.readLine());    // 갑옷을 만드는데 필요한 수

        int[] armorIds = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            armorIds[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(armorIds);

        int front = 0;
        int back = N - 1;
        int count = 0;      // 정답
        while (front < back) {
            int sum = armorIds[front] + armorIds[back];
            if (sum == M) {
                count++;
                front++; back--;
            } else if (sum < M) {
                front++;
            } else {
                back--;
            }
        }

        System.out.println(count);
    }
}
