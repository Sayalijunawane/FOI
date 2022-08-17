package CommonFunctions;

import java.io.FileInputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ReadExcel {

	public FileInputStream fis;
	public int excel_row,excel_col;
	public Workbook excel_WorkBook;
	public Sheet excel_Sheet;

	public void ReadExcelFile(String FilePath,int SheetNo) throws IOException, BiffException, InterruptedException
	{
		fis=new FileInputStream(FilePath);
	    excel_WorkBook= Workbook.getWorkbook(fis);
		excel_Sheet = excel_WorkBook.getSheet(SheetNo);
	
		excel_row=excel_Sheet.getRows();
		excel_col=excel_Sheet.getColumns();
		//System.out.println("in read excel"+excel_row+excel_col);
	
	}
}