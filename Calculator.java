import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Calculator {

    public static ArrayList<String> BEMDAS(String s) {
        var mathEquation = new ArrayList<String>();


        StringTokenizer theString;
        theString = new StringTokenizer(s, " ");
        Iterator<Object> i = theString.asIterator();
        while (i.hasNext()) {
            mathEquation.add((String) i.next());
        }

        if (mathEquation.contains("*")) {
            do {
                int theNum;
                theNum= parseInt(mathEquation.get(mathEquation.indexOf("*") + 1));
                int theNum2;
                theNum2 = parseInt(mathEquation.get(mathEquation.indexOf("*") - 1));
                int answer = theNum2 * theNum;
                mathEquation.set(mathEquation.indexOf("*") - 1, Integer.toString(answer));
                mathEquation.remove(mathEquation.indexOf("*") + 1);
                mathEquation.remove("*");
            } while (mathEquation.contains("*"));
        }

        if (mathEquation.contains("/")) {
            do {
                int theNum;
                theNum = parseInt(mathEquation.get(mathEquation.indexOf("/") + 1),10);
                int theNum2;
                theNum2= parseInt(mathEquation.get(mathEquation.indexOf("/") - 1));
                int answer = theNum2 / theNum;
                mathEquation.set(mathEquation.indexOf("/") - 1, Integer.toString(answer));
                mathEquation.remove(mathEquation.indexOf("/") + 1);
                mathEquation.remove("/");
            } while (mathEquation.contains("/"));
        }

        if (mathEquation.contains("-")) {
            do {
                int theNum;
                theNum = parseInt(mathEquation.get(mathEquation.indexOf("-") + 1));
                int theNum2;
                theNum2= parseInt(mathEquation.get(mathEquation.indexOf("-") - 1));
                int answer = theNum2 - theNum;
                mathEquation.set(mathEquation.indexOf("-") - 1, Integer.toString(answer));
                mathEquation.remove(mathEquation.indexOf("-") + 1);
                mathEquation.remove("-");
            } while (mathEquation.contains("-"));
        }

        if (mathEquation.contains("+")) {
            do {
                int theNum;
                theNum = parseInt(mathEquation.get(mathEquation.indexOf("+") + 1));
                int theNum2;
                theNum2 = parseInt(mathEquation.get(mathEquation.indexOf("+") - 1));
                int answer = theNum2 + theNum;
                mathEquation.set(mathEquation.indexOf("+") - 1, Integer.toString(answer));
                mathEquation.remove(mathEquation.indexOf("+") + 1);
                mathEquation.remove("+");
            } while (mathEquation.contains("+"));
        }
        return mathEquation;
    }

    public static boolean validateInput(String input) {
        char[] expression = input.toCharArray();
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