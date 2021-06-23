package lesson5;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        int sLength = S.length();
        char[] sArray = S.toCharArray();

        int[] A = new int[sLength + 1];
        int[] C = new int[sLength + 1];
        int[] G = new int[sLength + 1];

        for (int i = 0; i < sLength; i++) {
            switch (sArray[i]) {
                case 'A':
                    A[i]++;
                    break;
                case 'C':
                    C[i]++;
                    break;
                case 'G':
                    G[i]++;
                    break;
            }
            A[i+1] = A[i];
            C[i+1] = C[i];
            G[i+1] = G[i];
        }

        for (int i = 0; i < sLength; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < sLength; i++) {
            System.out.print(C[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < sLength; i++) {
            System.out.print(G[i] + " ");
        }
        System.out.println();

        int pLength = P.length;
        int[] answer = new int[pLength];
        for (int i = 0; i < pLength; i++) {
            if (Q[i] == P[i]) {
                switch (sArray[Q[i]]) {
                    case 'A':
                        answer[i] = 1;
                        break;
                    case 'C':
                        answer[i] = 2;
                        break;
                    case 'G':
                        answer[i] = 3;
                        break;
                    case 'T':
                        answer[i] = 4;
                        break;
                }
            } else if (A[Q[i]] - A[P[i]] > 0) {
                answer[i] = 1;
            } else if (C[Q[i]] - C[P[i]] > 0) {
                answer[i] = 2;
            } else if (G[Q[i]] - G[P[i]] > 0) {
                answer[i] = 3;
            } else {
                answer[i] = 4;
            }
            System.out.print(String.valueOf(answer[i]) + " ");
        }

        return answer;
    }
}
