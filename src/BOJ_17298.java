import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] input = new int[N];
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        // 풀이
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> index_stack = new Stack<>();
        int[] answer = new int[N];

        int index = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && stack.peek() < input[i]) {
                stack.pop();
                answer[index_stack.pop()] = input[i];
            }

            stack.push(input[i]);
            index_stack.push(index++);
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (answer[i] != 0) {
                sb.append(answer[i]).append(" ");
            } else {
                sb.append("-1 ");
            }
        }

        System.out.println(sb.toString());
        br.close();
    }
}
