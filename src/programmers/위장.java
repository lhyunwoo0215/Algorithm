package programmers;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        System.out.println(solution(new String[][]{{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"},{"green_turban", "headgear"}}));
    }
    public static int solution(String[][] clothes) {
        Map<String, Integer>map = new HashMap<>();
        for(int i =0; i<clothes.length;i++){
            if(map.containsKey(clothes[i][1]))
                map.put(clothes[i][1], map.getOrDefault(clothes[i][1],0)+1);
            else map.put(clothes[i][1], 1);
        }
        int answer = 1;
        for(int value : map.values()){
            answer *= (value+1);
        }
        return answer-1;
    }
}
