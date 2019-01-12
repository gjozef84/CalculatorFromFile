package mathematicalOperations;

import lombok.Data;
import mathematicalOperations.MathematicalOperation;

/**
 * Created by gjozef84@gmail.com on 2019-01-08
 */

@Data
public class MultiplyOperation implements MathematicalOperation {

    private String name = "multiply";
    private String symbol = "*";
    private Integer number;

    public MultiplyOperation(Integer number) {
        this.number = number;
    }

    public Integer performOperation(Integer inputNumber) {
        return inputNumber * this.number;
    }

}
