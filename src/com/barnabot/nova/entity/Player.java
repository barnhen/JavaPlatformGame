/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.entity;

import com.barnabot.nova.gfx.Animation;
import com.barnabot.nova.gfx.textures.Sprite;
import com.barnabot.nova.gfx.textures.SpriteSheet;
import com.barnabot.nova.input.KeyInput;
import com.barnabot.nova.entity.mobs.Mob;
import com.barnabot.nova.world.Block;
import com.barnabot.nova.world.World;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.utils.AudioPlayer;


/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Player extends Mob
{

    private static SpriteSheet sheet = new SpriteSheet("player.png");

    public Player(int x, int y, World world)
    {
        super(x, y, world);
        sprite = new Sprite(2, 1, 50, sheet);
        sprite2 = new Sprite(1, 1, 50, sheet);
        Sprite[] rights = new Sprite[]
        {
            new Sprite(1, 2, 50, sheet),
            new Sprite(2, 2, 50, sheet),
            new Sprite(3, 2, 50, sheet),
            new Sprite(4, 2, 50, sheet),
            new Sprite(5, 2, 50, sheet),
            new Sprite(1, 3, 50, sheet),
            new Sprite(2, 3, 50, sheet),
            new Sprite(3, 3, 50, sheet)
        };
        Sprite[] lefts = new Sprite[]
        {
            new Sprite(1, 4, 50, sheet),
            new Sprite(2, 4, 50, sheet),
            new Sprite(3, 4, 50, sheet),
            new Sprite(4, 4, 50, sheet),
            new Sprite(5, 4, 50, sheet),
            new Sprite(1, 5, 50, sheet),
            new Sprite(2, 5, 50, sheet),
            new Sprite(3, 5, 50, sheet)
        };
        animeLeft = new Animation(5, lefts);
        animeRight = new Animation(5, rights);
    }

    @Override
    public void tick()
    {
        velX = 0;
        if (KeyInput.getKey(KeyEvent.VK_D))
        {
            velX += 3;
        }
        if (KeyInput.getKey(KeyEvent.VK_A))
        {
            velX -= 3;
        }
        if (KeyInput.getKey(KeyEvent.VK_W) && !jumping)
        {
            jumping = true;
            velY = -10;
        }
        super.tick();
    }

    @Override
    protected boolean hasVerticalCollision()
    { //because our collision methods are now seperated, we have pixel perfect collision
        for (int i = 0; i < world.getBlocks().size(); i++)
        {
            Block block = world.getBlocks().get(i);
//if velY > 0 that means we are trying to jump, so it should let us
            if (getBottom().intersects(block.getTop()) && velY > 0)
            {
                jumping = false; //when we are on the ground, we need to re-allow the player to jump
                return true;
            }
//if we are jumping and hit the ceiling
            if (getTop().intersects(block.getBottom()) && velY < 0)
            {
                velY = 0;
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean hasHorizontalCollision()
    {
        for (int i = 0; i < world.getBlocks().size(); i++)
        {
            Block block = world.getBlocks().get(i);
            if (getRight().intersects(block.getRight()) && velX > 0)
            {
                return true;
            }
            if (getLeft().intersects(block.getLeft()) && velX < 0)
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public Rectangle getTop()
    {
        return new Rectangle(x + 16, y + 4, 12, 4);
    }

    @Override
    public Rectangle getBottom()
    {
        return new Rectangle(x + 13, y + 50, 23, 4);
    }

    @Override
    public Rectangle getRight()
    {
        return new Rectangle(x + 41, y + 8, 4, 40);
    }

    @Override
    public Rectangle getLeft()
    {
        return new Rectangle(x + 10, y + 8, 4, 40);
    }

    @Override
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, 50, 50);
    }
}
