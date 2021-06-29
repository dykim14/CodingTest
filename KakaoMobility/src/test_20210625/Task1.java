package test_20210625;

import java.util.*;

public class Task1 {
    public static final String NO_CONTACT = "NO CONTACT";

    public String solution(String[] A, String[] B, String P) {
        if (A == null || B == null || P == null || P.isEmpty()) {
            return NO_CONTACT;
        }
        int N = A.length;
        TreeSet<String> match = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            if (B[i].contains(P)) {
                match.add(A[i]);
            }
        }
        // System.out.println(match);

        String result = NO_CONTACT;
        if (!match.isEmpty()) {
            result = match.first();
        }
        return result;
    }
}
