package 递归;

import java.util.List;

/**
 * 括号生成
 *
 * 思路，先生成全部括号
 */

public class generateParenthesis {
    public static List<String> generateParenthesis(int n) {

        generate(0,0, n,"");
        return null;
    }

    private static void generate(int left, int right, int n, String str) {
        // 终结条件
        if (left == n && right == n){
            System.out.println(str);
            return;
        }
        // 处理当前层,加左括号或者右括号
        String s1 = str + "(";
        String s2 = str + ")";
        // 进入下一层
        if (left < n)
            generate(left+1,right,n,str + "(");
        if (right < left )
            generate(left,right+1,n,str + ")");
        // 清理当前层
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

}
