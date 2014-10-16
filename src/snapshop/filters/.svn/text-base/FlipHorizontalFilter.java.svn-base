/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.filters;

import snapshop.image.Pixel;
import snapshop.image.PixelImage;

/** 
 * A filter that flips the image horizontally. 
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class FlipHorizontalFilter extends AbstractFilter
{
  /** 
   * Constructs a new flip horizontal filter. 
   */
  public FlipHorizontalFilter()
  {
    super("Flip Horizontal");
  }

  /** 
   * Filters the specified image. 
   * 
   * @param the_image The image.
   */
  public void filter(final PixelImage the_image)
  {
    final Pixel[][] data = the_image.getPixelData();
    for (int row = 0; row < the_image.getHeight(); row++)
    {
      for (int col = 0; col < the_image.getWidth() / 2; col++)
      {
        swap(data, row, col, row, the_image.getWidth() - col - 1);
      }
    }
    the_image.setPixelData(data);
  }
}
