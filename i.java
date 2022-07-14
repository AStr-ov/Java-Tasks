import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class i {
    public static void main(String[] args) {
        var d = "( 2 ^ 3 * ( 10 / ( 5 - 3 ) ) ) ^ ( sin ( Pi ) )"; 
        var e = d.split(" ");   //2 3 ^ 10 5 3 - / * Pi sin ^
        Stack act_stack = new Stack<>();
        String postfix = "";
        Map<String, Integer> prior = new HashMap<>();
        prior.put("(", 1);
        prior.put("+", 2);
        prior.put("-", 2);
        prior.put("*", 3);
        prior.put("/", 3);
        prior.put("^", 4);
        prior.put("sqrt", 4);
        prior.put("sin", 5);
        prior.put("cos", 5);
        prior.put("tg", 5);        

        for (int i = 0; i < e.length; i++) {
            var top = e[i];
            char c = top.charAt(0);
            
            if (Character.isDigit(c) || top.equals("Pi")) {
                postfix += top + " ";
            } else {
                if (act_stack.empty() && prior.get(top) > 0 || top.equals("(")) { //
                    act_stack.push(top); // prior.get(act_stack.peek()) < 2
                } else if (top.equals(")")) {
                    while (!act_stack.peek().equals("(")) {
                        postfix += act_stack.pop() + " ";
                    }
                    act_stack.pop();
                } else {
                    while (!act_stack.empty() && prior.get(act_stack.peek()) >= prior.get(top)) {
                        postfix += act_stack.pop() + " ";
                    }
                    act_stack.push(top);
                }
            }
        }
        while (!act_stack.empty()) {
            postfix += act_stack.pop() + " ";
        }
        System.out.println(postfix);
    }
}
