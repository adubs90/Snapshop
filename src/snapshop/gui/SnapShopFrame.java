/*
 * TCSS 305 - Autumn 2011 

 * Homework 3: Snapshop 
 * Author: Alex Stringham 
 * UWNetID: ats3216
 */
package snapshop.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import snapshop.filters.EdgeDetectFilter;
import snapshop.filters.EdgeHighlightFilter;
import snapshop.filters.Filter;
import snapshop.filters.FlipHorizontalFilter;
import snapshop.filters.FlipVerticalFilter;
import snapshop.filters.GrayscaleFilter;
import snapshop.filters.SharpenFilter;
import snapshop.filters.SoftenFilter;
import snapshop.image.PixelImage;


/**
 * GUI class for the Snapshop program.
 * 
 * @author Alex Stringham
 * @version October, 28 2011
 *
 */
public class SnapShopFrame
{

  /**
   * Frame to display gui and title.
   */
  private final JFrame my_jframe = new JFrame("TCSS 305 SnapShop");
  /**
   * LAbel for displaying an image.
   */
  private final JLabel my_image_label = new JLabel();
  /**
   * Panel filled with filters.
   */
  private final JPanel my_options_panel = new JPanel(new FlowLayout());
  /**
   * Button for the open option.
   */
  private final JButton my_open_button = new JButton("Open...");

  /**
   * Button to save a modified image.
   */
  private final JButton my_save_button = new JButton("Save As...");

  /**
   * Gets the file that the user selects.
   */
  private final JFileChooser my_file_chooser = new JFileChooser();
  /**
   * Image chosen by user that is having filters applied to it.
   */
  private PixelImage my_pixel_image;
  /**
   * Tells if something has changed.
   */
  private boolean my_change;

  /**
   * Displayed on errors.
   */
  private static final String ERROR_MESSAGE = "An error occurred: \n ";

  /**
   * Method that sets up and runs the gui for SnapShopFrame.
   */
  public void start()
  {

    my_jframe.setLayout(new BorderLayout());

    filterButtons(new EdgeDetectFilter());
    filterButtons(new EdgeHighlightFilter());
    filterButtons(new FlipHorizontalFilter());
    filterButtons(new FlipVerticalFilter());
    filterButtons(new GrayscaleFilter());
    filterButtons(new SharpenFilter());
    filterButtons(new SoftenFilter());

    final JPanel options_2 = new JPanel(new FlowLayout());

    options_2.add(my_open_button);
    options_2.add(my_save_button);
    my_open_button.addActionListener(new OptionsListener());
    my_save_button.addActionListener(new OptionsListener());

    my_jframe.add(my_options_panel, BorderLayout.NORTH);
    my_jframe.add(options_2, BorderLayout.SOUTH);

    disableFilters();

    my_jframe.pack();
    my_jframe.addWindowListener(new java.awt.event.WindowAdapter()
    {
      public void windowClosing(final WindowEvent the_event)
      {
        if (my_change)
        {
          saveBeforeNew();
        }
        my_jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      }
    });
    my_jframe.setVisible(true);
  }

  /**
   * Creates buttons and assigns there names with getDescription.
   * 
   * @param the_filter filter that specific buttons filter.
   */
  private void filterButtons(final Filter the_filter)
  {
    final JButton filter_button = new JButton(the_filter.getDescription());
    filter_button.addActionListener(new ActionListener()
    {
      public void actionPerformed(final ActionEvent the_arg0)
      {
        the_filter.filter(my_pixel_image);
        my_image_label.setIcon(new ImageIcon(my_pixel_image));
        my_change = true;
      }
    });
    my_options_panel.add(filter_button);
  }

  /**
   * Enables buttons.
   */
  private void enableOptions()
  {
    final Component[] enable = my_options_panel.getComponents();

    for (int i = 0; i < enable.length; i++)
    {
      enable[i].setEnabled(true);
    }

    my_save_button.setEnabled(true);
  }

  /**
   * Disables the filer buttons and save.
   */
  private void disableFilters()
  {
    final Component[] disable = my_options_panel.getComponents();

    for (int i = 0; i < disable.length; i++)
    {
      disable[i].setEnabled(false);
    }

    my_save_button.setEnabled(false);
  }

  /**
   * Creates an open dialogue that allows the user to select an image file.
   * 
   * @return the image that the user wants to open.
   */
  private File chooser()
  {
    int user_selection = my_file_chooser.showOpenDialog(null);

    while (user_selection != JFileChooser.APPROVE_OPTION)
    {
      javax.swing.JOptionPane.showMessageDialog(null, "Choose an image file!");
      user_selection = my_file_chooser.showOpenDialog(null);
    }

    return my_file_chooser.getSelectedFile();
  }

  /**
   * Creates a save dialogue that allows the user to save their image file.
   * 
   * @return The file that you want to save.
   */
  private File save()
  {
    int save_selection = my_file_chooser.showSaveDialog(null);

    while (save_selection != JFileChooser.APPROVE_OPTION)
    {
      javax.swing.JOptionPane.showMessageDialog(null, "Choose a place to save your image!");
      save_selection = my_file_chooser.showSaveDialog(null);
    }

    return my_file_chooser.getSelectedFile();
  }

  /**
   * Prompts the user if they want to save their current picture before editing
   * a new one.
   */
  private void saveBeforeNew()
  {
    final Object[] yes_no = {"Yes", "No"};
    final int num =
        JOptionPane.showOptionDialog(null, "Save your work before starting a new image?",
                                     "Save your image?", JOptionPane.YES_NO_OPTION,
                                     JOptionPane.QUESTION_MESSAGE, null, yes_no, null);

    if (num == 0)
    {
      try
      {
        my_pixel_image.save(save());
      }
      catch (final IOException e)
      {
        javax.swing.JOptionPane.showMessageDialog(null, ERROR_MESSAGE + e.getMessage());
      }
    }
  }

  /**
   * My ActionListener for the filter and option buttons.
   * 
   * @author Alex Stringham
   * @version October, 28 2011
   */
  private class OptionsListener implements ActionListener
  {

    /**
     * Creates ActionListeners for the option buttons.
     * 
     * @param the_action retrieves the source of the save button.
     */
    public void actionPerformed(final ActionEvent the_action)
    {

      if (the_action.getSource() == my_save_button)
      {

        try
        {
          my_pixel_image.save(save());
          my_change = false;
        }
        catch (final IOException e)
        {
          javax.swing.JOptionPane.showMessageDialog(null, ERROR_MESSAGE + e.getMessage());

        }

      }
      else if (the_action.getSource() == my_open_button)
      {
        try
        {

          if (my_change)
          {
            saveBeforeNew();
          }

          my_pixel_image = PixelImage.load(chooser());
          my_image_label.setIcon(new ImageIcon(my_pixel_image));
          my_jframe.add(my_image_label, BorderLayout.CENTER);
          my_jframe.pack();
          enableOptions();
          my_change = false;
        }
        catch (final IOException e)
        {
          javax.swing.JOptionPane.showMessageDialog(null, ERROR_MESSAGE + e.getMessage());
        }
      }
    }
  }
}
