import java.util.*;

class Solution {
    int answer;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesMap = new HashMap<>();
        for (String[] c : clothes) {
            clothesMap.put(c[1], clothesMap.getOrDefault(c[1], 0) + 1);
        }

        answer = clothesMap.isEmpty() ? 0 : 1;
        clothesMap.forEach((K, V) -> {
            answer *= (V + 1);
        });

        return answer - 1;
    }
}