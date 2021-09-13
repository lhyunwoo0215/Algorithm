package programmers;

import java.util.HashMap;
import java.util.Map;

public class 다단계칫솔판매 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}));
    }
    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> member = new HashMap<>();
        Map<String , Integer> index = new HashMap<>();
        for(int i =0; i<enroll.length; i++){
            member.put(enroll[i], referral[i]);
            index.put(enroll[i], i);
        }
        for(int i =0; i<seller.length; i++){
            String now = seller[i];
            int money = amount[i] * 100;
            while (!now.equals("-")){
                int send = money / 10;
                int mine = money - send;
                answer[index.get(now)] += mine;
                now = member.get(now);
                money /= 10;
                if(money<1) break;
            }
        }
        return answer;
    }

}
