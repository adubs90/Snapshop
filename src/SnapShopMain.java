/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

import snapshop.gui.SnapShopFrame;

/**
 * Runs SnapShop by instantiating and starting the SnapShopGUI.
 * 
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public final class SnapShopMain
{
  /**
   * Private constructor, to prevent instantiation of this class.
   */
  private SnapShopMain()
  {
    // do nothing.
  }
  
  /**
   * The main method, invokes the SnapShop GUI. Command line
   * arguments are ignored.
   * 
   * @param the_args Command line arguments.
   */
  public static void main(final String[] the_args)
  {
    final SnapShopFrame gui = new SnapShopFrame();
    gui.start();
  }
}
