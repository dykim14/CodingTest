package algorithm_practice_kit.hash;

import java.util.*;

public class Solution_42577 {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        int size = phone_book.length;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                int prefixSize = phone_book[i].length();
                if (prefixSize >= phone_book[j].length()) {
                    continue;
                }

                String prefix = phone_book[i];
                String target = phone_book[j];
                if (target.startsWith(prefix)) {
                    // System.out.println(prefix + " " + target);
                    return false;
                }
            }
        }

        return true;
    }
}