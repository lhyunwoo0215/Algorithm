package programmers;

import java.util.*;

public class 보석쇼핑 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}));
    }
    public static int[] solution(String[] gems) {
        Set<String> set = new HashSet<>();
        for(String s : gems){
            set.add(s);
        }
        Map<String, Integer> map = new HashMap<>();
        Queue<String> que = new LinkedList<>();
        int idx=0;
        int cnt=0;
        int min = Integer.MAX_VALUE;
        for(int i =0; i<gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i],0)+1);
            que.offer(gems[i]);

            while (!que.isEmpty()){
                String now = que.peek();
                if(map.get(now)>1){
                    que.poll();
                    map.put(now, map.get(now)-1);
                    cnt++;
                }else break;
            }

            if(map.size() == set.size() && min>que.size()){
                min = que.size();
                idx = cnt;
            }

        }
        return new int[]{idx+1, idx+min};
    }
}
