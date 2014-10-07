/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.screens;

import com.barnabot.nova.Game;
import com.barnabot.nova.libs.Images;
import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.utils.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Henrique Barnabe
 */
public class Menu
{
//    public Rectangle play, options, quit;
    public Button play, options, quit;
//    private static int centerY = Game.HEIGHT/2;
    
    public Menu()
    {
        int fillerY = 150;
        play = new Button(Reference.CENTER_X -100, fillerY, 200, 50).setText("Play");
        options = new Button(Reference.CENTER_X -100, fillerY+=60, 200, 50).setText("Options");
        quit = new Button(Reference.CENTER_X -100, fillerY+=60, 200, 50).setText("Quit");
    }
    
    
    public void Render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.drawImage(Images.title,128,10,null);
        
        Font viking = new Font("Viking-Normal", Font.PLAIN, 32);
        g.setFont(viking);
        
        play.drawButton(g, 55);
        options.drawButton(g, 15);
        quit.drawButton(g, 55);
    }
}
