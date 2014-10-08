/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.input;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class KeyInput extends KeyAdapter
{

    private static boolean[] keys = new boolean[256];

    @Override
    /**
     * This is called when ever we push a button on our keyboard
     */
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        keys[key] = true;
    }

    @Override
    /**
     * This is called when ever we release a button on our keyboard
     */
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        keys[key] = false;
    }

    public static boolean getKey(int key)
    {
        return keys[key];
    }

}
