/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.main;


import com.barnabot.nova.Game;
import com.barnabot.nova.entity.Player;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Camera
{
    private float  x = 0, y = 0;

    /**
     * <strong>Algorithm</strong> used: Tweaning -> <code>x += (target - value) * constant</code>
    */
    public void tick(Player player)
    {
//        x = -player.getX() + Game.WIDTH / 2; // set the camera to make the player at the center of screen
//        x += (( -player.getX() + Game.WIDTH / 2) - x) * 0.0275f;// camera follows with a delay
            x += (( -player.getX() + Game.WIDTH / 2) - x) * 0.0875f;// camera follows with a delay
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
