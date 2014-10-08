/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.entity;

import com.barnabot.nova.gfx.textures.Sprite;
import com.barnabot.nova.world.World;
import java.awt.Graphics;
import java.awt.Rectangle;


/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public abstract class Entity
{

    protected int x;
    protected int y;
    protected Sprite sprite;
    protected World world;

    public Entity(int x, int y, World world)
    {
        this.x = x;
        this.y = y;
        this.world = world;
        world.addEntity(this);
    }

    public abstract void tick();

    public void render(Graphics g)
    {
        sprite.render(g, x, y);
    }

    protected boolean hasHorizontalCollision()
    {
        return false;
    }

    protected boolean hasVerticalCollision()
    {
        return false;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public abstract Rectangle getTop();

    public abstract Rectangle getBottom();

    public abstract Rectangle getRight();

    public abstract Rectangle getLeft();

    public abstract Rectangle getBounds();
}
