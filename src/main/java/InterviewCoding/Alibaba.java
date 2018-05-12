package InterviewCoding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: Evan
 * @Description:
 * @CreateDate: 2018/5/11 19:51
 */
public class Alibaba {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String spareTime = scanner.nextLine();
        scanner.nextLine();
        String actTime = scanner.nextLine();
        String[] split = actTime.split(";");
        HashMap<String,List<String>> map=new HashMap<>();
        for (String string:split){
            String[] split1 = string.split(":");
            String key=split1[0]+split1[2];
            List<String> list;
            if(map.containsKey(key)){
                 list = map.get(key);
            }else list=new ArrayList<>();
            list.add(split1[1]);
            map.put(key,list);
        }

        String[] spareTimes = spareTime.split(";");
        int count=0;
        for (String str:spareTimes){
            count+=getRes(str,map);
        }


    }

    private static double getRes(String str, HashMap<String, List<String>> map) {
        String[] split = str.split(":");
        String key=split[0]+split[2];
        List<String> list = map.get(key);

        for (String time:list){




        }


        return 0;

    }


}
