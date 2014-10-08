/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.gfx.textures;

import com.barnabot.nova.libs.Reference;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class SpriteSheet
{

    private String path;
    private BufferedImage image;

    public SpriteSheet(String path)
    {
        this.path = path;
        load();
    }

    private void load()
    {
        File file = null;
        try
        {
            file = new File(Reference.SPRITE_LOCATION + path);
            image = ImageIO.read(file);
        }
        catch (IOException e)
        {
            System.err.println("Make sure file < " + path + " > is in " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }

    public BufferedImage getSprite(int x, int y, int size)
    {
        return image.getSubimage((x * size) - size, (y * size) - size, size, size);
    }

}
