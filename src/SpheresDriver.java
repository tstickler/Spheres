import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Dimension;

public class SpheresDriver {
	public static void main(String[] args) {
		SpheresFrame myFrame = new SpheresFrame();
		
		/*Sets the window to open in the middle of the screen
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dm = tk.getScreenSize();
		int width = 550;
		int height =750;
		int xPos = (dm.width / 2) - width/2;
		int yPos = (dm.height / 2) - height/2;
		*/
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(0,0);
		myFrame.setSize(550, 750);
		myFrame.setVisible(true);
		myFrame.setTitle("Spheres");
	}
}
