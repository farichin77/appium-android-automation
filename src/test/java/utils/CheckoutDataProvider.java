package utils;

import models.CheckoutData;
import org.testng.annotations.DataProvider;

public class CheckoutDataProvider {

    @DataProvider(name = "checkoutData")
    public static Object[][] checkoutDataProvider() {

        Object[][] csvData = CSVUtils.getData("src/test/resources/dataCekout.csv");
        Object[][] result = new Object[csvData.length][1];

        for (int i = 0; i < csvData.length; i++) {
            CheckoutData data = new CheckoutData(
                    csvData[i][0].toString(),
                    csvData[i][1].toString(),
                    csvData[i][2].toString(),
                    csvData[i][3].toString(),
                    csvData[i][4].toString(),
                    csvData[i][5].toString(),
                    csvData[i][6].toString(),
                    csvData[i][7].toString(),
                    csvData[i][8].toString(),
                    csvData[i][9].toString()
            );
            result[i][0] = data;
        }
        return result;
    }
}
