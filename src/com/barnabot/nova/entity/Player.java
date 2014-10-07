/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.entity;

import com.barnabot.nova.Game;
import com.barnabot.nova.core.CoreObject;
import com.barnabot.nova.enums.Direction;
import com.barnabot.nova.gfx.Animation;
import com.barnabot.nova.gfx.Textures;
import com.barnabot.nova.objects.Block;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Player extends CoreObject
{

    private static ArrayList<CoreObject> gameObjects = Game.getInstance().getController().getObjects();
    
    private float gravity = 0.55f; // (old 0.98f)gravity is 9.98
    private boolean falling = true;
    private boolean jumping = false;
    private boolean moving = false;

    
    private Animation animeRight;
    private Animation animeLeft;
    
    private Direction direction = Direction.RIGHT;

       
    public Player(float x, float y, int id, Textures tex)
    {
        super(x, y, id, tex);
        this.setSize(32, 70); //old height 70
        animeRight = new Animation(3, tex.playerRight);
        animeLeft = new Animation(3, tex.playerLeft);
    }

    @Override
    public void tick()
    {
        x += velX;
        y += velY;
        fall();
        checkCollision();
        if (moving)
        {
            if (direction == Direction.RIGHT)
            {
                animeRight.runAnimation();
            }
            else if (direction == Direction.LEFT)
            {
                animeLeft.runAnimation();
            }
            
        }
        
    }

    @Override
    public void render(Graphics g)
    {
//        g.drawImage(tex.blockStone, x, y, null);
        
//        g.setColor(Color.WHITE);
//        g.fillRect((int)x, (int)y, width, height);
        if (!moving)
        {
            if (direction == Direction.RIGHT)
            {
                g.drawImage(tex.playerStandingRight, (int)x, (int)y, null);
            }
            else if (direction == Direction.LEFT)
            {
                g.drawImage(tex.playerStandingLeft, (int)x, (int)y, null);
            }
            
        }
        else
        {
            if (direction == Direction.RIGHT)
            {
                animeRight.drawAnimation(g, x, y);
            }
            else if (direction == Direction.LEFT)
            {
                animeLeft.drawAnimation(g, x, y);
            }
            
        }
    }
    
    public void checkCollision()
    {
        for(CoreObject obj : gameObjects)
        {
            if(obj instanceof Block)
            {                
                if(getBottomBounds().intersects(obj.getTopBounds()))
                {
                    velY = 0;
                    y = obj.getY() - height;
                    //then the block hit the ground
                    jumping = false;
                
                }
                if(getTopBounds().intersects(obj.getBottomBounds()))
                {
                    fall();
                    y = obj.getY() + obj.getHeight();
                
                }
                
                if (getRightBounds().intersects(obj.getLeftBounds()))
                {
                    velX = 0;
                    x = obj.getX() - width;
                
                }
                
                if (getLeftBounds().intersects(obj.getRightBounds()))
                {
                    velX = 0;
                    x = obj.getX() + obj.getWidth();
                
                }
            }
        }
    
    }
    
    public void fall()
    {
        if (falling)
        {
            velY += gravity;
        }
    }
    
    
    public boolean isJumping()
    {
        return jumping;
    }

    public void setJumping(boolean jumping)
    {
        this.jumping = jumping;
    }
    
    public boolean isMoving()
    {
        return moving;
    }

    /**
     * @param moving: is the playerStandingRight moving?
    */
    public void setMoving(boolean moving)
    {
        this.moving = moving;
    }
    
    public void setDirection (Direction direction)
    {
        this.direction = direction;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
  
    
}
