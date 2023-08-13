import java.io.*;

public class BOJ11720 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        char[] numbers = br.readLine().toCharArray();

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += Character.getNumericValue(numbers[i]);
        }

        // 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}