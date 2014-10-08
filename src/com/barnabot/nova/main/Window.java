/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova;

import com.barnabot.nova.libs.Reference;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Window
{
    private static JFrame frame;
    
   
    public static void createWindow(Game game, String title)
    {
        frame = new JFrame(title);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image icon = toolkit.getImage(Reference.RESOURCE_LOCATION + "icon.png");
        Image cursor = toolkit.getImage(Reference.RESOURCE_LOCATION + "cursor.gif");
        frame.add(game);
        frame.setIconImage(icon);
        frame.setCursor(toolkit.createCustomCursor(cursor, new Point(frame.getX(),frame.getY()), "cursor"));
        frame.setSize(Game.WIDTH,Game.HEIGHT);
        frame.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        Game.exit();
                    }
                }
        );
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
    }
    
    public static void setTitle(String title)
    {
        frame.setTitle(title);
    }
}
