/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.filters;

import snapshop.image.Pixel;
import snapshop.image.PixelImage;

/** 
 * A filter that flips the image vertically. 
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class FlipVerticalFilter extends AbstractFilter
{
  /** 
   * Constructs a new flip vertical filter. 
   */
  public FlipVerticalFilter()
  {
    super("Flip Vertical");
  }

  /** 
   * Filters the specified image. 
   * 
   * @param the_image The image.
   */
  public void filter(final PixelImage the_image)
  {
    final Pixel[][] data = the_image.getPixelData();
    for (int row = 0; row < the_image.getHeight() / 2; row++)
    {
      for (int col = 0; col < the_image.getWidth(); col++)
      {
        swap(data, row, col, the_image.getHeight() - row - 1, col);
      }
    }
    the_image.setPixelData(data);
  }
}
