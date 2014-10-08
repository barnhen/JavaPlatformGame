/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.libs.Reference;
import com.barnabot.nova.screens.LoadScreen;
import java.util.HashMap;
import java.util.Map;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class AudioPlayer
{
    
    private static Map<String, Sound> soundMap = new HashMap<String, Sound>();
    
    private static Map<String, Music> musicMap = new HashMap<String, Music>();
    
    public static boolean hasPlayedHover = false;
    
    public static void addMusic(String key, String path)
    {
        LoadScreen.setMessage("Loading musics from " + Reference.SOUND_LOCATION);
        try
        {
            musicMap.put(key, new Music(Reference.SOUND_LOCATION + path));
            
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
   
    
    public static void addSound(String key, String path)
    {
        LoadScreen.setMessage("Loading sounds from " + Reference.SOUND_LOCATION);
        try
        {
            soundMap.put(key, new Sound(Reference.SOUND_LOCATION + path));
            
        }
        catch (SlickException e)
        {
            e.printStackTrace();
        }
    }
    
    public static Sound getSound(String key)
    {
        return soundMap.get(key);
    }
       
    public static Music getMusic(String key)
    {
        return musicMap.get(key);
    }
    
    public static void playSound(String key)
    {
        soundMap.get(key).play();
        
    }
    
    public static void playMusic(String key)
    {
        musicMap.get(key).loop(1f,1f);
    }
    
}
