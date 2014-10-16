/*
 * TCSS305 - Autumn 2011
 * Assignment 3: SnapShop
 * Daniel M. Zimmerman
 */

package snapshop.image;

/** 
 * Represents a pixel (an RGB value).
 *
 * @author Daniel M. Zimmerman
 * @author Marty Stepp
 * @version 1.0
 */
public class Pixel
{
  // Static Fields
  
  /**
   * The number of color channels.
   */
  public static final int CHANNELS = 3;

  /**
   * The number of bits per color channel.
   */
  public static final int BITS_PER_CHANNEL = 8;
  
  /**
   * The minimum value for a color.
   */
  public static final int MIN_COLOR = 0;

  /**
   * The maximum value for a color.
   */
  public static final int MAX_COLOR = 255;

  // Instance Fields
  
  /**
   * The red value for this pixel.
   */
  private int my_red;

  /**
   * The green value for this pixel.
   */
  private int my_green;

  /**
   * The blue value for this pixel.
   */  
  private int my_blue;

  // Constructors
  
  /** 
   * Constructs a black pixel (all values at minimum).
   */
  //@ ensures getRed() == MIN_COLOR_VALUE;
  //@ ensures getGreen() == MIN_COLOR_VALUE; 
  //@ ensures getBlue() == MIN_COLOR_VALUE;
  public Pixel()
  {
    this(MIN_COLOR, MIN_COLOR, MIN_COLOR);
  }

  /**
   * Constructs a pixel with the specified color values.
   * 
   * @param the_red The red value.
   * @param the_green The green value.
   * @param the_blue The blue value.
   */
  //@ requires the_red >= MIN_COLOR_VALUE && the_red <= MAX_COLOR_VALUE;
  //@ requires the_green >= MIN_COLOR_VALUE && the_green <= MAX_COLOR_VALUE;
  //@ requires the_blue >= MIN_COLOR_VALUE && the_blue <= MAX_COLOR_VALUE;
  //@ ensures getRed() == the_red;
  //@ ensures getGreen() == the_green;
  //@ ensures getBlue() == the_blue;
  public Pixel(final int the_red, final int the_green, final int the_blue)
  {
    my_red = the_red;
    my_green = the_green;
    my_blue = the_blue;
  }
  
  // Instance Methods

  /** 
   * Returns the red value for this pixel.
   *
   * @return the red value for this pixel.
   */
  public int getRed()
  {
    return my_red;
  }
  
  /** 
   * Returns the green value for this pixel.
   *
   * @return the green value for this pixel.
   */
  public int getGreen()
  {
    return my_green;
  }
  
  /** 
   * Returns the blue value for this pixel.
   *
   * @return the blue value for this pixel.
   */
  public int getBlue()
  {
    return my_blue;
  }

  /**
   * Sets the red value for this pixel to the specified value.
   * 
   * @param the_red The new value.
   * @exception IllegalArgumentException if the specified value is less
   * than MIN_COLOR_VALUE or greater than MAX_COLOR_VALUE.
   */
  //@ ensures getRed() == the_red;
  public void setRed(final int the_red)
    throws IllegalArgumentException
  {
    checkColorValue(the_red);
    my_red = the_red;
  }
  
  /**
   * Sets the green value for this pixel to the specified value.
   * 
   * @param the_green The new value.
   * @exception IllegalArgumentException if the specified value is less
   * than MIN_COLOR_VALUE or greater than MAX_COLOR_VALUE.
   */
  //@ ensures getGreen() == the_green;
  public void setGreen(final int the_green)
    throws IllegalArgumentException
  {
    checkColorValue(the_green);
    my_green = the_green;
  }
  
  /**
   * Sets the blue value for this pixel to the specified value.
   * 
   * @param the_blue The new value.
   * @exception IllegalArgumentException if the specified value is less
   * than MIN_COLOR_VALUE or greater than MAX_COLOR_VALUE.
   */
  //@ ensures getBlue() == the_blue;
  public void setBlue(final int the_blue)
    throws IllegalArgumentException
  {
    checkColorValue(the_blue);
    my_blue = the_blue;
  }

  /**
   * Checks to see if the specified color value is valid.
   * 
   * @param the_value The value.
   * @exception IllegalArgumentException if the specified value is less than
   * MIN_COLOR_VALUE or greater than MAX_COLOR_VALUE.
   */
  private void checkColorValue(final int the_value)
    throws IllegalArgumentException
  {
    if (the_value < MIN_COLOR || the_value > MAX_COLOR)
    {
      throw new IllegalArgumentException("Invalid color value: " + the_value);
    }
  }
}
