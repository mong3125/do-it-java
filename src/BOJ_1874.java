import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1874 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        // 풀이
        Stack<Integer> stack = new Stack<>();       // stack으로 과정을 수행해보기 위함
        StringBuilder sb = new StringBuilder();     // 결과 출력을 위한 StringBuilder
        int idx = 1;
        for (int i = 0; i < n; i++) {
            while (stack.isEmpty() || stack.peek() < nums[i]) { // 비어있거나 stack의 top이 차례보다 작으면 계속 stack에 숫자를 주입한다.
                stack.push(idx++);
                sb.append("+\n");
            }

            if (stack.peek() == nums[i]) {  // top이 해당 숫자라면 pop 한다.
                stack.pop();
                sb.append("-\n");
            } else {    // 아니라면 stack 내부에 숫자가 존재하고 이를 먼저 꺼내는 방법이 없으니 stack으로 해당 순열을 만들 수 없다.
                break;
            }
        }

        // 출력
        if (stack.isEmpty()) {
            System.out.println(sb.toString());
        } else {
            System.out.println("NO");
        }
    }
}
