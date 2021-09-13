package programmers;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, String> map = new HashMap<>();
        for(int i =0; i<phone_book.length; i++){
            map.put(phone_book[i],".");
        }
        for(int i =0; i<phone_book.length; i++){
            for(int j =1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }

}
