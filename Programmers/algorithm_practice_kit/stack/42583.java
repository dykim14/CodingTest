import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        // 1. 트럭 큐를 만들어 채워줌
        LinkedList<Integer> truckQueue = new LinkedList<>();
        int size = truck_weights.length;
        for (int i = 0; i < size; i++) {
            truckQueue.offer(truck_weights[i]);
        }

        LinkedList<Integer> bridgeQueue = new LinkedList<>();
        int truckOnBridgeWeight = 0;
        int answer = 0;

        while (truckQueue.size() > 0) {
            // 2. 트럭 큐에서 가장 앞에 있는 트럭의 무게를 읽어옴.
            Integer t = truckQueue.peek();

            // 3. 다리 위에 있는 트럭들의 무게와 2번의 트럭 무게의 합을 다리가 견딜 수 있고,
            // 다리가 가득 차있지 않으면 다리 큐에 트럭 무게를 넣어주고 트럭 큐에서 해당 트럭을 꺼냄.
            // 다리가 견딜 수 없을 때까지 2~3번을 계속 반복
            if (truckOnBridgeWeight + t <= weight && bridgeQueue.size() < bridge_length) {
                truckOnBridgeWeight += t;
                bridgeQueue.offer(t);
                truckQueue.poll();
                answer++;
                // System.out.println(truckQueue + " " + bridgeQueue + " " + answer);
            } else {
                // 4. 다리를 건넌 트럭이 있으면 다리 큐의 가장 앞에 있는 트럭을 꺼낸다.
                if (bridgeQueue.size() == bridge_length) {
                    Integer v = bridgeQueue.poll();
                    truckOnBridgeWeight -= v;
                    continue;
                } else {
                    bridgeQueue.offer(0);
                }
                answer++;
                // System.out.println(truckQueue + " " + bridgeQueue + " " + answer);
            }
        }
        // 5. 마지막 트럭이 다리에 막 올라왔을 때 루프가 끝났으므로,
        // 마지막 트럭이 다리를 건너는 횟수만큼 카운트를 늘려준다.
        answer += bridge_length;
        return answer;
    }

}