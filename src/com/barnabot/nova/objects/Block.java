/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */

package com.barnabot.nova.objects;

import com.barnabot.nova.core.CoreObject;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class Block extends CoreObject
{
    
    public Block(float x, float y, int id, BufferedImage image)
    {
        super(x, y, id, image);
        this.image = image;    
        this.setSize(32, 32);
        
    }

    @Override
    public void tick()
    {
        
    }

    @Override
    public void render(Graphics g)
    {
        g.drawImage(image, (int)x, (int)y, null);
        super.render(g);
    }
    

    
}
