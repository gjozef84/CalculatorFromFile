import mathematicalOperations.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.nio.file.Files.readAllLines;

/**
 * Created by gjozef84@gmail.com on 2019-01-08
 */

public class CalculatorFromFile {

    public static void main(String[] args) {
        System.out.println("Operations from file to calculate:"); printInputFile(args[0]);
        System.out.println("\nCalculate result = " + calculate(readFile(args[0])));
    }

    private static int calculate(List<String> inputString) {

        Integer calculateResult = 0;

        if (inputString.isEmpty() || inputString.get(0).equals("")) {
            System.out.println("Input string is empty.");
        } else {
            //Integer applyValue = Integer.parseInt(inputString.get(inputString.size() - 1).split(" ")[1]);

            calculateResult = Integer.parseInt(inputString.get(inputString.size() - 1).split(" ")[1]);

            List<MathematicalOperation> listOperations = new ArrayList<>();

            for (int i = 0; i < inputString.size() - 1; i++) {
                listOperations.add(whatIsOperation(inputString.get(i)));
            }

            for (MathematicalOperation m : listOperations) {
                calculateResult = m.performOperation(calculateResult);
            }
        }
        return calculateResult;
    }

    private static MathematicalOperation whatIsOperation(String line) {
        MathematicalOperation mathematicalOperation;
        String[] splitLine = line.split(" ");
        String operation = splitLine[0];
        Integer digit = Integer.parseInt(splitLine[1]);

        switch (operation) {
            case "add":
                mathematicalOperation = new AddOperation(digit);
                break;
            case "multiply":
                mathematicalOperation = new MultiplyOperation(digit);
                break;
            case "substract":
                mathematicalOperation = new SubstractOperation(digit);
                break;
            default:
                mathematicalOperation = new ApplyOperation(digit);
                break;
        }

        return mathematicalOperation;
    }

    private static void printInputFile(String pathToInputFile) {
        List<String> stringFromFile = readFile(pathToInputFile);
        stringFromFile.forEach(System.out::println);
    }

    private static List<String> readFile(String pathToInputFile) {

        Path path;

        if (pathToInputFile.isEmpty()) {
            path = Paths.get("C:\\Users\\Grzesiek\\IdeaProjects\\CalculatorFromFile\\src\\main\\java\\inputFile.txt");
        } else {
            path = Paths.get(pathToInputFile);
        }
        try {
            return readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}