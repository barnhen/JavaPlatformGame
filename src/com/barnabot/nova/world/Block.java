/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.world;

import com.barnabot.nova.gfx.textures.Sprite;
import com.barnabot.nova.gfx.textures.SpriteSheet;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Block
{

    private static final SpriteSheet sheet = new SpriteSheet("terrain.png");
    private static Map<Integer, Block> blockMap = new HashMap<Integer, Block>(); //so we can remember the IDs and blocks/sprites associated with it
    private int id;
    private int x;
    private int y;
    private Sprite sprite;
    public static final Block block1 = new Block(0xFFFFFFFF, new Sprite(1, 1, 32, sheet));
    public static final Block block2 = new Block(0xFFFF0000, new Sprite(2, 1, 32, sheet));

    private Block(int id, Sprite sprite)
    { //yeah, I know, we need a better system, it will be better once I find a way to make collision be friendly when there is
// only 1 object of each type, just being renderered multiple times
        this.id = id;
        this.sprite = sprite;
        blockMap.put(id, this);
    }

    public Block(int id, int x, int y)
    {
        this.sprite = getFromID(id);
        this.x = x * 32;
        this.y = y * 32;
    }

    public void render(Graphics g)
    {
        sprite.render(g, x, y);
    }

    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 32, 32);
    }

    public Rectangle getTop()
    {
        return new Rectangle(x + 4, y, 24, 4);
    }

    public Rectangle getBottom()
    {
        return new Rectangle(x + 4, y + 28, 24, 4);
    }

    public Rectangle getRight()
    {
        return new Rectangle(x, y, 4, 32);
    }

    public Rectangle getLeft()
    {
        return new Rectangle(x + 28, y, 4, 32);
    }

    public static Sprite getFromID(int id)
    {
        if (blockMap.get(id) != null)
        {
            return blockMap.get(id).sprite;
        }
        return null;
    }
}
