import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        /**
         1. 많이 재생된 장르
         2. 장르 내에서는 많이 재생된 노래
         3. 재생횟수가 동일하면 고유번호가 낮은 노래

         1. 해쉬맵으로 (장르, 재생횟수) 로 만들고, entrySet 뽑아서 정렬.
         동시에 장르 별 노래 개수도 카운트한다.
         2. 각 장르 별로 (고유번호, 재생횟수) 해쉬맵 만들고, entrySet 뽑아서 정렬.
         3. 각 장르 별로 상위 n곡씩 뽑아서 리턴.
         */
        if (genres == null || genres.length == 0 || plays == null || plays.length == 0) {
            return answer;
        }
        int count = genres.length;
        HashMap<String, Integer> gMap = new HashMap<>();
        HashMap<String, Integer> numMap = new HashMap<>();
        HashMap<String, List<Pair<Integer, Integer>>> songMap = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String g = genres[i];
            gMap.put(g, gMap.getOrDefault(g, 0) + plays[i]);
            List<Pair<Integer, Integer>> l = songMap.getOrDefault(g, new ArrayList<Pair<Integer, Integer>>());
            l.add(new Pair<Integer, Integer>(i, plays[i]));
            songMap.put(g, l);
        }
        ArrayList<Map.Entry<String, Integer>> gList = new ArrayList<>(gMap.entrySet());
        Collections.sort(gList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> v1, Map.Entry<String, Integer> v2) {
                return v2.getValue() - v1.getValue();
            }
        });

        for (Map.Entry<String, Integer> g : gList) {
            List<Pair<Integer, Integer>> l = songMap.get(g.getKey());
            Collections.sort(l, new Comparator<Pair<Integer, Integer>>() {
                @Override
                public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                    if (p1.value != p2.value) {
                        return p2.value - p1.value;
                    }
                    return p2.key - p1.key;
                }
            });
        }

        ArrayList<Integer> ansList = new ArrayList<>();
        for (Map.Entry<String, Integer> g : gList) {
            List<Pair<Integer, Integer>> l = songMap.get(g.getKey());
            int size = Math.min(2, l.size());
            for (int i = 0; i < size; i++) {
                if (l.get(i) != null) {
                    ansList.add(l.get(i).key);
                }
            }
        }
        Integer[] iArr = new Integer[] {};
        iArr = ansList.toArray(iArr);
        answer = Arrays.stream(iArr).mapToInt(Integer::intValue).toArray();
        // System.out.println(gList);
        // System.out.println(songMap);
        return answer;
    }

    class Pair<K, V> {
        K key;
        V value;
        public Pair(K k, V v) {
            key = k;
            value = v;
        }

        @Override
        public String toString() {
            return "[" + key.toString() + ", " + value.toString() + "]";
        }
    }
}