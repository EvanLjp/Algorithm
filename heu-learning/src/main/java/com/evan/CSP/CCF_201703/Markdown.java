package com.evan.CSP.CCF_201703;


import java.util.Scanner;


/**
 * Created by asus on 2018/3/9.
 */
public class Markdown {
   static boolean hasP=false;
   static boolean hasUL=false;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        StringBuffer stringBuffer=new StringBuffer();
        String line=null;
        String pre="";

        String[] arr=new String[102];
        int index=0;
        while (scanner.hasNext()){
            arr[index++]=scanner.nextLine();
        }
        index=0;
        while (arr[index]!=null){
            line=arr[index];
            if(!line.equals("")){
                if(!hasUL&&line.charAt(0)=='*') {
                    stringBuffer.append("<ul>\n");
                    hasUL=true;
                }
                stringBuffer.append(convertLine(line));

                if(hasP&&(arr[index+1]==null||arr[index+1].equals(""))){
                    stringBuffer.append("</p>\n");
                    hasP=false;
                }else{
                    stringBuffer.append("\n");
                }
                if(hasUL&&(arr[index+1]==null||arr[index+1].equals(""))){
                    stringBuffer.append("</ul>\n");
                    hasUL=false;
                }
            }else {
                if(hasP){
                    stringBuffer.append("</p>");
                    hasP=false;
                }
            }
            index++;
        }
        String string = stringBuffer.toString();
        System.out.println(string);
    }

    private static String convertLine(String line) {
        switch (line.charAt(0)){
            case '#':
                int count=0;
                for (int i = 0; i < line.length()&&line.charAt(i)=='#'; i++) {
                    count++;
                }
               String details=getLineDetails(line.substring(count));
                return "<h"+count+">"+details+"</h"+count+">";

            case '*':
                String trim = line.substring(1).trim();
                return "<li>"+ getLineDetails(trim)+"</li>";
            default:
                if(!hasP) {
                    hasP=true;
                    return "<p>"+getLineDetails(line);
                }
                else return getLineDetails(line);





        }




    }

    private static String getLineDetails(String substring) {
        String realString = substring.trim();
        StringBuffer stringBuffer=new StringBuffer();
        boolean hasEm=false;
        StringBuffer content=new StringBuffer();
        StringBuffer url=new StringBuffer();

        for (int i = 0; i < realString.length(); i++) {
            if(realString.charAt(i)=='_'){
                if(hasEm) {
                    stringBuffer.append("</em>");
                    hasEm=false;
                }
                else {
                    stringBuffer.append("<em>");
                    hasEm=true;
                }
            }else if(realString.charAt(i)=='['){
                i++;
                while (realString.charAt(i)!=']'){
                    if(realString.charAt(i)=='_'&&!hasEm){
                        content.append("<em>");
                        hasEm=true;
                        i++;
                    }else if (realString.charAt(i)=='_'&&hasEm){
                        content.append("</em>");
                        hasEm=false;
                        i++;
                    }else content.append(realString.charAt(i++));
                }
                i+=2;
                while (realString.charAt(i)!=')'){
                    url.append(realString.charAt(i++));
                }
                stringBuffer.append("<a href=\""+url.toString()+"\">"+content.toString()+"</a>");
                url.setLength(0);
                content.setLength(0);
            }else stringBuffer.append(realString.charAt(i));
        }
        return stringBuffer.toString();

    }
}

