import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12891 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());   // 문자열 길이
        int p = Integer.parseInt(st.nextToken());   // 부분 문자열 길이

        String dna = br.readLine();

        int[] requirement = new int[4];
        st = new StringTokenizer(br.readLine());    // dna 최소 개수, (A, C, G, T 순서)
        for (int i = 0; i < 4; i++) {
            requirement[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        int count = 0;  // 만들 수 있는 비밀번호의 종류의 수

        int count_a = 0;
        int count_c = 0;
        int count_g = 0;
        int count_t = 0;

        // 시작 부분문자열의 각 dna 염기 개수 구하기
        for (int i = 0; i < p; i++) {
            if (dna.charAt(i) == 'A') {
                count_a += 1;
            } else if (dna.charAt(i) == 'C') {
                count_c += 1;
            } else if (dna.charAt(i) == 'G') {
                count_g += 1;
            } else {
                count_t += 1;
            }
        }

        int front = 0;
        int back = p-1;

        while (true) {
            // 조건을 만족한다면 개수 +1
            if (count_a >= requirement[0] && count_c >= requirement[1] && count_g >= requirement[2] && count_t >= requirement[3]) {
                count++;
            }

            // 포인터 이동전에 front 문자 개수 빼기
            if (dna.charAt(front) == 'A') {
                count_a -= 1;
            } else if (dna.charAt(front) == 'C') {
                count_c -= 1;
            } else if (dna.charAt(front) == 'G') {
                count_g -= 1;
            } else {
                count_t -= 1;
            }

            // 이동
            front++;
            back++;

            // 범위 밖이라면 멈추기
            if (back >= s) {
                break;
            }

            // 포인터 이동 후에 back 문자 개수 추가
            if (dna.charAt(back) == 'A') {
                count_a += 1;
            } else if (dna.charAt(back) == 'C') {
                count_c += 1;
            } else if (dna.charAt(back) == 'G') {
                count_g += 1;
            } else {
                count_t += 1;
            }
        }

        // 출력
        System.out.println(count);
    }
}
