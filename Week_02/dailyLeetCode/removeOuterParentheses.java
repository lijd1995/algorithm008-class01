/**
 * 1021. 删除最外层的括号
 */


/**
 * 思路
 *
 * 1.栈
 * 2.计数器
 */
public class removeOuterParentheses {
    public String removeOuterParentheses(String S) {
        StringBuilder str = new StringBuilder();
        int level = 0;
        for(char c:S.toCharArray()){
            if (c == ')') --level;
            if (c == '(') ++level;
            if (level > 0) str.append(c);
        }
        return str.toString();
    }
}
