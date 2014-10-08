/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.gfx;

import com.barnabot.nova.libs.Images;
import com.barnabot.nova.utils.SpriteSheet;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Textures
{
//    private SpriteSheet sheetTest;
//    private SpriteSheet blockSheet;
    private SpriteSheet rockSheet;
    private SpriteSheet metalSheet;
    private SpriteSheet liquidSheet;
    private SpriteSheet playerSheet;
    
    /*
     * Game Object Images
     */
    public BufferedImage playerStandingRight;
    public BufferedImage playerStandingLeft;
    public BufferedImage playerRight[] = new BufferedImage[4];
    public BufferedImage playerLeft[] = new BufferedImage[4];
    
    /*
    * Block textures
    */
//    public BufferedImage blockMetal;
//    public BufferedImage blockStone;
    
    public BufferedImage blockAsteroidCenter;
    public BufferedImage blockAsteroidTopRight;
    public BufferedImage blockAsteroidTopLeft;
    public BufferedImage blockAsteroidTopSides;
    public BufferedImage blockAsteroidTop;

    public BufferedImage blockMetalGrip;
    public BufferedImage blockMetalLined;
    public BufferedImage blockMetalSheet;
    public BufferedImage blockMetalRough;
    public BufferedImage blockMetalSmooth;

    /*
    * Liquid textures
    */
    public BufferedImage lava;
    public BufferedImage toxicWaste;
    public BufferedImage water;
    public BufferedImage coldWater;
   /**
   * Constructs the texture container
   */
    public Textures()
    {
//        sheetTest = new SpriteSheet(Images.spriteSheetBlocks, 32);
//        blockSheet = new SpriteSheet(Images.spriteSheetBlocks, 32);
        rockSheet = new SpriteSheet(Images.spritesheetRockyBlocks, 32);
        metalSheet = new SpriteSheet(Images.spritesheetMetalBlocks, 32);
        liquidSheet = new SpriteSheet(Images.spritesheetLiquid, 32);
        playerSheet = new SpriteSheet(Images.spriteSheetPlayer, 32,70);
        
        initTextures();
       
    }
    
    private void initTextures()
    {
//        blockStone = blockSheet.getSprite(1, 1);
//        blockMetal = blockSheet.getSprite(2, 1);
//      
        blockAsteroidCenter = rockSheet.getSprite(1, 1);
        blockAsteroidTop = rockSheet.getSprite(2, 1);
        blockAsteroidTopRight = rockSheet.getSprite(3, 1);
        blockAsteroidTopLeft = rockSheet.getSprite(4, 1);
        blockAsteroidTopSides = rockSheet.getSprite(1, 2);

        blockMetalGrip = metalSheet.getSprite(1, 1);
        blockMetalLined = metalSheet.getSprite(2, 1);
        blockMetalSheet = metalSheet.getSprite(3, 1);
        blockMetalRough = metalSheet.getSprite(4, 1);
        blockMetalSmooth = metalSheet.getSprite(1, 2);

        lava = liquidSheet.getSprite(1, 1);
        toxicWaste = liquidSheet.getSprite(2, 1);
        water = liquidSheet.getSprite(3, 1);
        coldWater = liquidSheet.getSprite(4, 1);
        playerStandingRight = playerSheet.getSprite(12, 1);
        playerStandingLeft = playerSheet.getSprite(1, 1);
        
        playerRight[0] = playerSheet.getSprite(8, 1);
        playerRight[1] = playerSheet.getSprite(9, 1);
        playerRight[2] = playerSheet.getSprite(10, 1);
        playerRight[3] = playerSheet.getSprite(11, 1);
        
        playerLeft[0] = playerSheet.getSprite(5, 1);
        playerLeft[1] = playerSheet.getSprite(4, 1);
        playerLeft[2] = playerSheet.getSprite(3, 1);
        playerLeft[3] = playerSheet.getSprite(2, 1);
    }
    
}
