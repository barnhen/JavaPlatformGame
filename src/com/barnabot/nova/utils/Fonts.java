/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.screens.LoadScreen;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Fonts
{
    private static ArrayList<Fonts> fontList = new ArrayList<Fonts>();
    private static String fontPath;
    
    public Fonts(String filePath)
    {
        LoadScreen.setMessage("Loading fonts from " + Reference.FONT_LOCATION);
        Fonts.fontPath = Reference.FONT_LOCATION + filePath;
        registerFont();
    }
    
    private void registerFont()
    {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        
        try
        {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(fontPath)));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void addFont(Fonts font)
    {
        fontList.add(font);
    }
    
    
}
