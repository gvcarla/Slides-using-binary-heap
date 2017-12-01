/**
 * PriorityQueue is the interface for PriorityQueueBH
 * It has the methods the PriorityQueueBH must
 * provide definitions for the methods declared in this interface.
 * @author Carla Gonzalez-Vazquez		
 *
 * @param <T>
 */
public interface PriorityQueue<T> {

	/**
	 * Inserts a Comparable element
	 * @param the Comprable value
	 */
	public void insert(Comparable value);

	/**
	 * Gets/looks at the maximum elemenent in the queue
	 * @return the max element
	 */
	public Comparable maximum();
	
	/**
	 * Extracts the max value in the queue
	 * @return
	 */
	public Comparable extract_max();

	/**
	 * Increases the value of the element/index called
	 * @param heapIndex the index on the array/queue
	 * @param newValue the new value for the element
	 */
	public void increase_value(int heapIndex, Comparable newValue);
}
