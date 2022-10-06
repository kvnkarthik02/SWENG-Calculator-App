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

/*
import java.util.Scanner;
import java.util.Stack;


public class Calculator {

    static int orderOfPrecedance(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
        }
        return 0;
    }
 
    public static StringBuilder input2Prefix(String infix) {
        StringBuilder prefix = new StringBuilder();
        StringBuilder input = new StringBuilder(infix);
        input.reverse();
        Stack<Character> stack = new Stack<Character>();

        char[] expression = new String(input).toCharArray();

        for (int i = 0; i < expression.length; i++) {
            if (expression[i] == '(') {
                expression[i] = ')';
                i++;
            } else if (expression[i] == ')') {
                expression[i] = '(';
                i++;
            }
        }
 
        for (int i = 0; i < expression.length; i++) {
            char c = expression[i];

            if (orderOfPrecedance(c) > 0) {
                while (stack.isEmpty() == false && orderOfPrecedance(stack.peek()) >= orderOfPrecedance(c)) {
                    prefix.append(stack.pop());
                }
                stack.push(c);
            } else if (c == ')') {
                char x = stack.pop();
                while (x != '(') {
                    prefix.append(c);
                    x = stack.pop();
                }
            } else if (c == '(') {
                stack.push(c);
            } else {
                prefix.append(c);
            }
        }
 
        for (int i = 0; i < stack.size(); i++) {
            prefix.append(stack.pop());
        }
        return prefix.reverse();
    }

    public static boolean validateInput(String input) {
        char[] expression = new String(input).toCharArray();
        Boolean bool = false;
        int i = 0;
        while (i < expression.length) {
            if ((expression[i] >= '0' && expression[i] <= '9')
                    || (expression[i] == '+' || expression[i] == '-' || expression[i] == '/' || expression[i] == '*')) {
                bool = true;
                i++;
            } else {
                bool = false;
                i++;
            }
        }
        return bool;
    }
 
    public static Boolean checkOperator(char c) {
        if (c >= 48 && c <= 57)
            return true;
        else
            return false;
    }
 */
/* 
    static int PrefixEvaluation(String theString) {

        Stack<Integer> Stack = new Stack<Integer>();

        int j = theString.length() - 1;
        while (j >= 0) {

            if (checkOperator(theString.charAt(j)))
                Stack.push((int) (theString.charAt(j) - 48));

            else {
                int o1 = Stack.peek();
                Stack.pop();
                int o2 = Stack.peek();
                Stack.pop();
                switch (theString.charAt(j)) {
                    case '+' -> Stack.push(o1 + o2);
                    case '-' -> Stack.push(o1 - o2);
                    case '*' -> Stack.push(o1 * o2);
                    case '/' -> Stack.push(o1 / o2);
                }
            }
            j--;
        }
        return Stack.peek();
    }
 
    public static void main(String[] args) {
        // String exp = "12435+34569-12345*10+50";
        // System.out.println("Infix Expression: " + exp);
        // System.out.println("Prefix Expression: " + input2Prefix(exp));

        Scanner scannerInput = new Scanner(System.in);

        System.out.println("Please enter your mathematical equation");
        System.out.println("E.g 12435+34569-12345*10+50");

        String stringInput = scannerInput.next();

        if (validateInput(stringInput)) {
            System.out.println(input2Prefix(stringInput));
            StringBuilder s = input2Prefix(stringInput);
            System.out.println(PrefixEvaluation(String.valueOf(s)));
*/
//      } else {
//        System.out.println(
//              "Invalid Input: Input contains characters the are not valid. Valid Characters: [0-9 / (*/+-)]");
//    } 
//  }
//}

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Calculator {

    public static ArrayList<String> BODMAS(String s) {
        ArrayList<String> termsOfEquation = new ArrayList<>();

        // Getting numbers and operators for the equation
        StringTokenizer st = new StringTokenizer(s, " ");
        for (Iterator<Object> i = st.asIterator(); i.hasNext();) {
            termsOfEquation.add((String) i.next());
        }

        // BODMAS - Bracket Off Division Multiplication Addition Subtraction
        // In this video I show only DMAS

        while (termsOfEquation.indexOf("/") != -1) {
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("/") + 1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("/") - 1));
            double answer = num2 / num1;
            termsOfEquation.set(termsOfEquation.indexOf("/") - 1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("/") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("/"));
        }
        // Now repeat it for * + - in this order

        while (termsOfEquation.indexOf("*") != -1) {
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("*") + 1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("*") - 1));
            double answer = num2 * num1;
            termsOfEquation.set(termsOfEquation.indexOf("*") - 1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("*") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("*"));
        }

        while (termsOfEquation.indexOf("+") != -1) {
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("+") + 1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("+") - 1));
            double answer = num2 + num1;

            termsOfEquation.set(termsOfEquation.indexOf("+") - 1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("+") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("+"));
        }

        while (termsOfEquation.indexOf("-") != -1) {
            double num1 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("-") + 1));
            double num2 = Double.parseDouble(termsOfEquation.get(termsOfEquation.indexOf("-") - 1));
            double answer = num2 - num1;
            termsOfEquation.set(termsOfEquation.indexOf("-") - 1, Double.toString(answer));
            termsOfEquation.remove(termsOfEquation.indexOf("-") + 1);
            termsOfEquation.remove(termsOfEquation.indexOf("-"));
        }
        return termsOfEquation;
        // Fixing some mistake
        // Now it work correctly

    }

    public static boolean validateInput(String input) {
        char[] expression = new String(input).toCharArray();
        Boolean bool = false;
        int i = 0;
        while (i < expression.length) {
            if ((expression[i] >= '0' && expression[i] <= '9')
                    || (expression[i] == '+' || expression[i] == '-' || expression[i] == '/' || expression[i] == '*')) {
                bool = true;
                i++;
            } else {
                bool = false;
                i++;
            }
        }
        return bool;
    }

    public static void main(String[] args) {

        try (Scanner scannerInput = new Scanner(System.in)) {
            System.out.println("Enter math");
            String s = scannerInput.nextLine();
            while (validateInput(s)) {
                BODMAS(s).forEach(System.out::println);
                break;

            }
            System.out.println("Try again");
        }

    }

}