/**
 * The Slide class makes the Slide type.
 * It contains setters and getters and a compareTo method
 * @author Carla Gonzalez-Vazquez
 * PSA4 Feb.21.2017
 * @param <T>
 */
public class Slide implements Comparable<Slide>{

	//variables for the text and time that will be in the slide
	protected String text;
	protected Integer time;
	
	
	/**
	 * The constructor for the class.
	 * Passes the text you want to display
	 * and at what time you want it to display it at
	 * @param slideText the String you want to display
	 * @param slideTime the Integer for the time
	 */
	public Slide(String slideText, Integer slideTime){
		
		text = slideText;
		time = slideTime;
	}
	
	/**
	 * Sets the text of the slide
	 * @param slideText the String for the text
	 */
	public void setSlideText(String slideText){
		
		text = slideText;		
		
	}
	
	/**
	 * Gets the text from the slide
	 * @param slideText
	 * @return the text on the slide
	 */
	public String getSlideText(){
		
		return text;
	}
	
	/**
	 * Gets the time at what you set the slide
	 * @param slideTime
	 * @return the time in Integers
	 */
	public Integer getTime(){
		return this.time;
		
	}
	/**
	 * Sets the time 
	 * 
	 * @param slideTime
	 */
	public void setTime(Integer slideTime){
		
		time = slideTime;
	}

	/**
	 * 
	 */
	
	public int compareTo(Slide slide) {
		
		System.out.println("I am called");
		//return this.getTime().compareTo(slide.getTime()) *(-1);
//		int otherTime  = slide.getTime():
		//if(this.getTime()<0){
		if(this.getTime()>slide.getTime()){
			return -1;
		}
		else if(this.getTime()<slide.getTime()){
			return 1;
		}
		else
			return 0;

	}	
}
