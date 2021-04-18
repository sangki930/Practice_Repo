package Programmers.KaKaoBLIND2018.자동완성;

class Node{
    Node[] arr;
    int cnt;
    public Node(){
        this.arr = new Node[26];
    }
}

class Trie{
    Node root;
    Trie(){
        this.root = new Node();
    }
    public void insert(String s){
        Node tmp = root;
        root.cnt++;
        for(int i=0;i<s.length();i++){
            if(tmp.arr[s.charAt(i)-'a']==null){
                tmp.arr[s.charAt(i)-'a'] = new Node();
                tmp = tmp.arr[s.charAt(i)-'a'];
                tmp.cnt=1;
            }else{
                tmp =tmp.arr[s.charAt(i)-'a'];
                tmp.cnt++;
            }
        }
    }
    
    public int find(String s){
        Node tmp = root;
        for(int i=0;i<s.length();i++){
            if(tmp.cnt==1)
                return i;
            else
                tmp = tmp.arr[s.charAt(i)-'a'];
        }
        return s.length();
    }
    
}

public class Solution {
    public int solution(String[] words) {
        int answer = 0;
        
        Trie trie = new Trie();
        
        for(String s : words){
            trie.insert(s);
        }
        
        for(int i=0;i<words.length;i++){
            answer+=trie.find(words[i]);
        }
        
        return answer;
    }
}