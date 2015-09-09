import javax.swing.JFrame;

public class driver {
	public static void main(String[] args) {
		frame myFrame = new frame();
		
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.setLocation(1000,0);
		myFrame.setSize(500, 500);
		myFrame.setVisible(true);
		myFrame.setTitle("Spheres");
	}
}
