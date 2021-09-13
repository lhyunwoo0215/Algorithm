package programmers;

import java.util.*;

public class 메뉴리뉴얼 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"},
                new int[]{2, 3, 4}));
    }

    static Map<String, Integer> map = new HashMap<>();

    public static String[] solution(String[] orders, int[] course) {

        for (int i = 0; i < orders.length; i++) {
            for (int j = 0; j < course.length; j++) {
                char[] ch = orders[i].toCharArray();
                Arrays.sort(ch);
                if (course[j] <= ch.length) {
                    combination(0,0, ch, course[j], "");
                }
            }
        }

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2)-map.get(o1);
            }
        });

        List<String> result = new ArrayList<>();

        for(int i=0; i< course.length; i++) {
            int max =0;
            for(String s : list) {
                if(s.length() == course[i]) {
                    if(map.get(s) >= max) {
                        result.add(s);
                        max = map.get(s);
                    }
                }
            }
        }

        Collections.sort(result);
        String[] answer = new String[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }


        return answer;
    }

    static void combination(int depth, int start, char[] ch, int size, String menu) {
        if (depth == size) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        } else {
            for(int i = start; i<ch.length; i++){
                combination(depth+1, i+1,ch,size, menu+ch[i]);
            }
        }
    }
}

