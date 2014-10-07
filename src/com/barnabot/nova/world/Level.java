/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.world;

import com.barnabot.nova.Controller;
import com.barnabot.nova.Game;
import com.barnabot.nova.gfx.Textures;
import com.barnabot.nova.libs.Identities;
import com.barnabot.nova.libs.Images;
import com.barnabot.nova.objects.Block;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Level
{
    private BufferedImage image;
    private Controller controller = Game.getInstance().getController();
    private Textures tex = Game.getInstance().getTextureHandler();
    
    public Level(int levelNumber)
    {
        switch(levelNumber)
        {
            case 1:
                image = Images.levelOne;
                break;
            default:
                image = Images.levelOne;
                break;
        
        }
    }
    
    public void loadLevel()
    {
        int w = image.getWidth();
        int h = image.getHeight();
        
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            {
                int pixel = image.getRGB(x, y);
                int red = (pixel >> 16) & 0xff; // '>>' means to move our pixel to another position
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                
                if(red == 255 && green == 255 && blue == 255) // if these params are all white
                {
                    controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_STONE, tex.blockStone));
                }
                else
                {
                    if(red == 255) // if it is shade of red
                    {
                        controller.addObject(new Block(x * 32, y * 32, Identities.BLOCK_METAL, tex.blockMetal));
                    }
                }
            }
        }
    }
}
