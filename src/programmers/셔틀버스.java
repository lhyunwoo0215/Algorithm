package programmers;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class 셔틀버스 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
    }

    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        //09:00 부터 2회 10분간격 2명 탈 수 있음
        //대기열 순서대로 태우고 출발 , 09:00에 자라기 있다면 09:00에 줄서도 탈 수 있음
        //가장 늦은 시각 구하기
        //제일 뒤에 선다, 23:59분에는 집에 감. 다음날 셔틀 안탐

        //버스 운영 횟수
        List<Integer>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        //분으로 만들기, 순서 정렬
        for (int i = 0; i < timetable.length; i++) {
            String[] times = timetable[i].split(":");
            int hour = Integer.parseInt(times[0]);
            int minute = Integer.parseInt(times[1]);
            int time = (hour * 60) + minute;
            pq.add(time);
        }
        //버스출발
        int busStart = 9 * 60;
        //나
        int me = 0;
        //버스당 크루원
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty()) {
                int crew = pq.poll();
                if (crew <= busStart && list[i].size() < m) {  //m인원만큼 들어가야함
                    list[i].add(crew); //인원채우기
                } else {
                    pq.offer(crew); // 지금 버스 못타면 다시 저장
                    break;
                }
                me = crew - 1;
            }
            busStart += t; //다음 버스 시간 저장
        }
        if(list[n-1].size()<m){
            me = busStart-t;
        }
        answer = timeChange(me);
        return answer;
    }

    static String timeChange(int time) {
        String h = Integer.toString(time / 60);
        String m = Integer.toString(time % 60);
        h = h.length() < 2 ? "0" + h : h;
        m = m.length() < 2 ? "0" + m : m;
        return h+":"+m;
    }
}
