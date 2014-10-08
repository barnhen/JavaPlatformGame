/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.libs.Reference;
import java.io.IOException;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class ResourceLoader
{

    /**
     * Loads all of the fonts to be used in the game
     */
    public static void loadFonts()
    {
        Fonts.addFont(new Fonts("VIKING-N.TTF"));
        Fonts.addFont(new Fonts("NEUROPOL.TTF"));
        Fonts.addFont(new Fonts("PLANK___.TTF"));
    }
    
    /**
     * Load sounds into the game<br>
     * This includes <code>Sound</code> Effects and <code>Music</code>
     */
    public static void loadSounds()
    {
        AudioPlayer.addSound(Reference.SOUND_LASER, "Laser.ogg");
        AudioPlayer.addMusic(Reference.MUSIC_MOON, "Moon.ogg");
    }
    
}
