/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.filters;

import snapshop.image.Pixel;
import snapshop.image.PixelImage;

/**
 * Filter that converts the image to greyscale.
 *
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class GrayscaleFilter extends AbstractFilter
{ 
  /**
   * Constructs a new grayscale filter.
   */

  public GrayscaleFilter()
  {
    super("Grayscale");
  }

  /**
   * Filters the specified image.
   *
   * @param the_image The image.
   */

  public void filter(final PixelImage the_image)
  {
    final int w = the_image.getWidth(null);
    final int h = the_image.getHeight(null);
    for (int i = 0; i < w; i++)
    {
      for (int j = 0; j < h; j++)
      {
        final int p = the_image.getRGB(i, j);
        final int c1 = Pixel.BITS_PER_CHANNEL;
        final int c2 = c1 + Pixel.BITS_PER_CHANNEL;
        final int c3 = c2 + Pixel.BITS_PER_CHANNEL;
        final int a = 
          (((p >> c2) & Pixel.MAX_COLOR) + 
           ((p >> c1) & Pixel.MAX_COLOR) + 
           (p & Pixel.MAX_COLOR)) / Pixel.CHANNELS;
        the_image.setRGB(i, j, (Pixel.MAX_COLOR << c3) | (a << c2) | (a << c1) | a);
      }
    }
  }
}
