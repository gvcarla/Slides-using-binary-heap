import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 
 */

/**
 * @author Guest
 *
 */
public class SlideshowApplication extends JComponent {

	public static final int WIDTH = 700;
	public static final int HEIGHT = 500;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		
		JFrame frame = new JFrame("SLIDESHOW! YAY!");
		frame.setSize(WIDTH, HEIGHT);
		frame.add(new SlideshowView() );
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
}
