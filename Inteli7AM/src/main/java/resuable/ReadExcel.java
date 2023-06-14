package resuable;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcel {


    public static String fetchData(String sheetName, int row , int column)  {

        FileInputStream fis = null;
        String value = null;
        try {

            fis = new FileInputStream(new File("src/main/resources/testdata/DataFile.xlsx"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            XSSFSheet sheet = workbook.getSheet(sheetName);
           value =  sheet.getRow(row).getCell(column).getStringCellValue();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return value;

    }
}
