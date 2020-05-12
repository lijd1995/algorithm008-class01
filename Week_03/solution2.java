import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class solution2 {


    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        // 定义一个hashMap
        HashMap<Character,String> map = new HashMap();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        // 递归
        generate(0,list,map,digits,"");
        return list;
    }

    private static void generate(int level, List<String> list, HashMap<Character, String> map, String digits, String str) {
        // ternimal
        if (level == digits.length() && str.length() == digits.length()){
            list.add(str);
            return;
        }
        // process current logic
        String value = map.get(digits.charAt(level));
        // drill down
        for (int i=0;i<value.length();i++)
            generate(level+1,list,map,digits,str+value.charAt(i));
        // restore current status
    }

    public static void main(String[] args) {
        letterCombinations("23");
    }
}
