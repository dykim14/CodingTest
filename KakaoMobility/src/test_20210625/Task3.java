package test_20210625;

import java.util.*;

public class Task3 {

    public static void main(String[] args) {
        int[][] As = {
                {3, 4, 5, 3, 7},
                {1, 2, 3, 4},
                {1, 3, 5, 3},
                {1, 3, 2, 4}
        };
        Task3 task3 = new Task3();

        for (int[] A : As) {
            System.out.println(Arrays.toString(A) + " = " + task3.solution(A));
        }
    }

    public int solution(int[] A) {
        int N = A.length;
        if (N == 0) {
            return 0;
        }

        ArrayList<Integer> list = new ArrayList<Integer>(N);
        for (int i : A) {
            list.add(i);
        }

        int cnt = 0;
        if (isAesthetic(list, -1)) {
            return 0;
        }

        for (int i = 0; i < N; i++) {
            if (isAesthetic(list, i)) {
                cnt++;
            }
        }
        if (cnt == 0) {
            cnt = -1;
        }
        return cnt;
    }

    private boolean isAesthetic(List<Integer> list, int skipIndex) {
        List<Integer> skippedList = new ArrayList<>(list);
        if (skipIndex != -1) {
            skippedList.remove(skipIndex);
        }
        int N = skippedList.size();
        int prev = skippedList.get(1).compareTo(skippedList.get(0));
        for (int i = 2; i < N; i++) {
            int current = skippedList.get(i).compareTo(skippedList.get(i-1));
            if (prev != current && prev != 0 && current != 0) {
                prev = current;
            } else {
                return false;
            }
        }
        return true;
    }
}
