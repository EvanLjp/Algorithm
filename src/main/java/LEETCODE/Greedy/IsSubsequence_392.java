package LEETCODE.Greedy;

/**
 * Created by asus on 2018/2/25.
 */
public class IsSubsequence_392 {
    public boolean isSubsequence(String s, String t) {
        if(s==null||t==null) return false;
        if(s.equals("")) return true;
        int index=0;
        for (int i = 0; i < t.length(); i++) {
            if(s.charAt(index)==t.charAt(i)){
                index++;
                if(index==s.length()) return true;
            }
        }
        return false;
    }




}
