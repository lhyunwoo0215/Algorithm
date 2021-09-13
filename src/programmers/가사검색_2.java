package programmers;

import java.util.HashMap;
import java.util.Map;

public class 가사검색_2 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}));
    }
    //트라이로 풀어야함
    public static int[] solution(String[] words, String[] queries) {
        Trie[] trie = new Trie[100001];                     //100000개의 길이를 갖을 수 있기 때문에
        for(int i = 0; i < words.length; i++) {
            int wordLen = words[i].length();
            if(trie[wordLen] == null) {
                trie[wordLen] = new Trie();
            }
            trie[wordLen].insert(words[i]);
        }
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++) {
            int queryLen  = queries[i].length();
            if(trie[queryLen] == null) {
                answer[i] =0;
                continue;
            }
            answer[i] = trie[queryLen].getCount(queries[i]);
        }
        for(int i =0; i<answer.length; i++){
            System.out.println(answer[i]);
        }

        return answer;
    }
    static class Trie{
        TrieNode forward;
        TrieNode back;

        Trie(){
            forward = new TrieNode();
            back = new TrieNode();
        }

        public void insert(String words) {
            insertBack(words);
            insertForward(words);
        }

        private void insertBack(String words) {
            TrieNode node = back;
            for(int i = words.length() - 1; i >= 0; i--) {
                node.count++;
                if(!node.childNodes.containsKey(words.charAt(i))){
                    node.childNodes.put(words.charAt(i), new TrieNode());
                    System.out.println("back : "+node);
                }
                node = node.childNodes.get(words.charAt(i));
            }
        }
        private void insertForward(String words) {
            TrieNode node = forward;
            for(int i = 0 ; i <  words.length(); i++) {
                node.count++;
                if(!node.childNodes.containsKey(words.charAt(i))){
                    node.childNodes.put(words.charAt(i), new TrieNode());
                    System.out.println("forwkd : "+node);
                }
                node = node.childNodes.get(words.charAt(i));
            }
        }

        public int getCount(String query) {
            if(query.charAt(0) == '?') {        //접두사
                return getCountBack(query);
            }
            return getCountForward(query);
        }

        private int getCountBack(String query) {
            TrieNode node = back;
            for(int i = query.length() - 1; i >= 0 ; i--) {
                if(query.charAt(i) =='?') {
                    return node.count;
                }
                if(!node.childNodes.containsKey(query.charAt(i))) {
                    return 0;
                }
                node = node.childNodes.get(query.charAt(i));
            }
            return node.count;
        }

        private int getCountForward(String query) {
            TrieNode node = forward;
            for(int i = 0; i < query.length(); i++ ){
                if(query.charAt(i) =='?') {
                    return node.count;
                }
                if(!node.childNodes.containsKey(query.charAt(i))) {
                    return 0;
                }
                node = node.childNodes.get(query.charAt(i));
            }
            return node.count;
        }



    }

    static class TrieNode{
        int count;
        Map<Character, TrieNode> childNodes;

        public TrieNode() {
            count = 0;
            childNodes = new HashMap<Character, TrieNode>();
        }

        @Override
        public String toString() {
            return "TrieNode{" +
                    "count=" + count +
                    ", childNodes=" + childNodes +
                    '}';
        }
    }

}
