/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.screens;

import com.barnabot.nova.Game;
import com.barnabot.nova.enums.GameState;
import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.utils.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Henrique Barnabe
 */
public class Menu
{

    private Button play, options, quit; //Our buttons on the menu

    /**
     * Creates a new menu with the play, options, and quit buttons
     */
    public Menu()
    {
        int fillerY = 150; //used to facilitate the placing of the buttons vertically
        play = new Button(Reference.CENTER_X - 100, fillerY, 200, 50, GameState.GAME, Reference.SOUND_LASER).setText("Play");
        options = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50, GameState.OPTIONS, Reference.SOUND_LASER).setText("Options");
        quit = new Button(Reference.CENTER_X - 100, fillerY += 60, 200, 50, GameState.MENU, Reference.SOUND_LASER, true).setText("Quit");
    }

    /**
     * Draws the menu
     *
     * @param g the Graphics context of our <strong> <code> Game class </strong>
     * </code>
     */
    public void render(Graphics g)
    {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
        g.setColor(new Color(255, 120, 0));
        g.setFont(new Font("Neuropol", Font.PLAIN, 50));
        g.drawString(Game.TITLE, 50, 50);
        g.setFont(new Font("Planet Kosmos", Font.PLAIN, 32)); //sets the font of the text on the buttons
        play.drawButton(g, 55);
        options.drawButton(g, 15);
        quit.drawButton(g, 55);
    }

}
