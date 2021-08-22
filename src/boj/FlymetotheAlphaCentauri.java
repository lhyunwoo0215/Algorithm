package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class FlymetotheAlphaCentauri {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br = new BufferedReader(new StringReader(src));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int testCase = Integer.parseInt(st.nextToken());
        for (int tc = 0; tc < testCase; tc++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int dist = y - x;
            int max = (int) Math.sqrt(dist); //소수점 없애도 어차피 같음

            if(max == Math.sqrt(dist)){  // 정수
                sb.append(2*max-1+"\n");
            }else if(dist<=(max*max)+max){
                sb.append(2*max+"\n");
            }else{
                sb.append(2*max+1+"\n");
            }
        }
        System.out.println(sb.toString());
    }

    static String src = "3\n" +
            "0 3\n" +
            "1 5\n" +
            "45 50";  //3 3 4
}
