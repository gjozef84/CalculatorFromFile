import mathematicalOperations.*;

import java.io.FileNotFoundException;
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
        runCalculate(args);
    }

    private static void runCalculate(String[] args) {
        if (args.length <= 0)
            System.out.println("Please enter the path of the input file, e.g.:\njava CalculatorFromFile inputFile.txt");
        else {
            List<String> listFromFile = readFile(args[0]);
            if (!listFromFile.isEmpty()) {
                System.out.println("Operations from file to calculate:");
                listFromFile.forEach(System.out::println);
                System.out.println("\nCalculate RESULT = " + calculate(listFromFile));
            }
        }
    }

    public static int calculate(List<String> inputString) {

        Integer calculateResult = 0;

        if (inputString.isEmpty() || inputString.get(0).equals("")) {
            System.out.println("Input string is empty.");
        } else {

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
        String operation = splitLine[0].toLowerCase();
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

    private static List<String> readFile(String pathToInputFile) {

        Path path = Paths.get(pathToInputFile);

        try {
            return readAllLines(path);
        } catch (IOException e) {
            System.out.println("Error!!!\nSorry but file " + pathToInputFile + " not found or there was another exception.\nPlease another path/file!");
        }
        return Collections.emptyList();
    }
}