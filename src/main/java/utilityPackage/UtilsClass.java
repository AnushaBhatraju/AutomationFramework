package utilityPackage;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static basePackage.BaseClass.driver;

public class UtilsClass {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICT_WAIT = 10;
    // screensots

    public static void takeScreenShotAtEndOfTest() throws IOException {

        File screens = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(screens, new File("C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework\\screenshots\\demo.png"));

    }

    public static Object[][] getExcelData(String fileName, String sheetName) {
        Object[][] data = null;
        XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook("C:\\Users\\bhatr\\IdeaProjects\\AutomationFramework\\src\\main\\java\\testData\\Book1.xlsx");

            XSSFSheet sheet = wb.getSheet(sheetName);

            int rowsIndex = sheet.getLastRowNum();  //return last row number ie, how many data sets we want to run-row index starts from 0,
            // so last row no is 4
            data = new Object[rowsIndex][];
            for (int i = 1; i <= rowsIndex; i++) {

                XSSFRow row = sheet.getRow(i);

                int cols = row.getLastCellNum();

                Object[] colData = new Object[cols];

                for (int j = 0; j < cols; j++) {
                    colData[j] = row.getCell(j).toString();
                }
                data[i - 1] = colData;
            }

        } catch (IOException e) {

        } finally {
            try {
                wb.close();
            } catch (IOException e) {
            }
        }

        return data;

    }



}


