import java.util.*;

public class 섹션_랜덤_배정 {
    static String[] people = new String[]{"정진택", "김동인", "이시웅", "장진영", "신영서"};

    public static void main(String[] args) {
        // 초기화
        List<String> peopleList = new ArrayList<>(Arrays.asList(people));

        // 랜덤 실행
        Collections.shuffle(peopleList);

        // 결과 출력
        for (int i = 0; i < 5; i++) {
            System.out.println(peopleList.get(i));
        }
    }
}
