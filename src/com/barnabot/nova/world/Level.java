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
import com.barnabot.nova.entity.Player;
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

    /**
     * Creates a new level
     *
     * @param levelNumber determines which level it is and what image to use
     */
    public Level(int levelNumber)
    {
        switch (levelNumber)
        {
            case 1:
                image = Images.levelOne;
                break;
            default:
                image = Images.levelOne;
        }
    }

    /**
     * Uses color decryption to parse through every pixel and place blocks where
     * a pixel meets the requirements<p>
     * <strong>Example:</strong> If the pixel has red value of 255, green value
     * of 0 and blue value of 0, then it will automatically place our metal
     * block<br>
     * <strong>Example 2:</strong> If the pixel is all white (all values are
     * 255) then it will automatically place our stone block<p>
     * <i>Note that this system is intended for shades of red, though it is very
     * easy and should be very obvious as to how to make it accept different
     * colors</i>
     */
    public void loadLevel()
    {
        int w = image.getWidth(); //make sure your image file is bigger than however many pixels you are actually going to use
        int h = image.getHeight();
        for (int x = 0; x < w; x++)
        {
            for (int y = 0; y < h; y++)
            { //check every single pixel with this nested loop
                int pixel = image.getRGB(x, y); //this gets the pixel's rgb value in the TYPE_INT_ARGB format
                int red = (pixel >> 16) & 0xff; //shifts the value right by 16 places to get our red value
                int green = (pixel >> 8) & 0xff; //shifts the value right by 8 places to get our green value
                int blue = (pixel) & 0xff;
                if (red == 255 && green == 255 && blue == 0)
                {
                    controller.addObject(new Player(x * 32, y * 32, Identities.PLAYER, tex));
                }
                else if (red == 255 && green == 255 && blue == 255) //if the pixel is all white
                {
                    addBlock(x, y, Identities.BLOCK_ASTEROID_CENTER, tex.blockAsteroidCenter);
                }
                else
                {
                    if (red == 255) //pure red
                    {
                        addBlock(x, y, Identities.BLOCK_ASTEROID_TOP_RIGHT, tex.blockAsteroidTopRight);
                    }
                    if (red == 250)
                    {
                        addBlock(x, y, Identities.BLOCK_ASTEROID_TOP_LEFT, tex.blockAsteroidTopLeft);
                    }
                    if (red == 245)
                    {
                        addBlock(x, y, Identities.BLOCK_ASTEROID_TOP, tex.blockAsteroidTop);
                    }
                    if (red == 240)
                    {
                        addBlock(x, y, Identities.BLOCK_ASTEROID_TOP_SIDES, tex.blockAsteroidTopSides);
                    }
                    if (red == 150)
                    {
                        addBlock(x, y, Identities.BLOCK_METAL_GRIP, tex.blockMetalGrip);
                    }
                    if (red == 140)
                    {
                        addBlock(x, y, Identities.BLOCK_METAL_SHEET, tex.blockMetalSheet);
                    }
                    if (green == 255)
                    {
                        addBlock(x, y, Identities.LIQUID_LAVA, tex.lava);
                    }
                }
            }
        }
    }

    private void addBlock(int x, int y, int id, BufferedImage texture)
    {
        controller.addObject(new Block(x * 32, y * 32, id, texture));
    }
}
