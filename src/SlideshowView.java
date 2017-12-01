import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 * The SlideshowView class makes the panels in the GUI for the 
 * Slideshow program.
 * It makes the different panels with the buttons and text fields.
 * It also contains the actionPerformed method that allows the buttons
 * to perform actions.
 * 
 * @author Carla Gonzalez-Vazquez
 * PSA4  Feb.22.2017
 * 
 */
public class SlideshowView extends JPanel implements ActionListener{

	//instance variables for the JPanels, JLabels, JButtons
	private JPanel textfieldPanel;
	private JPanel buttonPanel;
	private JPanel slidePanel;
	private JButton [] buttons = new JButton [2];
	private JTextField [] text = new JTextField[2];
	private JLabel slideArea;
	//makes a new color
	private Color NEW_COLOR = new Color (0, 201, 201);
	//instance variable for Slide
	protected Slide slide;
	protected JPanel timePanel;
	protected JLabel timeLabel;
	//instance variables for the times
	protected int time;
	protected Timer timer;
	protected ActionListener timerListener;

	//makes a new priority queue of type slide
	protected PriorityQueueBH<Slide> pqSlide = new PriorityQueueBH(10);

	/**
	 * Constructor
	 * Calls the methods to create the panels
	 * and the timer
	 */
	public SlideshowView(){
		super(new BorderLayout());	
		northPanel();
		eastPanel();
		slidePanel();
		TimerDemo();
	}

	/**
	 * The lowerPanel makes the panel for the buttons
	 * Makes the buttons and adds them to the east of the panel
	 * @return the button panel
	 */
	public JPanel eastPanel(){

		buttonPanel = new JPanel(new GridLayout (2,1));
		buttons[0] = new JButton("ADD SLIDE");
		buttons[1] = new JButton("START THE SHOW!");

		for(int i =0; i< buttons.length; i++){
			buttons[i].addActionListener(this);
			buttons[i].setFont(buttons[i].getFont().deriveFont(Font.BOLD));
			buttonPanel.add(buttons[i]);	
		}
		buttonPanel.setBackground(NEW_COLOR);
		add(buttonPanel, BorderLayout.EAST);
		return buttonPanel;
	}

	/**
	 * Panel for the JtextField panel. Takes an array of JTextFields
	 * Makes JTextPanel and adds it to the north of the panel
	 * @return the panel
	 */
	public JPanel northPanel(){	

		textfieldPanel = new JPanel(new GridLayout (1,2));

		text[0] = new JTextField("Enter Text");
		text[1] = new JTextField("Enter Time");
		for(int i= 0; i< text.length; i++){
			textfieldPanel.add(text[i]);		
		}
		textfieldPanel.setBackground(NEW_COLOR);
		add(textfieldPanel, BorderLayout.NORTH);
		return textfieldPanel;
	}

	/**
	 * Makes panel for the area where the text is going
	 * to be displayed.
	 * @return the slide panel
	 */
	public JPanel slidePanel(){

		slidePanel = new JPanel(new GridLayout(1,1));

		slideArea = new JLabel();

		slidePanel.setBackground(NEW_COLOR);
		slideArea.setHorizontalAlignment(JLabel.CENTER);
		slidePanel.add(slideArea);

		add(slidePanel, BorderLayout.CENTER);
		return slidePanel;

	}


	/**
	 * ActionPerforms makes the buttons able to perform actions
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//when add button gets clicked
		if(e.getSource()==buttons[0]){
			//gets the text and Integers from the textfields
			String slideText = text[0].getText();			
			Integer slideTime = Integer.parseInt(text[1].getText());			
			//makes a new slide and passes the text and integer the got stored
			slide = new Slide(slideText, slideTime);
			//inserts the slide into the queue
			pqSlide.insert(slide);	
			
			//prints the element in the queue when its added
			int i=1;
			while(pqSlide.pqHeap.getElement(i)!=null)
			{
				System.out.println(((Slide) pqSlide.pqHeap.getElement(i)).getSlideText());
				i++; 
			}
		}

		//when start button is played
		if(e.getSource()==buttons[1]){
			
			System.out.println("start button clicked");
			//prints the elements in the queue the button is clicked
			int i=1;
			while(pqSlide.pqHeap.getElement(i)!=null){
				System.out.println(((Slide) pqSlide.pqHeap.getElement(i)).getTime());
				i++;
			}
			//starts the timer
			startTimer();

			
			if(slide.getTime()==Integer.parseInt(text[1].getText())){
				pqSlide.extract_max();
				slideArea.setText(slide.getSlideText());

			}

		}

	}

	public void TimerDemo()
	{
		time = 0;

		timerListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				time += 1;

				if (time <= 10) {
					System.out.println("listener time: " + time);
				} else {
					System.out.println("listener complete");
					timer.stop();
				}
			}
		};
	}

	public void startTimer() {
		// slideshowListener is called every 1000 milliseconds (1 second)
		timer = new Timer(1000, timerListener );
		System.out.print("listener starting...");
		timer.start();
		//startSlideshow();
	}

	//    public void startSlideshow(){
	//		timer = new Timer(1000, timerListener);
	//		System.out.print("listener starting...");
	//		timer.start();
	//
	//		time += 1;
	//		if (time <= 10) {
	//			//Slide slide = new Slide();
	//			Slide nextSlide = (Slide) pqSlide.maximum();
	//
	//			if (slide.getTime() == nextSlide.getTime()) {
	//				slideArea.setText(nextSlide.getSlideText());
	//				
	//				
	//				pqSlide.extract_max();
	//			}
	//
	//		} else {
	//			timer.stop();
	//		}
	//    }
	//    
	//    public JPanel southPanel(){
	//    	timePanel = new JPanel(new GridLayout(1,1));
	//    	timeLabel = new JLabel("Time");
	//    	
	//    	
	//    }


}
