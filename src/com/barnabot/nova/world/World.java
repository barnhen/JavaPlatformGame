/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.world;

import com.barnabot.nova.entity.Entity;
import com.barnabot.nova.entity.Player;
import com.barnabot.nova.libs.Reference;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class World
{

    private ArrayList<Entity> entities = new ArrayList<Entity>();
    private ArrayList<Block> blocks = new ArrayList<Block>();
    private int width;
    private int height;
    private int[] pixels;

    public World(String path)
    {
        BufferedImage image = null;
        try
        {
            image = ImageIO.read(new File(Reference.SPRITE_LOCATION + "levels/" + path));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        width = image.getWidth();
        height = image.getHeight();
        pixels = new int[width * height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
//pixels[x + y * width] gives us the hex of the pixel at the x, y location on the file
                if (Block.getFromID(pixels[x + y * width]) != null) //only add the block if there is a non-null block
                {
                    blocks.add(new Block(pixels[x + y * width], x, y));
                }
            }
        }
    }

    public void tick()
    {
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).tick();
    }

    public void render(Graphics g)
	{
        for(int i = 0; i < blocks.size(); i++)
            blocks.get(i).render(g);
        for(int i = 0; i < entities.size(); i++)
            entities.get(i).render(g);
    }

    public void addEntity(Entity e)
    {
        entities.add(e);
    }

    public ArrayList<Entity> getEntities()
    {
        return entities;
    }

    public ArrayList<Block> getBlocks()
	{
        return blocks;
    }
    public void removeEntity(int index)
	{
        entities.remove(index);
    }
	
    public Player getPlayer()
	{
        for(Entity e : entities)
            if(e instanceof Player) return (Player) e;
        return null;
    }
}
