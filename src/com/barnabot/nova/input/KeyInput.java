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

    /**
     * We will set this to our actual player, in the constructor
     * <br>We have this so we can easily access methods such as
     * <code>setVelX(int)</code> and <code>setVelY(int)</code>
     */
    private Player player;
    private boolean[] keyDown = new boolean[2]; //Set this to however many keys you wish to have smooth movement for, for the time being, I am only checking A and D
//I may add the W for jumping later on

    /**
     * Used to initialize attributes in the <code>KeyInput</code> class
     */
    public KeyInput()
    {
        for (CoreObject obj : Game.getInstance().getController().getObjects())
        { //Runs through the entire array list (for each CoreObject in the array list, do this)
            if (obj.getId() == Identities.PLAYER) //If the objects ID is equal to Identities.PLAYER (1) then do this
            {
                player = (Player) obj; //Sets our player attribute(above) to the object in our Controller
            }
        }
    }

    @Override
    /**
     * This is called when ever we push a button on our keyboard
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch (Game.state)
        {
            case GAME:
                if (key == KeyEvent.VK_W && !player.isJumping())
                {
                    player.setVelY(-13);
                    player.setJumping(true);
                }
// player.setVelY(-5); //because coordinates start from bottom down(y values), we need to subtract a value to go up
                if (key == KeyEvent.VK_A)
                {
                    player.setVelX(-5);
                    player.setMoving(true); //used to make the player start the animation process
                    player.setDirection(Direction.LEFT); //makes the player switch to the left facing sprites
                    keyDown[0] = true; //set the booleans to true!
                }
                if (key == KeyEvent.VK_D)
                {
                    player.setVelX(5);
                    player.setMoving(true);
                    player.setDirection(Direction.RIGHT); //makes the player switch to the right facing sprites
                    keyDown[1] = true;
                }
                break;
            case MENU:
                if (key == KeyEvent.VK_ESCAPE)
                {
                    System.out.println("exiting");
                    Game.exit();
                }
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
    /**
     * This is called when ever we release a button on our keyboard
     */
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        switch (Game.state)
        {
            case GAME:
                if (key == KeyEvent.VK_A)
                {
                    keyDown[0] = false; //if you only set the velocity here, it will freeze for a bit if you try to switch to D too quickly
                    player.setMoving(false); //used to make the player stop animating
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
                if (keyDown[0] && !keyDown[1]) //Do this if our A is still pushed
                {
                    player.setVelX(-5);
                }
                if (!keyDown[0] && keyDown[1]) //If D is still pushed
                {
                    player.setVelX(5);
                }
                if (!keyDown[0] && !keyDown[1]) //If neither are pushed
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

}
