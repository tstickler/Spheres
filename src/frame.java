//Programmed by Tyler Stickler

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class frame extends JFrame {
	
	JLabel title = new JLabel("Spheres");
	JLabel name = new JLabel("Programmed by Tyler Stickler");
	JLabel inputLabel = new JLabel("Enter a radius:");
	JLabel computedLabel = new JLabel("These results were computed:");
	JLabel surfaceLabel = new JLabel("Surface Area:");
	JLabel volumeLabel = new JLabel("Volume:");
	JLabel messageLabel = new JLabel("");
	
	JTextField radiusInput = new JTextField(25);
	JTextField surfaceArea = new JTextField(25);
	JTextField volume = new JTextField(25);
	
	JButton computeButton = new JButton("Compute");
	JButton clearButton = new JButton("Clear");
	JButton exitButton = new JButton("Exit");
	
	public frame(){
		JPanel thePanel = new JPanel(new GridBagLayout());
		
		Font titleFont = new Font("", Font.BOLD, 42);
		Font labelFont = new Font("", Font.PLAIN, 18);
		Font messageFont = new Font("", Font.BOLD, 18);
		
		
		//Add the title
		title.setFont(titleFont);
		addItem(thePanel, title, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		
		//Add programmed by
		name.setFont(labelFont);
		addItem(thePanel, name, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
		
		//Add prompt to input radius
		inputLabel.setFont(labelFont);
		addItem(thePanel, inputLabel, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Get radius from user
		addItem(thePanel, radiusInput, 1, 2, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Label computation section
		computedLabel.setFont(messageFont);
		addItem(thePanel, computedLabel, 1, 3, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.NONE);
		
		//Label surface area
		surfaceLabel.setFont(labelFont);
		addItem(thePanel, surfaceLabel, 0, 4, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Output surface area based off user radius
		surfaceArea.setEditable(false);
		addItem(thePanel, surfaceArea, 1, 4, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Label volume
		volumeLabel.setFont(labelFont);
		addItem(thePanel, volumeLabel, 0, 5, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Output volume based off user radius
		volume.setEditable(false);
		addItem(thePanel, volume, 1, 5, 2, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		
		//Message to user
		messageLabel.setFont(messageFont);
		addItem(thePanel, messageLabel, 0, 6, 3, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		
		//Add the buttons for compute, clear, and exit
		buttonHandler myHandler = new buttonHandler();
		addItem(thePanel, computeButton, 0, 8, 1, 1, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL);
		computeButton.addActionListener(myHandler);
		addItem(thePanel, clearButton, 1, 8, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		clearButton.addActionListener(myHandler);
		addItem(thePanel, exitButton, 2, 8, 1, 1, GridBagConstraints.EAST, GridBagConstraints.HORIZONTAL);
		exitButton.addActionListener(myHandler);
		
		this.add(thePanel);
	}
	
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
			
	}
	
	private class buttonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == computeButton){
				String inputString = radiusInput.getText();
				
				if (inputString.length() == 0){
					messageLabel.setText("Message: empty input field interpreted as 0.00");
				}
				else {
					try{
						double inputDouble = Double.parseDouble(inputString);
						
						double sa = computation.computeSurfaceArea(inputDouble);
						double v = computation.computeVolume(inputDouble);
						
						surfaceArea.setText(sa + " square inches");
						volume.setText(v + " cubic inches");
						
						messageLabel.setText("Message: computation successful");
					}
					catch (NumberFormatException exception){
						messageLabel.setText("Message: error in input, please fix and then try again");
					}
				}
			}
			else if(e.getSource() == clearButton){
				radiusInput.setText("");
				surfaceArea.setText("");
				volume.setText("");
				messageLabel.setText("Message: all fields are now blank");
				
			}else if(e.getSource() == exitButton){
				messageLabel.setText("Message: this program will now close");
				
				System.exit(0);
			}
		}
	}
}
