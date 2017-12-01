/**
 * Created by peter on 9/22/16.
 * 
 * This class makes the binaryHeap. It implements the BinaryHeap interface.
 * Filled by Carla Gonzalez-Vazquez on 2/11/2017.
 */
public class BinaryHeapA<T extends Comparable<T>> implements BinaryHeap<T> {
	
	// array to hold the heap
	protected Comparable[] internalArray;
	// keep track of the heap size (different from the capacity)
	protected int heapSize;

	/**
	 * Constructor that passes the capacity of the heap
	 * Sets size to zero and makes the size of the array
	 * the same as the passed capacity
	 * @param capacity the heap capacity
	 */
	public BinaryHeapA(int capacity){
		
		heapSize = 0;
		internalArray = new Comparable[capacity];
	}

	/**
	 * Constructor that passes a comparable array.
	 * Calls buildMaxHeap
	 * @param array the comparable array
	 */
	public BinaryHeapA(Comparable<T> [] array){

		heapSize = array.length; 
		internalArray=array;    	   	
		buildMaxHeap();
	}

	/**
	 * Gets the element from the heap
	 */
	@Override
	public Comparable<T> getElement(int index) {

		return internalArray[index-1];
	}	

	/**
	 * Adds an element to the heap
	 */
	@Override
	public void addElement(Comparable<T> data) {
		//if size of heap equals the length of the array do nothing
		if(heapSize == internalArray.length){
			return;
		}
		//else increase the size and insert
		else{
			heapSize++;
			internalArray[heapSize - 1] = data;
		}		
		
		buildMaxHeap();	
	}
	
	/**
	 * Sets an element into the array
	 */
	public void setElement(int index, Comparable element){
		
		internalArray[index - 1]= element;  
	}
	
	/**
	 * Gets the left child of the node
	 * @param i
	 * @return the left child
	 */
	public int leftChild(int i) {

		return i*2;

	}

	/**
	 * Gets the right child of the node
	 * @param i
	 * @return the right node
	 */
	public int rightChild(int i) {

		return (i*2) + 1;
	}

	/**
	 * Gets the parent index
	 * @param index
	 * @return the index of the parent
	 */
	public int parent(int index) {

		return index/2;
	}

	/**
	 * Gets the capacity of the heap
	 * @return the capacity in an int
	 */
	@Override
	public int capacity() {

		return internalArray.length;
	}

	/**
	 * The size of the heap
	 * @return the size in an int
	 */
	@Override
	public int size() {

		return heapSize;

	}

	/**
	 * Sets the size of the heap
	 */
	@Override
	public void setSize(int size) {

		heapSize = size;

	}

	/**
	 * Swaps two elements from the heap
	 */
	@Override
	public void swap(int one, int two) {

		Comparable temp = internalArray[one-1];
		internalArray[one-1] = internalArray[two-1];
		internalArray[two-1]=temp;		
	}

	/**
	 * Makes the heap a max heap
	 * Goes through the nodes of the tree and
	 * calls maxHeapify on each one
	 */
	@Override
	public void buildMaxHeap() {

		for(int i = (int)Math.floor(internalArray.length/2); i > 0; i--){
			maxHeapify(i);
		}			
	}

	/**
	 * Sorts the heap to a max heap
	 */
	@Override
	public void maxHeapify(int i) {

		int l = leftChild(i);
		int r = rightChild(i);
		int largest = 0;
		//checks if the left child is smaller or equal to the size of the heap
		//and if left child element is greater to its parent
		if(l <= heapSize && getElement(l).compareTo((T)getElement(i)) > 0){
			//if true sets the left child to the largest
			largest = l;						
		}
		//if not the largest is still i/the parent
		else{
			largest =i;
		}
		//same with first if statement but with the right child
		if(r <= heapSize && getElement(r).compareTo((T) getElement(largest)) > 0){

			largest = r;			
		}
		//if int largest doesnt not equal i, swap and 
		//calls recursively
		if(largest!=i){
			swap(i, largest);
			maxHeapify(largest);				
		}			
	}

	/**
	 * Checks if it an empty heap
	 */
	@Override
	public boolean isEmpty() {

		if(heapSize == 0){
			return true;
		}
		else{
			return false;

		}
	}
	
}

