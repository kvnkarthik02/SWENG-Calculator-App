
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Calculator {

    public static ArrayList<String> BEMDAS(String s) {
        ArrayList<String> mathEquation = new ArrayList<>();

        StringTokenizer theString = new StringTokenizer(s, " ");
        for (Iterator<Object> i = theString.asIterator(); i.hasNext();) {
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

                System.out.println("Please enter a Mathematical Equation:");
                String s = scannerInput.nextLine();
                String newS = s.replace("*", " * ")
                        .replace("+", " + ")
                        .replace("-", " - ")
                        .replace("/", " / ");

                if (validateInput(newS)) {

                    BEMDAS(newS).forEach(System.out::println);
                    System.out.println("Thank you for using our Calculator.");
                    restart = !restart;
                } else {
                    System.out.println(
                            "Invalid Input: Input contains characters the are not valid. Valid Characters: [0-9 / (*/+-)] ");
                    restart = false;
                }
            }
        }
    }
}