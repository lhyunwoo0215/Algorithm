package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가사검색 {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"},
                new String[]{"fro??", "????o", "fr???", "fro???", "pro?"}));
    }
    //트라이로 풀어야함
    static Trie[] TrieRoot = new Trie[10000];
    static Trie[] ReTrieRoot = new Trie[10000];
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];
        int result =0;
        for(String str : words){
            int idx = str.length()-1;
            if(TrieRoot[idx] == null){
                TrieRoot[idx] = new Trie();
                ReTrieRoot[idx] = new Trie();
            }
            TrieRoot[idx].insert(str);
            str = new StringBuilder(str).reverse().toString();
            ReTrieRoot[idx].insert(str);
        }
        for(String str : queries){
            int idx = str.length()-1;
            if(TrieRoot[idx] == null){
                answer[result++]=0;
                continue;
            }
            if(str.charAt(0) != '?'){
                answer[result++] = TrieRoot[idx].search(str);
            }else{
                str = new StringBuilder(str).reverse().toString();
                answer[result++] = ReTrieRoot[idx].search(str);
            }
        }
        return answer;
    }
    static class Trie{
        Trie[] child = new Trie[26];
        int count;

        void insert(String str){
            Trie curr = this;
            for(char ch : str.toCharArray()){
                curr.count++;
                int idx = ch - 'a';
                if(curr.child[idx] == null)
                    curr.child[idx] = new Trie();
                curr = curr.child[idx];
            }
            curr.count++;
        }

        int search(String str){
            Trie curr = this;
            for(char ch : str.toCharArray()){
                if(ch=='?') return curr.count;
                curr = curr.child[ch -'a'];
                if(curr == null)
                    return 0;
            }
            return curr.count;
        }
    }



}
