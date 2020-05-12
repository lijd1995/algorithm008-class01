import java.util.ArrayList;
import java.util.List;

public class solution {

    List<String> list = new ArrayList<String>();
    public List<String> generateParenthesis(int n) {
        generate(0,0, n,"");
        return list;
    }
    private void generate(int left, int right, int n, String str) {
        if (left == n && right == n){
            list.add(str);
            return;
        }
        if (left < n)
            generate(left+1,right,n,str + "(");
        if (right < left )
            generate(left,right+1,n,str + ")");
    }


}
