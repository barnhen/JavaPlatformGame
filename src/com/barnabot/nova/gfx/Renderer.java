/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.gfx;

import com.barnabot.nova.Game;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Henrique Barnabe
 */
public class Renderer
{
//    private static Game game = Game.getInstance();
    //rendering building, ateroids that are flying in the background, stars... 
    public void renderBackground(Graphics g)
    {
        switch(Game.state)
        {
            case GAME:
                break;
            case MENU:
                Game.getInstance().getMenu().Render(g);
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("Unknown GAME STATE", 150, 150);
                break;
                    
            
        }
   }
    
    public void renderForeground(Graphics g)
    {
        switch(Game.state)
        {
           case GAME:
                Game.getInstance().getController().render(g);
                break;
           case MENU:
                break;
           case OPTIONS:
            break;
           case PAUSE:
                break;
           default:
                g.setColor(Color.RED);
                g.drawString("Unknown GAME STATE", 150, 150);
                break;
            
            
        }
    }
}
