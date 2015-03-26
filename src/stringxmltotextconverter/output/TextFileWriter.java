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
import static stringxmltotextconverter.output.CustomFileWriter.WRITE_FAILURE;

/**
 *
 * @author nsekhar
 */
public class TextFileWriter extends CustomFileWriter
{

    @Override
    public int write(HashMap<String, String> stringList, String stringFileName)
    {

        int result = WRITE_FAILURE;

        File txtFile = new File(stringFileName.substring(0, stringFileName.lastIndexOf('.') +1) + "txt");

        try
        {
            FileOutputStream fout = new FileOutputStream(txtFile);
            for (String str : stringList.keySet())
            {
                fout.write(("\"" + str + "\"" + "," + "\"" + stringList.get(str) + "\"" + "\n").getBytes());
            }
        } catch (FileNotFoundException ex)
        {
            Logger.getLogger(TextFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(TextFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

}
