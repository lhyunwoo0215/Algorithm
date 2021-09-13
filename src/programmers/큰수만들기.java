package programmers;

public class 큰수만들기 {
    public static void main(String[] args) {
        System.out.println(solution("1231234",3));
    }
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;

        for (int i = 0; i < number.length()-k; i++) {
            int num=0;
            for(int j=idx;j<=i+k;j++){
                if(num<number.charAt(j)-'0'){
                    num = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(num);
        }


        return answer.toString();
    }
}
