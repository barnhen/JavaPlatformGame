/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.input;

import com.barnabot.nova.Game;
import com.barnabot.nova.enums.GameState;
import com.barnabot.nova.libs.Audio;
import com.barnabot.nova.screens.Menu;
import com.barnabot.nova.utils.AudioPlayer;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class MouseInput extends MouseAdapter
{
    
    public static boolean pressed = false;
    
    public static int MOUSE_X, MOUSE_Y; 
    public static Rectangle MOUSE = new Rectangle(1,1,1,1);
    
    private Menu menu = Game.getInstance().getMenu();
    
    @Override
    public void mouseClicked(MouseEvent e)
    {
        int mouse = e.getButton();
        Rectangle rect = new Rectangle(e.getX(),e.getY(),1,1);
//        pressed = true;
        
        if(mouse == MouseEvent.BUTTON1)
        {
            switch(Game.state)
            {
                case GAME:
                    break;
                case MENU:
                    if (rect.intersects(menu.play))
                    {
                        AudioPlayer.playSound(Audio.SOUND_LASER);
                        Game.getInstance().levelOne.loadLevel();
                        Game.state = GameState.GAME;
                    }
                    else if (rect.intersects(menu.options))
                    {
                    
                        AudioPlayer.playSound(Audio.SOUND_LASER);
                        Game.state = GameState.OPTIONS;
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
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        pressed = true;
        MOUSE = new Rectangle(e.getX(),e.getY(),1,1);
        if(Game.state == GameState.MENU)
        {
            if(MOUSE.intersects(menu.quit))
            {
                AudioPlayer.playSound(Audio.SOUND_LASER);
            }
        }
    }
    
    
    
    @Override
    public void mouseReleased(MouseEvent e)
    {
        pressed = false;
        
        MOUSE = new Rectangle(e.getX(),e.getY(),1,1);
        if(Game.state == GameState.MENU)
        {
            if(MOUSE.intersects(menu.quit))
            {
                Game.exit();
            }
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e)
    {
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();
        MOUSE = new Rectangle(MOUSE_X, MOUSE_Y,1,1);
        
        switch (Game.state)
        {
            case GAME:
                break;
            case MENU:
                if((MOUSE.intersects(menu.play) || 
                    MOUSE.intersects(menu.options) ||
                    MOUSE.intersects(menu.quit)) &&
                    !AudioPlayer.hasPlayedHover)
                {
                    AudioPlayer.playSound(Audio.SOUND_LASER);
                    AudioPlayer.hasPlayedHover = true;
                }
                else if(!(MOUSE.intersects(menu.play) || 
                        MOUSE.intersects(menu.options) ||
                        MOUSE.intersects(menu.quit)) &&
                       AudioPlayer.hasPlayedHover
                        )
                {
                    AudioPlayer.hasPlayedHover = false;
                }
                else
                {
                
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
}
