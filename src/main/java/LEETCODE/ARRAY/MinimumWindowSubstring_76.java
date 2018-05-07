package LEETCODE.ARRAY;

/**
 * Created by asus on 2018/1/7.
 */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        char[] array = t.toCharArray();
        int [] flag=new int[256];
        for (char c:array) {
            flag[c]++;
        }
        int leftIndex=0;
        int rightIndex=0;
        String res="";
        int minLen=s.length()+1;
        char[] chars = s.toCharArray();
        int count=t.length();
        while(rightIndex<s.length()){
            if(flag[chars[rightIndex++]]-->0) count--;
            while (count==0){
                if(flag[chars[leftIndex++]]++==0) {
                   int  min=rightIndex-leftIndex-1;
                   if(min<minLen){
                       minLen=min;
                       res=s.substring(leftIndex-1,rightIndex);
                   }
                   count++;
                }
            }
        }
        return res;

    }



}
