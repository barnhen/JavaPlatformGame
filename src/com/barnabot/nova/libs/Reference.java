/*
 * Created by Henrique Barnabe. 2014 root.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.libs;

import com.barnabot.nova.Game;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe
 */
public class Reference
{
    
//    static
//    {
//        Properties prop = new Properties();
//        InputStream stream = Reference.class.getClassLoader().getResourceAsStream("version.properties");
//        try
//        {
//            prop.load(stream);
//            stream.close();
//        }
//        catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        VERSION = prop.getProperty("version");
//    }

    
    
    public static final int CENTER_X = Game.WIDTH /2;
    public static final int CENTER_Y = Game.HEIGHT /2;
    
    public static final String RESOURCE_LOCATION = "./resources/";
    public static final String SPRITE_LOCATION = RESOURCE_LOCATION + "sprites/";
    public static final String FONT_LOCATION = RESOURCE_LOCATION + "fonts/";
    public static final String SOUND_LOCATION = RESOURCE_LOCATION + "sounds/";
    public static final String LOADING_LOCATION = RESOURCE_LOCATION + "loading/";
    
    public static final int ALPHA_RGB = BufferedImage.TYPE_INT_ARGB;
    
    /**
     *k
     */
    public static final String VERSION = "1.0.0";
    
    /*
     * AUDIO
    */
    public static final String SOUND_LASER = "laser";
    public static final String MUSIC_MOON = "moon";
}
