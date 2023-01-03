package Utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelUtils {
    private static FileInputStream fis;

    private static XSSFWorkbook workbook;

    private static XSSFSheet sheet;

    private static XSSFRow row;

    private static XSSFCell cell;

    private static List<String> data = new ArrayList<>();

    public static List<String> readExcelData(String fileName,String sheetName){
        try {
            fis = new FileInputStream("C:\\GitClone\\learnDemo\\LearnFramework\\src\\main\\resources\\TestData\\"+fileName+".xlsx");
            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

            int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

            for(int i = 1;i <= rowCount;i++){
                row = sheet.getRow(i);
                for(int j=0;j<row.getLastCellNum();j++){
                     cell = row.getCell(j);
                     String value = cell.getStringCellValue();
                     data.add(value);
                }
            }
        } catch (FileNotFoundException e) {
            Assert.fail("Unable to Find the Excel File");
        } catch (IOException e) {
            Assert.fail("Unable to Read Excel Data");
        }finally {
            try {
                fis.close();
                workbook.close();
            }catch (IOException e){
                Assert.fail("Unable to Close the Excel");
            }
        }
        return data;
    }

}
