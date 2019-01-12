package mathematicalOperations;

import lombok.Data;
import mathematicalOperations.MathematicalOperation;

/**
 * Created by Grzesiek on 2019-01-10
 */

@Data
public class SubtractOperation implements MathematicalOperation {

    private String name = "subtract";
    private String symbol = "-";
    private Integer number;

    public SubtractOperation(Integer number) {
        this.number = number;
    }

    public Integer performOperation(Integer inputNumber) {
        return inputNumber - this.number;
    }

}
