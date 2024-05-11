package utilities;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class ReadDataFromExcelFile {
    @DataProvider(name = "testdata")
    public String[][] getData(@NotNull Method m) throws EncryptedDocumentException, IOException {
        String excelSeetName = m.getName();
        File f = new File(System.getProperty("user.dir")+"\\src\\test\\testdata\\testdata.xlsx");
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSeetName);

        int totalRows = sheetName.getLastRowNum();
//        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalColumns = rowCells.getLastCellNum();
//        System.out.println(totalColumns);

        DataFormatter format = new DataFormatter();
        String testdata[][] = new String[totalRows][totalColumns];
        for (int i = 1; i <= totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                testdata[i - 1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
//                System.out.println(testdata[i - 1][j]);
            }
        }
        return testdata;

    }
}
