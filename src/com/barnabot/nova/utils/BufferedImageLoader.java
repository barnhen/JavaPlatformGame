/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique Barnabe
 */
public class BufferedImageLoader
{
    private BufferedImage image;
    
    public BufferedImage loadImage(String imagePath) throws IOException
    {
        image = ImageIO.read(new File(imagePath));
        return image;
    }
    
}
