package programmers;

public class 풍선터트리기 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33}));
    }

    public static int solution(int[] a) {
        int answer = 0;

        if(a.length<3){
            return a.length;
        }

        int[]left = new int[a.length];
        int[]right = new int[a.length];
        int min = Integer.MAX_VALUE;

        for(int i =0; i<a.length;i++){
            min = Math.min(min, a[i]);
            left[i] = min;
        }

        min = Integer.MAX_VALUE;
        for(int i =a.length-1; i>=0;i--){
            min = Math.min(min, a[i]);
            right[i] = min;
        }
//        for(int i =0; i<a.length; i++){
//            System.out.println(left[i]+" "+a[i]+" "+right[i]);
//        }

        for(int i =0; i<a.length; i++){
            if(left[i]<a[i] && a[i]>right[i]){
                continue;
            }
            answer++;
        }






        return answer;
    }


}
