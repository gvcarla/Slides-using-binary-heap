/**
 * Created by peter on 9/22/16.
 * BinaryHeap is an interface. It has the methods the BinaryHeapA must
 * provide definitions for the methods declared in this interface.
 */
public interface BinaryHeap<T extends Comparable<T>> {

	
	/**
	 * Gets the element 
	 * @return the index
	 */
    public Comparable<T> getElement(int index);
     

    /**
     * adds an element to the array
     * @return the data
     */
    public void addElement(Comparable<T> data);

    /**
     * Gets the capacity of the heap
     * @return the capacity in an int
     */
    public int capacity() ;

    /**
     *  the size of the heap
     * @return the size in an int
     */
    public int size() ;


    /**
     * sets the size of the heap
     */
    public void setSize(int size) ;

    /**
     * Swaps two elements from the heap
     * 
     */
    public void swap(int one, int two) ;

    /**
     * Makes the heap
     */
    public void buildMaxHeap() ;

    /**
     * Makes it a max heap
     */
    public void maxHeapify(int index) ;

    /**
     * Checks if it an empty heap
     * @return
     */
    public boolean isEmpty();


	public void setElement(int i, Comparable element);
    
    
}
