package com.evan.CSP.CCF_201709;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by asus on 2018/3/7.
 */
public class JSONsearch {
    private static Map<String,String> map;
    private static int index=0;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int lines = scanner.nextInt();
        int questions = scanner.nextInt();
        map=new HashMap<>();

        StringBuffer stringBuffer=new StringBuffer();
        scanner.nextLine();
        for (int i = 0; i < lines; i++) {
            stringBuffer.append(scanner.nextLine());
        }
        String string = stringBuffer.toString();
        String s1 = string.replaceAll(" ", "");
        String s2 = s1.replaceAll("\\\\\\\\", "\\\\");
        String s3 = s2.replaceAll("\\\\\\\"", "\\\"");
        parse(s3,"");
        for (int i = 0; i < questions; i++) {
            String next = scanner.next();
            if( !map.containsKey(next)) System.out.println("NOTEXIST");
            else {
                String s = map.get(next);
                if(s.equals("")) System.out.println("OBJECT");
                else System.out.println("STRING "+s);
            }

        }
    }

    private static void parse(String string,String pre) {
        String key="",value="";
        int endIndex;
        boolean havaKey=false;
        while (index<string.length()){
            char c = string.charAt(index);
            if(c=='"'){
                if(havaKey) {
                    int a1=string.indexOf('}', index);
                    int a2=string.indexOf(',', index);
                    endIndex =a1<a2||a2==-1?a1:a2;
                    value=string.substring(index,endIndex);
                    map.put(key,value.substring(1,value.length()-1));
                    havaKey=false;
                    index=endIndex;
                }else {
                    endIndex = string.indexOf(':', index);
                    key=string.substring(index,endIndex);
                    key=pre+(pre.equals("")?"":".")+key.substring(1,key.length()-1);
                    havaKey=true;
                    index=endIndex;
                }
            }else if(c=='{'){
                map.put(key,"");
                havaKey=false;
                index++;
                parse(string,key);
            }else if(c=='}'){
                index++;
                break;
            }else index++;

        }

    }



}
