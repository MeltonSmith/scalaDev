package r.ian.algo.easy._682;

import java.util.LinkedList;

/**
 * @author Melton Smith
 * @since 10.08.2025
 */
public class Solution {
    public int calPoints(String[] operations) {
        LinkedList<Integer> list = new LinkedList<>();

        for (String op : operations) {
            switch (op) {
                case "+" -> {
                    var first = list.pollLast();
                    var second = list.peekLast();
                    list.add(first);
                    list.add(first + second);
                }
                case "D" -> list.add(list.peekLast() * 2);
                case "C" -> list.pollLast();
                default -> list.add(Integer.valueOf(op));
            }

        }

        return list.stream().reduce(Integer::sum).orElse(0);
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
