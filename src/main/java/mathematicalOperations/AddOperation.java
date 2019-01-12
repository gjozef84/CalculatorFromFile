package mathematicalOperations;

import lombok.Data;

/**
 * Created by gjozef84@gmail.com on 2019-01-08
 */

@Data
public class AddOperation implements MathematicalOperation {

    private String name = "add";
    private String symbol = "+";
    private Integer number;

    public AddOperation(Integer number) {
        this.number = number;
    }

    public Integer performOperation(Integer inputNumber) {
        return this.number+inputNumber;
    }

}
