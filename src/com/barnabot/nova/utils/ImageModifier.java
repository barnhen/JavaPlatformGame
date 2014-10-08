/*
 * Created by Henrique Barnabe. 2014 Henrique Barnabe <barnabot.com>.
 * This is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied,
 * Unless (of course) you are Enzo Henrique Barnabe.
 * Enjoy.
 */
package com.barnabot.nova.utils;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Henrique Barnabe <barnabot.com>
 */
public class ImageModifier
{

    /**
     * Scales an image down or up<p>
     * <strong>Note:</strong> Use two images, the non-modified image and the
     * image you actually use and has been/will be scaled
     *
     * @param originalImage the original image that has not been scaled
     * @param type the type of image, for example:
     * <code>BufferedImage.TYPE_INT_ARGB</code>
     * @param x the starting x coordinate of the portion of the image you want
     * to scale
     * @param y the starting y coordinate of the portion of the image you want
     * to scale
     * @param inititalWidth the width of the origional image
     * @param initialHeight the height of the origional image
     * @param scale how much to be scaled by<br>
     * scale < 1 = shrink<br> scale > 1 = growth
     * @return the scaled image
     */
    public static BufferedImage resizeImage(BufferedImage originalImage, int type, float x, float y, int inititalWidth, int initialHeight, double scale)
    {
        inititalWidth *= scale;
        initialHeight *= scale;
        BufferedImage resizedImage = new BufferedImage(inititalWidth, initialHeight, type);
        Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, (int) x, (int) y, inititalWidth, initialHeight, null);
        g2d.dispose();
        return resizedImage;
    }
}
