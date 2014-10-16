/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.filters;

import snapshop.image.PixelImage;

/**
 * A filter that highlights edges in the image.
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class EdgeHighlightFilter extends AbstractFilter
{
  /**
   * A 3x3 matrix of weights to use in the filtering algorithm.
   */

  private static final int[][] WEIGHTS = {{-1, -1, -1}, {-1, 9, -1}, 
                                          {-1, -1, -1}};

  /**
   * Constructs a new edge highlighting filter.
   */

  public EdgeHighlightFilter()
  {
    super("Edge Highlight");
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
