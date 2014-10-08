/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.input;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class MouseInput extends MouseAdapter
{

    public static final int BUTTON_LEFT = 0x1;
    public static final int BUTTON_RIGHT = 0x3;
    
    private static boolean[] buttons = new boolean[5];
    public static int clickX, clickY, hoverX, hoverY, pressX, pressY;
    
    @Override
    /**
    * This method is called whenever a mouse button is clicked
    */
    public void mouseClicked(MouseEvent e) {
        int mouse = e.getButton(); //used to check what button was clicked
        clickX = e.getX();
        clickY = e.getY();
    }
    @Override
    /**
    * This is called while we have a mouse button held down
    */
    public void mousePressed(MouseEvent e) {
        pressX = e.getX();
        pressY = e.getY();
        buttons[e.getButton()] = true;
    }
    @Override
    /**
    * This is called whenever we release the mouse button
    */
    public void mouseReleased(MouseEvent e) {
        buttons[e.getButton()] = false;
    }

}
