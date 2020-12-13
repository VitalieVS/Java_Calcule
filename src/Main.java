import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    @Test
    public void calcule() {
        solve();
    }

    public void solve() {
        int line = 0;
        BigInteger calcResult = null;
        String[] result = null;
        File objFile = new File("input.txt");
        try {
            Scanner reader = new Scanner(objFile);
            while (reader.hasNextLine()) {
                if (line == 0) {
                    String data = reader.nextLine();
                    result = data.split(" ");

                } else {
                    calcResult = new BigInteger(reader.nextLine());
                }
                line++;
            }
            reader.close();

            assert result != null;
            if (calculate(result[0], result[1], result[2]).equals(calcResult)) {
                System.out.println("CORRECT");
            } else  {
                System.out.println("Gresit");
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }

     BigInteger calculate(String first, String second, String operator) {
        BigInteger firstNumber = new BigInteger(first);
        BigInteger secondNumber = new BigInteger(second);
        BigInteger result = new BigInteger("0");
        switch (operator) {
            case "+" -> result = firstNumber.add(secondNumber);
            case "-" -> result = firstNumber.subtract(secondNumber);
            case "*" -> result = firstNumber.multiply(secondNumber);
        }
        return result;
    }
}
