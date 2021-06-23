package lesson2;

import java.util.Arrays;

public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        int length = A.length;
        int rotateN = length <= 0 ? 0 : K % length;

        int[] solution;
        if (rotateN == 0) {
            solution = A;
        } else {
            solution = new int[length];
            System.arraycopy(A, length - rotateN, solution, 0, rotateN);
            // System.out.println(Arrays.toString(solution));
            System.arraycopy(A, 0, solution, rotateN, length - rotateN);
            // System.out.println(Arrays.toString(solution));
        }
        return solution;
    }
}
