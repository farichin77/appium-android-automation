package utils;

import models.CheckoutData;
import org.testng.annotations.DataProvider;

public class CheckoutDataProvider {

    @DataProvider(name = "checkoutData")
    public static Object[][] checkoutDataProvider() {

        Object[][] csvData = CSVUtils.getData("src/test/resources/dataCekout.csv");
        Object[][] result = new Object[csvData.length][1];

        for (int i = 0; i < csvData.length; i++) {
            Object[] row = csvData[i];
            CheckoutData data = new CheckoutData(
                    getValue(row, 0),
                    getValue(row, 1),
                    getValue(row, 2),
                    getValue(row, 3),
                    getValue(row, 4),
                    getValue(row, 5),
                    getValue(row, 6),
                    getValue(row, 7),
                    getValue(row, 8),
                    getValue(row, 9)
            );
            result[i][0] = data;
        }
        return result;
    }

    @DataProvider(name = "checkoutDataNegative")
    public static Object[][] checkoutDataNegativeProvider() {

        Object[][] csvData = CSVUtils.getData("src/test/resources/dataCekoutNegative.csv");
        Object[][] result = new Object[csvData.length][1];

        for (int i = 0; i < csvData.length; i++) {
            Object[] row = csvData[i];
            CheckoutData data = new CheckoutData(
                    getValue(row, 0),
                    getValue(row, 1),
                    getValue(row, 2),
                    getValue(row, 3),
                    getValue(row, 4),
                    getValue(row, 5),
                    getValue(row, 6),
                    getValue(row, 7),
                    getValue(row, 8),
                    getValue(row, 9)
            );
            result[i][0] = data;
        }
        return result;
    }

    private static String getValue(Object[] row, int index) {
        return (row.length > index && row[index] != null) ? row[index].toString() : "";
    }
}
