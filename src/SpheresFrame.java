/* 
* Programmer's name: Tyler Stickler
* Email address:     Stickler@csu.fullerton.edu
* Course:            CPSC223J
* Assignment number: 1
* Due date:          Sept 14, 2015
* Title:             Spheres
* Purpose:           Find the surface area and volume of any sphere
* This file name:    SpheresFrame.java
*/

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class SpheresFrame extends JFrame {
	
	//Declarations all of the UI elements to be used in the project
	JLabel title = new JLabel("Spheres");
	JLabel name = new JLabel("Programmed by Tyler Stickler");
	JLabel inputLabel = new JLabel("Enter a radius:");
	JLabel computedLabel = new JLabel("These results were computed:");
	JLabel surfaceLabel = new JLabel("Surface Area:");
	JLabel volumeLabel = new JLabel("Volume:");
	JLabel messageLabel = new JLabel("Message: enter a radius");
	
	JTextField radiusInput = new JTextField(25);
	JTextField surfaceArea = new JTextField(25);
	JTextField volume = new JTextField(25);
	
	JButton computeButton = new JButton("Compute");
	JButton clearButton = new JButton("Clear");
	JButton exitButton = new JButton("Exit");
	
	Timer delayClose;
	
	public SpheresFrame(){
		//Creates a panel attach all the UI elements to
		JPanel thePanel = new JPanel(new GridBagLayout());
		
		//Allows using different font size/style for messages
		Font titleFont = new Font("", Font.BOLD, 42);
		Font labelFont = new Font("", Font.PLAIN, 18);
		Font messageFont = new Font("", Font.BOLD, 18);
		
		
		/* This section of code adds all the labels, text fields, and buttons to a panel which is then added
		 * to the frame.
		 * 
		 * The use of addItem function allows formatting the grids to hold the components neatly. It also
		 * allows for better readability and reduces repeat code that handled the formatting. 
		 * 
		 * addItem(panel, component, Cell X Position, Cell Y Position, Cell width, Cell height, location in cell, fill Cell)
		 *  */
		
		//Add the title
		title.setFont(titleFont);
		addItem(thePanel, title, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		//Add programmed by
		name.setFont(labelFont);
		addItem(thePanel, name, 1, 0, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
		
		//Add prompt to input radius
		inputLabel.setFont(labelFont);
		addItem(thePanel, inputLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Get radius from user
		addItem(thePanel, radiusInput, 1, 1, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Label computation section
		computedLabel.setFont(messageFont);
		addItem(thePanel, computedLabel, 1, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
		
		//Label surface area
		surfaceLabel.setFont(labelFont);
		addItem(thePanel, surfaceLabel, 0, 3, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Output surface area based off user radius
		surfaceArea.setEditable(false);
		addItem(thePanel, surfaceArea, 1, 3, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Label volume
		volumeLabel.setFont(labelFont);
		addItem(thePanel, volumeLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Output volume based off user radius
		volume.setEditable(false);
		addItem(thePanel, volume, 1, 4, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Message to user
		messageLabel.setFont(messageFont);
		addItem(thePanel, messageLabel, 0, 5, 3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Add the buttons for compute, clear, and exit
		buttonHandler myHandler = new buttonHandler();
		addItem(thePanel, computeButton, 0, 7, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		computeButton.addActionListener(myHandler);
		addItem(thePanel, clearButton, 1, 7, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		clearButton.addActionListener(myHandler);
		addItem(thePanel, exitButton, 2, 7, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		exitButton.addActionListener(myHandler);
		delayClose = new Timer(1000, myHandler);
		
		this.add(thePanel);
	} //End constructor
	
	private void addItem(JPanel myPanel, JComponent item, int xGrid, int yGrid, int width, int height, int location, int fill) {
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = xGrid;
		cons.gridy = yGrid;
		cons.gridheight = height;
		cons.gridwidth = width;
		cons.weightx=1;
		cons.weighty=1;
		cons.anchor = location;
		cons.fill = fill;
		
		myPanel.add(item, cons);
			
	} // End addItem function
	
	private class buttonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == computeButton){
				String inputString = radiusInput.getText();
				
				// If the input field is empty, assume input is 0.00
				if (inputString.length() == 0){
					messageLabel.setForeground(Color.BLACK);
					messageLabel.setText("Message: empty input field interpreted as 0.00");
					radiusInput.setText("0.00");
					surfaceArea.setText("0.00 square inches");
					volume.setText("0.00 cubic inches");
				}
				// Do this if the input field has something in it
				else {
					// Try to parse the string to get the value as a double 
					try{ 
						double inputDouble = Double.parseDouble(inputString);
						
						double sa = SpheresComputation.computeSurfaceArea(inputDouble);
						double v = SpheresComputation.computeVolume(inputDouble);
						
						surfaceArea.setText(sa + " square inches");
						volume.setText(v + " cubic inches");
						
						messageLabel.setForeground(Color.GREEN);
						messageLabel.setText("Message: computation successful");
					}
					// If the parsing fails, the input was invalid 
					catch (NumberFormatException exception){
						surfaceArea.setText("error");
						volume.setText("error");
						messageLabel.setForeground(Color.RED);
						messageLabel.setText("Message: error in input, please fix and then try again");
					}
				}
			}
			else if(e.getSource() == clearButton){
				// Set all inputs to empty strings
				radiusInput.setText("");
				surfaceArea.setText("");
				volume.setText("");
				messageLabel.setForeground(Color.BLACK);
				messageLabel.setText("Message: all fields are now blank");
				
			}else if(e.getSource() == exitButton){
				// Delay of 1 second after the button is clicked
				messageLabel.setForeground(Color.BLACK);
				messageLabel.setText("Message: this program will now close");
				
				delayClose.start();
			}else if(e.getSource() == delayClose){
				System.exit(0);
			}
		}
	} // End actionListener class
} // End frame class
