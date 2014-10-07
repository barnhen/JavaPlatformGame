/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.input;

import com.barnabot.nova.Game;
import com.barnabot.nova.core.CoreObject;
import com.barnabot.nova.entity.Player;
import com.barnabot.nova.enums.Direction;
import com.barnabot.nova.libs.Identities;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class KeyInput extends KeyAdapter
{
    private Player player;
    
    private boolean[] keyDown = new boolean[2];
    
    public KeyInput()
    {
        for(CoreObject obj : Game.getInstance().getController().getObjects())
        {
            if(obj.getId() == Identities.PLAYER)
            {
                player = (Player) obj;
            }
        }
    }



    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        switch(Game.state)
        {
            case GAME:
                if (key == KeyEvent.VK_W && !player.isJumping())
                {
                    player.setVelY(-13); // how tall will the player jump
                    player.setJumping(true);
//                    player.setVelY(-5);
                }
                if (key == KeyEvent.VK_A)
                {
                    player.setVelX(-5);
                    player.setMoving(true);
                    player.setDirection(Direction.LEFT);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_D)
                {
                    player.setVelX(5);
                    player.setMoving(true);
                    player.setDirection(Direction.RIGHT);
                    keyDown[1] = true;
                }
                break;
            case MENU:
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;
        
        }
            
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        
        switch(Game.state)
        {
            case GAME:
                if (key == KeyEvent.VK_W)
                {
                    player.setVelY(0);
                }
                if (key == KeyEvent.VK_A)
                {                   
                    keyDown[0] = false;
                    player.setMoving(false);
                }
                if (key == KeyEvent.VK_D)
                {
                    keyDown[1] = false;
                    player.setMoving(false);
                }
                /**
                 * Below is for smooth movement . ie. you hold both left and right key 
                 * and release one the player stops first and then continue moving to the key
                 * direction which was not released yet. With this smoothness if
                 * you hold both left and right key 
                 * and release one the player continue moving to the key without stopping first
                */
                if (keyDown[0] && !keyDown[1])
                {
                    player.setVelX(-5);
                }
                if (!keyDown[0] && keyDown[1])
                {
                    player.setVelX(5);
//                    player.setMoving(false);
                }
                //if not 'a' nor 'd' is keydown then we stop moving
                if (!keyDown[0] && !keyDown[1])
                {
                    player.setVelX(0);
                }
                
                
                break;
            case MENU:
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                break;
        
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        super.keyTyped(e); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
