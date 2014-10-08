/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.gfx.textures;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Sprite
{



        private int x;
        private int y;
        private int size;
        private SpriteSheet spritesheet;
        private BufferedImage image;

        public Sprite(int x, int y, int size, SpriteSheet spritesheet)
        {
            this.x = x;
            this.y = y;
            this.size = size;
            this.spritesheet = spritesheet;
            image = spritesheet.getSprite(x, y, size);
        }

        public void render(Graphics g, int x, int y)
        {
            g.drawImage(image, x, y, null);
        }

    }
