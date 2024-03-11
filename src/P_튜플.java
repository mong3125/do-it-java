import java.util.ArrayList;
import java.util.Comparator;

public class P_튜플 {
}

class Solution {
    public int[] solution(String s) {
        s = s.substring(1, s.length() - 1);
        boolean bracket = false;

        Nodes nodes = new Nodes();

        int number = 0;
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (now == '{') {
                bracket = true;
                continue;
            } else if (now == '}') {
                bracket = false;
                continue;
            }

            if (bracket) {
                if (now != ',') {
                    number *= 10;
                    number += Character.getNumericValue(now);
                } else {
                    Node node = nodes.getNode(number);
                    if (node == null) nodes.putNode(number);
                    else node.plusCount();
                }
            }
        }
        nodes.sort();


        int[] answer = new int[nodes.nodeList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = nodes.nodeList.get(i).id;
        }
        return answer;
    }
}

class Nodes {
    ArrayList<Node> nodeList = new ArrayList<>();

    public Node getNode(int id) {
        for (Node node : nodeList) {
            if (node.id == id) {
                return node;
            }
        }

        return null;
    }

    public void putNode(int id) {
        this.nodeList.add(new Node(id));
    }

    public void sort() {
        nodeList.sort(new Comparator<>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });
    }
}

class Node {
    int id;
    int count = 1;

    public void plusCount() {
        this.count++;
    }

    public Node(int id) {
        this.id = id;
    }
}