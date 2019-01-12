import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Grzesiek on 2019-01-08
 */

public class CalculatorFromFileTest {

    @Test
    public void shouldReturn0IfStringIsEmpty() {
        List<String> stringInput = new ArrayList<>();
        stringInput.add("");
        assertThat(CalculatorFromFile.calculate(stringInput), is(0));
    }

    @Test
    public void shouldReturn1WhenInputContainsOnlyApplyAndDigit1() {
        List<String> stringInput = new ArrayList<>();
        stringInput.add("apply 1");
        assertThat(CalculatorFromFile.calculate(stringInput), is(1));
    }

    @Test
    public void shouldReturn2WhenStringContainsTwoLinesWithAdd() {
        List<String> stringInput = new ArrayList<>();
        stringInput.add("Add 1");
        stringInput.add("apply 1");
        assertThat(CalculatorFromFile.calculate(stringInput), is(2));
    }

    @Test
    public void shouldReturn5WhenStringContainsTwoLinesWithSubstract() {
        List<String> stringInput = new ArrayList<>();
        stringInput.add("Subtract 5");
        stringInput.add("apply 10");
        assertThat(CalculatorFromFile.calculate(stringInput), is(5));
    }

    @Test
    public void shouldReturn32WhenStringContainsTreeLinesWithMultiply() {
        List<String> stringInput = new ArrayList<>();
        stringInput.add("multiply 3");
        stringInput.add("add 2");
        stringInput.add("apply 10");
        assertThat(CalculatorFromFile.calculate(stringInput), is(32));
    }
}