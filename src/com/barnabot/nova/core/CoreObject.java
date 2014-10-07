/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.core;

import com.barnabot.nova.gfx.Textures;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public abstract class CoreObject
{
    protected float x, y, velX,velY;

    protected int id;
   
    protected int width;
    protected int height;
    
    protected Textures tex;
    
    protected BufferedImage image;
    
    public CoreObject(float x, float y,int id, Textures tex)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.tex = tex;
    }
    
    public CoreObject(float x, float y,int id, BufferedImage image)
    {
        this.x = x;
        this.y = y;
        this.id = id;
        this.image = image;
    }
    
    //updates the game
    public abstract void tick();
    
    public abstract void render(Graphics g);
    {
    
    }
    
    public Rectangle getTopBounds()
    {
        return new Rectangle((int)x ,(int)y ,width ,8);
    }
    
    public Rectangle getBottomBounds()
    {
        return new Rectangle((int)x ,(int)y + (height - 6) ,width ,12);
    }
    
    public Rectangle getRightBounds()
    {
        return new Rectangle((int)x + (width - 6), (int)y, 6 ,height);
    }
    
    public Rectangle getLeftBounds()
    {
        return new Rectangle((int)x ,(int)y ,6 , height);
    }
    
    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public long getId()
    {
        return id;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public void setVelX(float velX)
    {
        this.velX = velX;
    }

    public void setVelY(float velY)
    {
        this.velY = velY;
    }
    
    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }
    
    public void setSize(int width, int height)
    {
        this.width = width;
        this.height = height;
    }
}
