package programmers;

import java.util.HashMap;

public class 매칭점수 {
    public static void main(String[] args) {
        System.out.println(solution("blind", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"}));
    }
    public static int solution(String word, String[] pages) {
        //기본점수, 외부링크 수, 링크점수, 매칭점수
        //검색어등장횟수, 다른페이지 연결 링크 수, 기본점수/외부링크수 총합, 기본점수+링크점수
        int answer = 0;
        HashMap<String,Integer> page = new HashMap<>();
        String[][] pageLink = new String[pages.length][];
        int[] pageScore = new int[pages.length];
        for(int i = 0; i < pages.length; i++) {
            page.put(getPageName(pages[i]),i);
            pageLink[i] = getLink(pages[i]);
            String[] c = pages[i].split("[^a-zA-Z']+");
            for(int j = 0; j < c.length; j++) {
                if(c[j].toLowerCase().equals(word.toLowerCase())) pageScore[i]++;
            }
        }
        double[] score = new double[pages.length];
        for(int i = 0; i < pageLink.length; i++) {
            for(int j = 0; j < pageLink[i].length; j++) {
                if(page.containsKey(pageLink[i][j])) {
                    score[page.get(pageLink[i][j])] += (double) pageScore[i] / pageLink[i].length;
                }
            }
            score[i] += pageScore[i];
        }
        for(int i = 0; i < score.length; i++) {
            if(score[answer] < score[i]) answer = i;
        }
        return answer;
    }
    private static String[] getLink(String page) {
        String[] a = page.split("<a href=\"");
        String[] b = new String[a.length - 1];
        for(int j = 1; j < a.length; j++) {
            b[j-1] = a[j].split("\">")[0];  //주소만 뽑기
        }
        return b;
    }

    private static String getPageName(String page) {
        String a = page.split("<head>|</head>")[1];
        String b = a.split("<meta property=\"og:url\" content=")[1];  // 주소만 뽑기
        System.out.println(b);
        System.out.println(b.split("\"")[1]);
        return b.split("\"")[1];
    }
}
