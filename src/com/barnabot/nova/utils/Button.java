/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.utils;

import com.barnabot.nova.Game;
import com.barnabot.nova.enums.GameState;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
@SuppressWarnings("serial")
public class Button extends Rectangle implements MouseListener, MouseMotionListener
{

    private String text;
    private String sound;
    private GameState state;
    private boolean isQuit, pressed;
    private boolean soundPlayed = false;
    private int hoverX, hoverY, clickX, clickY, pressX, pressY;

    /**
     * Creates a button from a specified top-left corner and a specified width
     * and height
     *
     * @param x The far-left x-value of the button
     * @param y The highest y-value of the button
     * @param width The width of the button
     * @param height The height of the button
     */
    public Button(int x, int y, int width, int height)
    {
        super(x, y, width, height);
    }

    public Button(int x, int y, int width, int height, GameState state, String sound)
    {
        this(x, y, width, height);
        this.state = state;
        this.sound = sound;
    }

    public Button(int x, int y, int width, int height, GameState state, String sound, boolean isQuit)
    {
        this(x, y, width, height, state, sound);
        this.isQuit = isQuit;
    }

    /**
     * Sets the text to be displayed on the button
     *
     * @param text the text displayed on the button
     * @return this
     */
    public Button setText(String text)
    {
        this.text = text;
        return this;
    }

    /**
     * Utility method to facilitate the drawing of rectangles for our buttons
     *
     * @param g the Graphics context of our <strong> <code> Game class </strong>
     * </code>
     * @param offset The horizontal offset determines how to far or near to the
     * left of the button to start drawing the rectangle
     */
    public void drawButton(Graphics g, int offset)
    {
        int xx = x + offset;
        int yy = y + 38;
        if (this.contains(hoverX, hoverY)) //show our buttons in yellow when our mouse hovers over them
        {
            g.setColor(Color.YELLOW);
        }
        else //other wise, show the button in white
        {
            g.setColor(Color.WHITE);
        }
        if (!pressed && this.contains(pressX, pressY))
        {
            g.drawRect(x, y, width, height);
        }
        else if (pressed && this.contains(pressX, pressY)) //fills in the button when we press it
        {
            g.fillRect(x, y, width, height);
        }
        else
        {
            g.drawRect(x, y, width, height);
        }
        g.setColor(Color.RED);
        g.drawString(text, xx, yy);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        clickX = e.getX();
        clickY = e.getY();
        if (!isQuit)
        {
            AudioPlayer.playSound(sound);
            Game.state = state;
        }
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        pressed = true;
        pressX = e.getX();
        pressY = e.getY();
        if (isQuit)
        {
            AudioPlayer.playSound(sound);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        pressed = false;
        pressX = e.getX();
        pressY = e.getY();
        if (isQuit)
        {
            Game.exit();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e)
    {
        hoverX = e.getX();
        hoverY = e.getY();
        if (this.contains(hoverX, hoverY))
        {
            if (!soundPlayed)
            {
                AudioPlayer.playSound(sound);
                soundPlayed = true;
            }
        }
        else
        {
            soundPlayed = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
    }

    @Override
    public void mouseDragged(MouseEvent e)
    {
    }

}
