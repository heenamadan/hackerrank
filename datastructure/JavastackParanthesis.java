package hackerrank.datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by heena.madan on 01/08/17.
 */
public class JavastackParanthesis {

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String input=sc.next();
            System.out.println(isBalanced(input));
        }

    }

    static boolean isBalanced(String input ){
        Stack<Character> stack = new Stack();
        for(int i=0;i<input.length();i++){
            char ch  = input.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            } else if(stack.isEmpty()){
                return false;

            }else{
                char tos = stack.pop();
                if((tos == '(' && ch != ')') || (tos == '{' && ch != '}') || (tos == '[' && ch != ']')){
                        return false;
                }
            }
        }
        return stack.empty();
    }
}
