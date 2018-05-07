package LEETCODE.SELECT;

/**
 * Created by asus on 2018/1/7.
 */
public class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
       /* Map<Character,Integer> map=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if(!map.containsKey(chars1[i]))
            map.put(chars1[i],1);
            else map.put(chars1[i],map.get(chars1[i])+1);
        }
        for (int i = 0; i < chars2.length; i++) {
            if(!map2.containsKey(chars2[i]))
            map2.put(chars2[i],1);
            else map2.put(chars2[i],map2.get(chars2[i])+1);
        }
        return map.equals(map2);*/

        if(s.length() == 0 && t.length() == 0) return true;
        if(s.length() != t.length()) return false;
        int[] map = new int[256];
        for(char c : s.toCharArray()){
            map[c]++;
        }
        for(char a : t.toCharArray()){
            if(map[a] <= 0) return false;
            map[a]--;
        }
        return true;

    }

}
