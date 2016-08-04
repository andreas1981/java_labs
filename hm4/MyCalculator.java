import java.util.Scanner;

/**
 * Created by Andrew_Elena on 30.06.2016.
 */
public class MyCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstOperand = 0;
        int secondOperand = 0;
        String operand = "";
        int countInt = 0;
        String buf = "";
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                countInt++;
                if (countInt == 1)
                    firstOperand = scanner.nextInt();
                else
                    secondOperand = scanner.nextInt();
            } else {
                 buf = scanner.next();
                if (buf.equals("=")) {
                    switch (operand) {
                        case ("+"):
                            System.out.println(firstOperand + secondOperand);
                            break;
                        case ("-"):
                            System.out.println(firstOperand - secondOperand);
                            break;
                        case ("*"):
                            System.out.println(firstOperand * secondOperand);
                            break;
                        case ("/"):
                            System.out.println(firstOperand / secondOperand);
                            break;
                        default:
                            System.out.println("Оператор не определен!");

                    }
                    return;
                } else
                    operand = buf;

            }

        }
    }
}
