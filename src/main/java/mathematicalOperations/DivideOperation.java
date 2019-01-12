package mathematicalOperations;

/**
 * Created by Grzesiek on 2019-01-12
 */
public class DivideOperation implements MathematicalOperation {

    private String name = "divide";
    private String symbol = "/";
    private Integer number;

    public DivideOperation(Integer number) {
        this.number = number;
    }

    public Integer performOperation(Integer inputNumber) {
        return inputNumber / this.number;
    }

}