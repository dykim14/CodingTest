package lesson5;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int sLength = S.length();
        char[] sArray = S.toCharArray();

        int[] A = new int[sLength + 1];
        int[] C = new int[sLength + 1];
        int[] G = new int[sLength + 1];

        for (int i = 0; i < sLength; i++) {
            A[i+1] = A[i];
            C[i+1] = C[i];
            G[i+1] = G[i];
            switch (sArray[i]) {
                case 'A':
                    A[i+1]++;
                    break;
                case 'C':
                    C[i+1]++;
                    break;
                case 'G':
                    G[i+1]++;
                    break;
            }

        }

        for (int i = 0; i < sLength + 1; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < sLength + 1; i++) {
            System.out.print(C[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < sLength + 1; i++) {
            System.out.print(G[i] + " ");
        }
        System.out.println();

        int pLength = P.length;
        int[] answer = new int[pLength];
        for (int i = 0; i < pLength; i++) {
            if (A[Q[i] + 1] - A[P[i]] > 0) {
                answer[i] = 1;
            } else if (C[Q[i] + 1] - C[P[i]] > 0) {
                answer[i] = 2;
            } else if (G[Q[i] + 1] - G[P[i]] > 0) {
                answer[i] = 3;
            } else {
                answer[i] = 4;
            }
            System.out.print(String.valueOf(answer[i]) + " ");
        }

        return answer;
    }
}
