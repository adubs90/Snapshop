/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.filters;

import snapshop.image.PixelImage;

/** 
 * A filter that makes the image sharper. 
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class SharpenFilter extends AbstractFilter
{
  /**
   * A 3x3 grid of weights to use for the weighted filter algorithm.
   */
  
  private static final int[][] WEIGHTS = {{-1, -2, -1}, {-2, 28, -2}, 
                                          {-1, -2, -1}};

  /** 
   * Constructs a new sharpening filter. 
   */
  
  public SharpenFilter()
  {
    super("Sharpen");
  }

  /** 
   * Filters the specified image. 
   *
   * @param the_image The image.
   */
  
  public void filter(final PixelImage the_image)
  {
    weight(the_image, WEIGHTS);
  }
}
