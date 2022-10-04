// import java.util.Scanner;

// public class Calculator {
//     public static void main(String [] args) {
//         Scanner scannerInput = new Scanner(System.in);

//         System.out.println("Please enter your mathematical equation");
//         System.out.println("E.g 12435+34569-12345*10+50");

//         String stringInput = scannerInput.next();

//         String parsedInteger = "";
//         String operator = "";
//         int equals = 0;
//         int i = 0;
//         while (i < stringInput.length()) {
//             var c = stringInput.charAt(i);
//             if (Character.isDigit(c)) {
//                 parsedInteger += c;
//             }
//             if (Character.isDigit(c) && i != stringInput.length() - 1) {
//             } else {
//                 int parsed = Integer.parseInt(parsedInteger);
//                 if (operator == "") {
//                     equals = parsed;
//                 }
//                 else {
//                     switch (operator) {
//                         case "+" -> equals += parsed;
//                         case "-" -> equals -= parsed;
//                         case "*" -> equals *= parsed;
//                         case "/" -> equals /= parsed;
//                     }
//                 }

//                 parsedInteger ="";
//                 operator = ""+c;
//             }
//             i++;
//         }
//         System.out.println("= " + equals);
//     }
// }

import java.util.Stack;
public class Calculator {

    static int orderOfPrecedance(char c){
        switch (c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return -1;
    }

    public static StringBuilder input2Prefix(String infix){
        StringBuilder prefix = new StringBuilder();
        StringBuilder input = new StringBuilder(infix);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char [] expression = new String(input).toCharArray();

        for(int i=0;i<expression.length;i++){
            if(expression[i]=='('){
                expression[i] = ')';
                i++;
            }
            else if(expression[i]==')'){
                expression[i] = '(';
                i++;
            }
        }

        for(int i=0;i<expression.length;i++){
            char c = expression[i];

            if(orderOfPrecedance(c)>0){
                while(stack.isEmpty()==false && orderOfPrecedance(stack.peek())>=orderOfPrecedance(c)){
                    prefix.append(stack.pop());
                }
                stack.push(c);
            }else if(c==')'){
                char x = stack.pop();
                while(x!='('){
                    prefix.append(c);
                    x = stack.pop();
                }
            }
            else if(c == '('){
                stack.push(c);
            }else{
                prefix.append(c);
            }
        }

        for(int i = 0; i < stack.size(); i++){
            prefix.append(stack.pop());
        }
        return prefix.reverse();
    }

    public static void main(String[] args){
        String exp = "12435+34569-12345*10+50";
        System.out.println("Infix Expression: " + exp);
        System.out.println("Prefix Expression: " + input2Prefix(exp));
    }
}