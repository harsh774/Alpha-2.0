package DSA;

import java.util.*;

class contest {
    public static List<String> permutations(String str, String res){
        List<String> ll = new ArrayList<>();
        if(str.length()==0){
            ll.add(res);
            return ll;
        }
        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String newStr = str.substring(0,i)+str.substring(i+1);
            permutations(newStr,res+curr);
        }
        return ll;
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<String> ll = permutations(p,"");
        List<Integer> ans = new ArrayList<>();
        int len = p.length();        
        for(int i=0; i<s.length()-p.length(); i++){
            String str = s.substring(i,i+len);
            for (String item : ll) {
                if(item.contains(str)){
                    ans.add(i);
                }                
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String q = "abc";
        System.out.println(findAnagrams(s,q));
    }
}