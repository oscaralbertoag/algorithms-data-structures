package codelab;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class ExcelColumnTest {

    @Test
    @Parameters(method = "titleToNumberParams")
    public void titleToNumber(int expectedColumnNumber, String column) {
        ExcelColumn excelColumn = new ExcelColumn();
        assertEquals(expectedColumnNumber, excelColumn.titleToNumber(column));
    }

    public Object[] titleToNumberParams() {
        Object[] scenario1 = { 703, "AAA" };

        return new Object[] { scenario1 };
    }

}