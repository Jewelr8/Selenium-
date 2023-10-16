package DataReader;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelLoginDataReader {

    // I will write some code to connect my class to external file.
    // How to connect a external file ----
    @DataProvider (name = "Login Data from Excel")
    public Object[][] loginData() throws IOException {
        // This method established the connection with the external file
        FileInputStream fis = new FileInputStream("/Users/jewel/Desktop/UprightTechSolutions/IntelliJ_SeleniumProject/Maven/SeleniumFramework/src/test/ExternalData/Selenium project passwordbook.xlsx");

        XSSFWorkbook book = new XSSFWorkbook(fis); // This will open the workbook.
        XSSFSheet sheet = book.getSheet("LoginInfo"); // Open that specific sheet.


        int rowCount = sheet.getPhysicalNumberOfRows();// Counting the rows from Excel file.
        System.out.println(rowCount); // Will print out the row numbers
        int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();  //Counting the columns from Excel file.
        System.out.println(columnCount);


        Object [][] data = new Object[rowCount][columnCount]; // creating a new object of the object (data type on the left) class and passing the parameters.

        for (int i = 0; i < rowCount; i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {

               data [i][j] =sheet.getRow(i).getCell(j).getStringCellValue(); // getting the cell values from the Excel sheet and putting them into the two Dimensional array list.
            }

        }
return data;
    }


    public static void main(String[] args) throws IOException {
        ExcelLoginDataReader obj = new ExcelLoginDataReader();
        obj.loginData();
    }
}

