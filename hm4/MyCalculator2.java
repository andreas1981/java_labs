import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Andrew_Elena on 02.07.2016.
 */
public class MyCalculator2 {
    public static void main(String[] args) throws Exception {
        String str = "";
        int result = 0;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            str = scanner.nextLine();
            if (str.toLowerCase().equals("exit"))
                break;
            Pattern p = Pattern.compile("^(\\d*)(\\+|\\-|\\*|/)(\\d*)(((\\+|\\-|\\*|/)(\\d*))+)?=$");
            Matcher m = p.matcher(str);
            if (!m.matches())
                throw new Exception("Неверное выражение! Должно быть: аргумент1 оператор аргумент2 оператор аргументN=");

            str = str.substring(0, str.length() - 1);
            String[] arr = str.split("(\\-|\\+)");

            String[] arr1 = str.split("\\d+");
            int j = 1;
            result = Integer.parseInt(arr[0]);
            for (int i = 1; i < arr1.length; i++) {
                switch (arr1[j]) {
                    case "+":
                        result += Integer.parseInt(arr[i]);
                        j++;
                        break;
                    case "-":
                        result -= Integer.parseInt(arr[i]);
                        j++;
                        break;
                }
            }
            System.out.println(result);

        }
    }
}
