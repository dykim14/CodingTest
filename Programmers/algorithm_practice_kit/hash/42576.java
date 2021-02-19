import java.util.*;

class Solution {
    private static final Integer ONE = Integer.valueOf(1);

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        if (participant == null || participant.length <= 0 || participant.length > 100000
                || completion == null || completion.length <= 0
                || participant.length - 1 != completion.length) {
            return answer;
        }
        HashMap<String, Integer> map = new HashMap<>(participant.length);

        for (String p : participant) {
            p = p.toLowerCase();
            if (p.length() >= 20) {
                p = p.substring(0, 20);
            }
            Integer cnt = map.get(p);
            if (cnt != null && cnt.intValue() > 0) {
                cnt = Integer.valueOf(cnt.intValue() + 1);
            } else {
                cnt = ONE;
            }
            map.put(p, cnt);
        }

        for (String c : completion) {
            c = c.toLowerCase();
            if (c.length() > 20) {
                c = c.substring(0, 20);

            }
            Integer cnt = map.get(c);
            if (cnt != null) {
                if (cnt.intValue() > 1) {
                    cnt = Integer.valueOf(cnt.intValue() - 1);
                    map.put(c, cnt);
                } else {
                    map.remove(c);
                }
            }
        }

        Set<String> s = map.keySet();
        answer = (String)s.toArray()[0];
        return answer;
    }
}