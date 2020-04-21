package everyDay;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class firstChar {
    public char firstUniqChar(String s) {
        //    Map<Character,Integer> map = new LinkedHashMap<>();
        //     for(char ch:s.toCharArray()){
        //         Integer value = 0;
        //         if(map.containsKey(ch)){
        //             value = map.get(ch);
        //         }
        //         value++;
        //         map.put(ch,value);
        //     }
        //     Iterator<Map.Entry<Character, Integer>> it = map.entrySet().iterator();
        //     while (it.hasNext()) {
        //         Map.Entry<Character, Integer> entry = it.next();
        //         if (entry.getValue() == 1){
        //             return entry.getKey();
        //         }
        //     }
        //     return ' ';

        /**
         * 使用 Boolean 更节省空间
         */
        Map<Character, Boolean> dic = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            dic.put(c, !dic.containsKey(c));
        }
        for (char c : array) {
            if (dic.get(c)) return c;
        }
        return ' ';

        // ASCII 效率高
        //     char[] chars = new char[26];
        //     char[] chars1 = s.toCharArray();
        //字符字典
        //     for (char c : chars1) {
        //         chars[c - 'a']++;
        //     }
        //按存储顺序遍历，出现次数为1的即为所求
        //     for (char c : chars1) {
        //         if (chars[c-'a']==1) return c;
        //     }
        //     return ' ';
    }
}
