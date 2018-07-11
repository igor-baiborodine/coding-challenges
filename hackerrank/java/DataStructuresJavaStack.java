import java.util.Scanner;
import java.util.Stack;

/**
 * Alternative solution: https://github.com/igor-baiborodine/coding-challenges/blob/master/misc/java/WellFormattedString.java
 */
public class DataStructuresJavaStack {

    public static final void main(String...args) {
        if (args.length == 1 && args[0].equals("no-console")) {
            assert isBalanced("({}[])");
            assert !isBalanced("(({()})))");
            assert isBalanced("({(){}()})()({(){}()})(){()}");
            assert !isBalanced("{}()))(()()({}}{}");
            assert !isBalanced("}}}}");
            assert !isBalanced("))))");
            assert !isBalanced("{{{");
            assert !isBalanced("(((");
            assert isBalanced("[]{}(){()}((())){{{}}}{()()}{{}{}}");
            assert isBalanced("[[]][][]");
            assert !isBalanced("}{");
        } else {
            Scanner sc = new Scanner(System.in);

            while (sc.hasNext()) {
                String input = sc.next();
                System.out.println(isBalanced(input));
            }
            sc.close();
        }
    }

    private static boolean isBalanced(String s) {
        Stack<String> closingSquareBrackets = new Stack<>();
        Stack<String> closingCurlyBraces = new Stack<>();
        Stack<String> closingParentheses = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            switch (String.valueOf(s.charAt(i))) {
                case "[":
                    closingSquareBrackets.push("]");
                    break;
                case "]":
                    if (closingSquareBrackets.empty()) {
                        return false;
                    }
                    closingSquareBrackets.pop();
                    break;
                case "{":
                    closingCurlyBraces.push("}");
                    break;
                case "}":
                    if (closingCurlyBraces.empty()) {
                        return false;
                    }
                    closingCurlyBraces.pop();
                    break;
                case "(":
                    closingParentheses.push(")");
                    break;
                case ")":
                    if (closingParentheses.empty()) {
                        return false;
                    }
                    closingParentheses.pop();
                    break;
                default:
                    // do nothing
            }
        }
        return closingSquareBrackets.empty()
                && closingCurlyBraces.empty()
                && closingParentheses.empty();
    }

}
