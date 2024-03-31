package chapter04;

import java.io.*;

public class Problem20_BOJ2751 {
    public static int[] list;
    public static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int size = Integer.parseInt(br.readLine());
        list = new int[size];
        temp = new int[size];
        for (int i = 0; i < size; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        mergeSort(0, size - 1);

        // 출력
        for (int i = 0; i < size; i++) {
            bw.write(list[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }

        int mid = (end + start) / 2;
        mergeSort(start, mid);
        mergeSort(mid + 1, end);

        for (int i = start; i <= end; i++) {
            temp[i] = list[i];
        }

        int a = start;
        int b = mid + 1;
        int i = start;
        while (a <= mid && b <= end) {
            if (temp[a] < temp[b]) {
                list[i] = temp[a];
                a++;
            } else {
                list[i] = temp[b];
                b++;
            }
            i++;
        }

        while (a <= mid) {
            list[i] = temp[a];
            a++;
            i++;
        }

        while (b <= end) {
            list[i] = temp[b];
            b++;
            i++;
        }
    }
}
