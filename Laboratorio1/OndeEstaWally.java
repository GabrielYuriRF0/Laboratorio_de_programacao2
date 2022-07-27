import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OndeEstaWally {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputValues = getInputValues(" ", input);  // Lista com os nomes da entrada

        while (!hasWally(inputValues)) {  // Verifica se tem "wally" em alguma posição da lista inputValues
            List<String> fiveLettersNames = new ArrayList<>();

            for (int i = 0; i < inputValues.length; i++) {
                if (inputValues[i].length() == 5) {
                    fiveLettersNames.add(inputValues[i]);
                }
            }

//            for (String i : getInputValues(" ", input)) {  //
//                if (i.length() == 5) {
//                    fiveLettersNames.add(i);
//                }
//            }

            if (fiveLettersNames.size() == 0) {
                System.out.println("?");
            }
            else {
                System.out.println(fiveLettersNames.get(fiveLettersNames.size() - 1));
            }

            input = sc.nextLine();
            inputValues = getInputValues(" ", input);
        }
    }

    public static String[] getInputValues(String regex, String input) {
        return input.split(regex);
    }

    public static boolean hasWally(String[] inputValues) {
        boolean hasWally = false;
        for (String i : inputValues) {
            if (i.equalsIgnoreCase("wally")) {
                hasWally = true;
                break;
            }
        }
        return hasWally;
    }
}