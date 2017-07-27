package general;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by Daniel on 27/07/2017.
 */
public class ExelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;
    public static int totalRows;
    public static int totalCols;

    public static String[][] getTableArray(String FilePath, String SheetName) throws Exception {
        String[][] tabArray = null;
        try {
            FileInputStream ExcelFile = new FileInputStream(FilePath);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            totalRows = ExcelWSheet.getLastRowNum() + 1;
            // you can write a function as well to get Column count
            totalCols = 2;
            tabArray=new String[totalRows][totalCols];
            for (int row = 0; row < totalRows; row++) {

                for (int col = 0; col < totalCols; col++) {
                    tabArray[row][col]=getCellData(row,col);
                }
                System.out.println();
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        catch (IOException e){
            System.out.println("Could not read the Excel sheet");
            e.printStackTrace();
        }
        return(tabArray);
    }

    public static String getCellData(int RowNum, int ColNum) throws Exception {
        try {
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            int dataType = Cell.getCellType();
            if (dataType == 3) {
                return "";
            } else {
                String CellData = Cell.getStringCellValue();
                return CellData;
            }
        }catch(Exception e){
                System.out.println(e.getMessage());
                throw(e);
            }
        }
}
