/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.libs;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Identities
{
    private static int eid = 1;
    private static int bid = 10;
    private static int lid = 100;
    
    /*
    * Entity IDs
    */
    public static int PLAYER = eid;
    
    /*
    * Block IDs
    */
//    public static int BLOCK_STONE = 10;
//    public static int BLOCK_METAL = 11;
    public static int BLOCK_ASTEROID_CENTER = bid;
    public static int BLOCK_ASTEROID_TOP_RIGHT = bid++;
    public static int BLOCK_ASTEROID_TOP_LEFT = bid++;
    public static int BLOCK_ASTEROID_TOP_SIDES = bid++;
    public static int BLOCK_ASTEROID_TOP = bid++;
    public static int BLOCK_METAL_GRIP = bid++;
    public static int BLOCK_METAL_SHEET = bid++;

    /*
    * Liquid IDs
    */
    public static int LIQUID_LAVA = lid;
}

