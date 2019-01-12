package mathematicalOperations;

import lombok.Data;
import mathematicalOperations.MathematicalOperation;

/**
 * Created by gjozef84@gmail.com on 2019-01-10
 */

@Data
public class ApplyOperation implements MathematicalOperation {

    private String name = "apply";
    private String symbol = " ";
    private Integer number;

    public ApplyOperation(Integer number) {
        this.number = number;
    }

    public Integer performOperation(Integer number) {
        return this.number;
    }
}
