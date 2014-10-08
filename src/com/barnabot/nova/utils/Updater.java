/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.Game;
import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.utils.files.TextFile;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import javax.swing.JOptionPane;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Updater
{
    private static String currentVersion, newVersion;
    public static int update = 0;
    
    public static void checkForUpdate(boolean isAuto)
    {
        currentVersion = TextFile.readFile("./version.txt");
        try
        {
            URL site = new URL("https://github.com/barnhen/The3rdTrial/tree/master/The3rdTrial/version.txt");
            ReadableByteChannel rbc = Channels.newChannel(site.openStream()); // openning file from url
            FileOutputStream fos = new FileOutputStream("./version.txt");
            /**
             * bytewise i.e. u have a var consists in x / 16
             * so u can do that as x << 4, which mean u are dividing
             * by the 4 using the power of 2 (4*4=16)
             * it is code otimisation
             * */
            fos.getChannel().transferFrom(rbc, 0, 1 << 24); 
            fos.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        
        newVersion = TextFile.readFile("./version.txt");
        
        if (currentVersion.equals(newVersion))
        {
            if (!isAuto)
            {
                doNotUpdate();
                
            }
            return;
        }
        else
        {
            Object[] options = 
            {
                "Update"
                ,"Do Not Update"
            };
            
            int temp = JOptionPane.showOptionDialog(null, "An update has been found for Cataclysmic Battles (current version: " + currentVersion + " new version: " + newVersion +
                    " \nUpdate may take several minutes!\nDo not close the game while updating!\nA window will pop up when the update is complete", 
                    "Updater", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        
            if (temp == 1)
            {
                return;
            }
            else
            {
                TextFile.writeFile("./version.txt", newVersion);
                
                try
                {
                    URL site = new URL("https://raw.githubusercontent.com/barnhen/The3rdTrial/master/The3rdTrial/image/TileSet-1.fw.png");
                    ReadableByteChannel rbc = Channels.newChannel(site.openStream()); // openning file from url
                    FileOutputStream fos = new FileOutputStream(Reference.SPRITE_LOCATION + "female.png");
                    /**
                    * bytewise i.e. u have a var consists in x / 16
                    * so u can do that as x << 4, which mean u are dividing
                    * by the 4 using the power of 2 (4*4=16)
                    * it is code otimisation
                    * */
                    fos.getChannel().transferFrom(rbc, 0, 1 << 24); 
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                //https://github.com/barnhen/The3rdTrial/raw/master/The3rdTrial/font/arial.ttf
                try
                {
                    URL site = new URL("https://github.com/barnhen/The3rdTrial/raw/master/The3rdTrial/font/arial.ttf");
                    ReadableByteChannel rbc = Channels.newChannel(site.openStream()); // openning file from url
                    FileOutputStream fos = new FileOutputStream(Reference.FONT_LOCATION + "VIKING-N.TTF");
                    /**
                    * bytewise i.e. u have a var consists in x / 16
                    * so u can do that as x << 4, which mean u are dividing
                    * by the 4 using the power of 2 (4*4=16)
                    * it is code otimisation
                    * */
                    fos.getChannel().transferFrom(rbc, 0, 1 << 24); 
                    fos.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                
                finishUpdate();
                return;
            }
            
        }
        
    }private static void finishUpdate()
    {
        JOptionPane.showMessageDialog(null, "Game has been updated to version " + newVersion + "\nGame will now close",
                "Update Completed",JOptionPane.INFORMATION_MESSAGE);
        Game.exit();
    }
    
    private static void doNotUpdate()
    {
        JOptionPane.showMessageDialog(null, "No update found", "Updater", JOptionPane.INFORMATION_MESSAGE);
        return; // used just to get out of method
    }
    
}
