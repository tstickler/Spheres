/* 
* Programmer's name: Tyler Stickler
* Email address:     Stickler@csu.fullerton.edu
* Course:            CPSC223J
* Assignment number: 1
* Due date:          Sept 14, 2015
* Title:             Spheres
* Purpose:           Find the surface area and volume of any sphere
* This file name:    SpheresDriver.java
*/

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class SpheresDriver {
	public static void main(String[] args) {
		SpheresFrame myFrame = new SpheresFrame();
		
		//Sets the window to open in the middle of the screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		int width = 750;
		int height =1000;
		int xPos = (dm.width / 2) - width/2;
		int yPos = (dm.height / 2) - height/2;
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(xPos,yPos);
		myFrame.setSize(width, height);
		myFrame.setVisible(true);
		myFrame.setTitle("Spheres");
	}
}
