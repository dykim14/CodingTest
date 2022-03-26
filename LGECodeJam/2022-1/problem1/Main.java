package problem1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        int T, n, L, F;
        String[] word;
        Map<String, Integer> m;
        T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            n = sc.nextInt();
            L = sc.nextInt();
            F = sc.nextInt();
//            System.out.println("n=" + n + " L=" + L + " F=" + F);
            sc.nextLine();

            word = sc.nextLine().split("\\s");
            m = new HashMap<String, Integer>();
            for (int j = 0; j < n; j++) {
//                System.out.println(word[j]);
//                System.out.println(word[j].substring(L - F));
                String w = word[j].substring(L - F);
                m.put(w, m.getOrDefault(w, 0) + 1);
            }

            Collection<Integer> values = m.values();
            int r = 0;
            for (int v : values) {
                r += v / 2;
            }
            System.out.println(r);
        }
    }
}

