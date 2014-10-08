/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.utils;

import com.barnabot.nova.libs.Audio;
import com.barnabot.nova.libs.Images;
import com.barnabot.nova.libs.Reference;
import java.io.IOException;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class ResourceLoader
{
    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
  
    
    public static void preLoad()
    {
        try
        {
            Images.loading = imageLoader.loadImage(Reference.LOADING_LOCATION + "/logo/Barnabot_Logo.fw.png");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void loadImages()
    {
        try
        {
            Images.title = imageLoader.loadImage(Reference.SPRITE_LOCATION + "title.png");
            System.out.println("title image loaded");
//            Images.spriteSheetBlocks = imageLoader.loadImage(Reference.SPRITE_LOCATION + "blocks32.png");
//            Images.spritesheetBlocks = imageLoader.loadImage("blocks32.png");
            Images.rockyBlocksHD = imageLoader.loadImage(Reference.SPRITE_LOCATION + "rocky_blocks.png");
            System.out.println("sprite rocky blocks HD image loaded");
            Images.spritesheetRockyBlocks = ImageModifier.resizeImage(Images.rockyBlocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);
            System.out.println("sprite rocky blocks image loaded");
            Images.metalBlocksHD = imageLoader.loadImage(Reference.SPRITE_LOCATION + "metal_blocks.png");
            System.out.println("sprite metal blocks HD image loaded");
            Images.spritesheetMetalBlocks = ImageModifier.resizeImage(Images.metalBlocksHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);
            System.out.println("sprite metal blocks image loaded");
            Images.liquidHD = imageLoader.loadImage(Reference.SPRITE_LOCATION + "liquid.png");
            System.out.println("sprite liquid image loaded");
            Images.spritesheetLiquid = ImageModifier.resizeImage(Images.liquidHD, Reference.ALPHA_RGB, 0, 0, 512, 512, 0.25);

//            System.out.println("sprite image loaded");
            Images.spriteSheetPlayer = imageLoader.loadImage(Reference.SPRITE_LOCATION + "female.png");
            System.out.println("sprite female loaded");
            Images.levelOne = imageLoader.loadImage(Reference.SPRITE_LOCATION + "levels/level1.png");
            System.out.println("level One loaded");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    
    public static void loadFonts()
    {
        Fonts.addFont(new Fonts("VIKING-N.TTF"));
    }
    
    public static void loadSounds()
    {
        AudioPlayer.addSound(Audio.SOUND_LASER, "Laser.ogg");
        AudioPlayer.addMusic(Audio.MUSIC_MOON, "Moon.ogg");
    }
    
}
