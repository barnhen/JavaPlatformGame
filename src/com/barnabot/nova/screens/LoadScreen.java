/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.screens;

import com.barnabot.nova.Game;
import com.barnabot.nova.libs.Images;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class LoadScreen
{
    private static int width = 540;
    private static int  numResources = 8;
    private static int loadAdd = width / numResources;
    private static int loadStatus = 0;
    
    private static String msg = "Loading Resources...";
    
    public static void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Game.WIDTH,Game.HEIGHT);
        g.drawImage(Images.loading, 0, 0, null);
        g.setColor(Color.RED);
        g.drawRect(49, 399, width, 51);
        g.setFont(new Font("Arial", Font.PLAIN, 18));
        g.drawString(msg, 51, 395);
        g.setColor(Color.BLUE);
        g.fillRect(50, 400, loadStatus, 50);
    }
    
    public static void loadMore()
    {
        loadStatus += loadAdd;
    }
    
    public static void setMessage(String msg)
    {
        LoadScreen.msg = msg;
    }
}
