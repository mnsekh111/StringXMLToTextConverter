/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringxmltotextconverter.output;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author nsekhar
 */
public class XLFileWriter extends CustomFileWriter
{

    public int write(HashMap<String, String> stringList, String stringFileName)
    {
        int result = WRITE_FAILURE;

        HSSFWorkbook workBook = new HSSFWorkbook();
        HSSFSheet sheet = workBook.createSheet("Strings");

        int rowNum = 0;
        for (String str : stringList.keySet())
        {
            Row row = sheet.createRow(rowNum++);
            Cell keyCell = row.createCell(0);
            Cell valCell = row.createCell(1);

            keyCell.setCellValue(str);
            valCell.setCellValue(stringList.get(str));

        }

        File xslFile = new File(stringFileName.substring(0, stringFileName.lastIndexOf('.') + 1) + ".xls");
        try
        {
            FileOutputStream fout = new FileOutputStream(xslFile);
            workBook.write(fout);
            fout.close();
            result = WRITE_SUCCESS;
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(XLFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(XLFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
