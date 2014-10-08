/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.entity.mobs;

import com.barnabot.nova.entity.Entity;
import com.barnabot.nova.enums.Direction;
import com.barnabot.nova.gfx.Animation;
import com.barnabot.nova.gfx.textures.Sprite;
import com.barnabot.nova.world.World;
import java.awt.Graphics;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 * Entity class that move (i.e. mob...ile)
 */
public abstract class Mob extends Entity
{

    protected float velX;
    protected float velY;
    protected int maxVelY = 7;
    protected float gravity = 0.5f;
    protected Direction direction = Direction.RIGHT;
    protected boolean falling = true; //true;
    protected boolean jumping = false;
    protected boolean moving = false;
    protected Animation animeLeft;
    protected Animation animeRight;
    protected Sprite sprite2;

    public Mob(int x, int y, World world)
    {
        super(x, y, world);
    }

    @Override
    public void tick()
    {
        if (velX > 0)
        {
            direction = Direction.RIGHT;
        }
        else if (velX < 0)
        {
            direction = Direction.LEFT;
        }
        if (!hasHorizontalCollision())
        {
            x += velX;
        }
        if (!hasVerticalCollision())
        {
            y += velY;
        }
        fall();
        if (velX != 0)
        {
            moving = true;
        }
        else
        {
            moving = false;
        }
        if (moving)
        {
            getAnimation().runAnimation();
        }
    }

    @Override
    public void render(Graphics g)
    {
        if (moving)
        {
            getAnimation().drawAnimation(g, x, y);
        }
        else
        {
            getStandingStill().render(g, x, y);
        }
    }

    protected void fall()
    {
        if (falling)
        {
            velY += gravity;
            if (velY > maxVelY)
            {
                velY = maxVelY;
            }
        }
    }

    public Direction getDirection()
    {
        return direction;
    }

    public boolean isMoving()
    {
        return moving;
    }

    public Animation getAnimation()
    {
        return direction == Direction.LEFT ? animeLeft : animeRight;
    }

    public Sprite getStandingStill()
    {
        return direction == Direction.LEFT ? sprite : sprite2;
    }
}
