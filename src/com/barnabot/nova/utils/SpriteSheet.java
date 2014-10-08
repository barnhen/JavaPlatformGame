/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class SpriteSheet
{
    private BufferedImage image;
    private int width;
    private int height;
    
//    public SpriteSheet(BufferedImage image, int width)
    /**
    * Creates a new spritesheet
    * @param image the textures
    * @param size the width and height of each single sprite
    */
    public SpriteSheet(BufferedImage image, int size)
    {
        this.image = image;
//        this.width = width;
//        this.height = width;
        this.width = size;
        this.height = size;
    }
    
    /**
    * Creates a new spritesheet
    * @param image the textures
    * @param width the width of each single sprite
    * @param height the height of each single sprite
    */
    public SpriteSheet (BufferedImage image, int width, int height)
    {
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    /**
    * Obtain a single sprite from a spritesheet
    * @param col the 'x' coordinate
    * @param row the 'y' coordinate
    * @return the single sprite
    */
    public BufferedImage getSprite(int col, int row)
    {
        return image.getSubimage((col * width) - width, (row * height) - height, width, height);
    }
}
