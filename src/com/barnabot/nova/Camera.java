/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova;

import com.barnabot.nova.core.CoreObject;
import com.barnabot.nova.entity.Player;
import com.barnabot.nova.libs.Identities;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Camera
{
    private float x, y;
    private Player player;
 
    public Camera(float x, float y)
    {
        this.x = x;
        this.y = y;
        
        for (CoreObject obj : Game.getInstance().getController().getObjects())
        {
            if (obj.getId() == Identities.PLAYER)
            {
                player = (Player) obj;
            }
        }
    }
    
    /**
     * <strong>Algorithm</strong> used: Tweaning -> <code>x += (target - value) * constant</code>
    */
    public void tick()
    {
//        x = -player.getX() + Game.WIDTH / 2; // set the camera to make the player at the center of screen
        x += (( -player.getX() + Game.WIDTH / 2) - x) * 0.0275f;// camera follows with a delay
    }
    
    public float getX()
    {
        return x;
    }

   
    public float getY()
    {
        return y;
    }
}
