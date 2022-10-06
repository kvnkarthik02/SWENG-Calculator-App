
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Calculator {

    public static ArrayList<String> BEMDAS(String s) {
        ArrayList<String> mathEquation = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(s, " ");
        for (Iterator<Object> i = st.asIterator(); i.hasNext();) {
            mathEquation.add((String) i.next());
        }

        while (mathEquation.indexOf("*") != -1) {
            int num1 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("*") + 1));
            int num2 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("*") - 1));
            int answer = num2 * num1;
            mathEquation.set(mathEquation.indexOf("*") - 1, Integer.toString(answer));
            mathEquation.remove(mathEquation.indexOf("*") + 1);
            mathEquation.remove(mathEquation.indexOf("*"));
        }

        while (mathEquation.indexOf("/") != -1) {
            int num1 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("/") + 1));
            int num2 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("/") - 1));
            int answer = num2 / num1;
            mathEquation.set(mathEquation.indexOf("/") - 1, Integer.toString(answer));
            mathEquation.remove(mathEquation.indexOf("/") + 1);
            mathEquation.remove(mathEquation.indexOf("/"));
        }

        while (mathEquation.indexOf("-") != -1) {
            int num1 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("-") + 1));
            int num2 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("-") - 1));
            int answer = num2 - num1;
            mathEquation.set(mathEquation.indexOf("-") - 1, Integer.toString(answer));
            mathEquation.remove(mathEquation.indexOf("-") + 1);
            mathEquation.remove(mathEquation.indexOf("-"));
        }

        while (mathEquation.indexOf("+") != -1) {
            int num1 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("+") + 1));
            int num2 = Integer.parseInt(mathEquation.get(mathEquation.indexOf("+") - 1));
            int answer = num2 + num1;
            mathEquation.set(mathEquation.indexOf("+") - 1, Integer.toString(answer));
            mathEquation.remove(mathEquation.indexOf("+") + 1);
            mathEquation.remove(mathEquation.indexOf("+"));
        }

        return mathEquation;
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

        boolean restart = false;

        try (Scanner scannerInput = new Scanner(System.in)) {
            while (!restart) {

                System.out.println("Enter expression with spaces between operand and operator: ");
                String s = scannerInput.nextLine();
                if (validateInput(s)) {
                    BEMDAS(s).forEach(System.out::println);
                    restart = !restart;
                } else {
                    System.out.println(
                            "Invalid Input: Input contains characters the are not valid. Valid Characters: [0-9 / (*/+-)]");
                    restart = false;
                }
            }
        }
    }
}