import java.util.Scanner;

public class Calculator {
    public static void main(String [] args) {
        Scanner scannerInput = new Scanner(System.in);

        System.out.println("Please enter your mathematical equation");
        System.out.println("E.g 12435+34569-12345*10+50");

        String stringInput = scannerInput.next();

        String parsedInteger = "";
        String operator = "";
        int equals = 0;
        int i = 0;
        while (i < stringInput.length()) {
            char c = stringInput.charAt(i);
            if (Character.isDigit(c)) {
                parsedInteger += c;
            }
            if (Character.isDigit(c) && i != stringInput.length() - 1) {
            } else {
                int parsed = Integer.parseInt(parsedInteger);
                if (operator == "") {
                    equals = parsed;
                }
                else {
                    switch (operator) {
                        case "+" :
                            equals += parsed;
                            break;
                        case "-" :
                            equals -= parsed;
                            break;
                        case "*" :
                            equals *= parsed;
                            break;
                        case "/" :
                            equals /= parsed;
                            break;
                    }
                }

                parsedInteger ="";
                operator = ""+c;
            }
            i++;
        }
        System.out.println("=" + equals);
    }
}