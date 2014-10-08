/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class TextFile
{
    private static String line;
    
    public static String readFile(String path)
    {
        BufferedReader file;
        try
        {
            file = new BufferedReader(new FileReader(path));
            line = file.readLine();
            file.close();
        }
        catch (IOException ex)
        {
//            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        return line;
    }
    
    public static void writeFile(String path, String text)
    {
        try
        {
            FileWriter file = new FileWriter(path);
            file.write(text);
            file.close();
        }
        catch (IOException ex)
        {
//            Logger.getLogger(TextFile.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
    }
}
