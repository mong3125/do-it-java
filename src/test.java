import java.util.HashMap;

public class test {
    public static void main(String[] args) {

    }

    private static void solution(String str1, String str2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        split(str1, map1);

        HashMap<String, Integer> map2 = new HashMap<>();
        split(str2, map2);

        int union = 0;
        int intersection = 0;

        for (String key : map1.keySet()) {
            int map1Count = map1.get(key);
            int map2Count = map2.getOrDefault(key, 0);

            intersection += Math.min(map2Count, map1Count);
            union += Math.max(map2Count, map1Count);
        }

        for (String key : map2.keySet()) {
            if (!map1.containsKey(key)) {
                union += map2.get(key);
            }
        }

        System.out.println(65536 / union * intersection);
    }

    public static void split(String str, HashMap<String, Integer> map) {
        for (int i = 0; i < str.length() - 1; i++) {
            String subStr = str.substring(i, i + 2).toLowerCase();
            if (isAlphabetic(subStr)) {
                map.put(subStr, map.getOrDefault(subStr, 0) + 1);
            }
        }
    }

    public static boolean isAlphabetic(String str) {
        return str.matches("[a-zA-Z]+");
    }
}
