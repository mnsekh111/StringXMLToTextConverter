/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stringxmltotextconverter.output;

import java.util.HashMap;

/**
 *
 * @author nsekhar
 */
public abstract class CustomFileWriter
{

    public static final int WRITE_SUCCESS = 1;
    public static final int WRITE_FAILURE = 0;

    public abstract int write(HashMap<String, String> stringList, String stringFileName);
}
