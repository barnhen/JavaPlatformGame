/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.input.MouseInput;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Button extends Rectangle
{

    private String text;
    

    public Button(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

   
    public Button setText(String text)
    {
        this.text = text;
        return this;
    }
    
    public void drawButton(Graphics g, int offset)
    {
        int xx = x +  offset;
        int yy = y +38;
        
        if (MouseInput.MOUSE.intersects(this)) // show our button in yellow when our mouse hover over them
        {
            g.setColor(Color.YELLOW);
//            AudioPlayer.getSound(Audio.LASER).play();
//            System.out.println(" Hover Yellow");
        }
        else // otherwise , show the button in white
        {
            g.setColor(Color.WHITE);
//             System.out.println(" WHITE");
        }
        
        
        if(!MouseInput.pressed && MouseInput.MOUSE.intersects(this))
        {
            g.drawRect(x, y, width, height);
        }
        else if(MouseInput.pressed && MouseInput.MOUSE.intersects(this))
        {
            g.fillRect(x, y, width, height);
        }
        else
            g.drawRect(x, y, width, height);
        
//        g.drawRect(x, y, width, height);
        g.setColor(Color.RED);
        g.drawString(text,xx,yy);
    }
    
    
    
}