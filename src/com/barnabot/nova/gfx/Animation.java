/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.gfx;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Animation
{
    
    private int count = 0;
    private int index = 0;
    private int speed;
    private int frames;
    
    private BufferedImage currentImage;
    private BufferedImage anime[];
    
    public Animation(int speed, BufferedImage anime[])
    {
        this.speed = speed;
        this.anime = anime;
        this.frames = anime.length;
    }
    
    public void runAnimation()
    {
        index++;
        if (index > speed)
        {
            index = 0;
            nextFrame();
        }
    }
    
    public void nextFrame()
    {
        for (int k = 0; k < frames; k++)
        {
            if (count == k)
            {
                currentImage= anime[k];
            }         
            
        }
        count++;
        if (count > frames)
        {
            count = 0;
        }
    }
    
    public void drawAnimation(Graphics g, float x, float y)
    {
        g.drawImage(currentImage ,(int)x ,(int)y ,null);
    }
}
