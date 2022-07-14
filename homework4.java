import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class homework4 {
    public static String ToPost(String a) {
        var e = a.split(" ");
        Stack act_stack = new Stack<>();
        String post = "";
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
                post += top + " ";
            } else {
                if (act_stack.empty() && prior.get(top) > 0 || top.equals("(")) { //
                    act_stack.push(top); 
                } else if (top.equals(")")) {
                    while (!act_stack.peek().equals("(")) {
                        post += act_stack.pop() + " ";
                    }
                    act_stack.pop();
                } else {
                    while (!act_stack.empty() && prior.get(act_stack.peek()) >= prior.get(top)) {
                        post += act_stack.pop() + " ";
                    }
                    act_stack.push(top);
                }
            }
        }
        while (!act_stack.empty()) {
            post += act_stack.pop() + " ";
        }
        System.out.println(post);
        return post;
    }

    public static void Calc(String a) {
        var b = a.split(" ");
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < b.length; i++) {
            var e = b[i];
            Double num1;
            Double num2;

            if (e.equals("Pi")) {
                stack.push((Math.PI));
            }
            else if (Character.isDigit(e.charAt(0))) {
                stack.push(Double.parseDouble(e));
            }
            else {
                num1 = stack.pop();
                num2 = stack.pop();
                switch (e) {                    
                    case "+": num2 += num1;                        
                        break;
                    case "-": num2 -= num1;                        
                        break;
                    case "*": num2 *= num1;                        
                        break;
                    case "/": num2 /= num1;                        
                        break;
                    case "^": num2 = Math.pow(num2, num1) ;                        
                        break;
                    case "sin": stack.push((double) Math.round(Math.sin(Math.toRadians(num2))) ) ; 
                        break;
                    case "cos": stack.push((double) Math.cos(Math.toRadians(num2))); 
                        break;
                }
                stack.push(num2);
            }
        }
        System.out.println(stack);
    }
    public static void main(String[] args) {
        String infix = "( 2 ^ 3 * ( 10 / ( 5 - 3 ) ) ) ^ ( sin ( Pi ) )";
        String postfix = ToPost(infix);
        Calc(postfix);
    }
}
