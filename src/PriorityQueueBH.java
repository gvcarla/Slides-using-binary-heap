/**
 * This class makes the Priority Queue. 
 * It implements the PriorityQueue interface.
 * @author Carla Gonzalez-Vazquez
 * PSA4 Feb.19.2017
 * @param <T>
 */
public class PriorityQueueBH <T> implements PriorityQueue<T> {
	
	//heap that will be inside the queue
	protected BinaryHeap pqHeap;
	//keeps track of the size
	protected int heapSize;

	/**
	 * This constructor passes the capacity for the queue
	 * @param capacity the capacity/size of the queue
	 */
	public PriorityQueueBH(int capacity){
		//makes new binary heap 
		pqHeap = new BinaryHeapA(capacity);
	}
	
	/**
	 * This constructor passes a binary heap
	 * @param bh the binary heap
	 */
	public PriorityQueueBH(BinaryHeap bh){
		
		pqHeap = bh;		
	}
	
	/**
	 * Inserts a new Comparable value into the heap
	 */
	@Override
	public void insert(Comparable value) {

		pqHeap.addElement(value);
		
	}
	
	/**
	 * Look/peeks at the maximum value in the queue
	 */
	@Override
	public Comparable maximum() {
		
		return pqHeap.getElement(1);
	}
	
	/**
	 * Extracts the maximum value from the queue. 
	 */
	@Override
	public Comparable extract_max() {
		
		//if the size of the heap is less than 1 prints an error message
		if(pqHeap.size() < 1){
			System.out.println("error");
		}		
			//else gets the max element and takes it away from the queue
			Comparable max = pqHeap.getElement(1);
			pqHeap.setElement(1, pqHeap.getElement(pqHeap.size()));			
			pqHeap.setSize(pqHeap.size()-1);
			pqHeap.maxHeapify(1);
			return max;	
		
	}
	
	/**
	 * Increases the value of the selected index
	 */
	@Override
	public void increase_value(int heapIndex, Comparable newValue) {

		if (newValue.compareTo(pqHeap.getElement(heapIndex))<=0) {
			System.out.println("new value smaller than current");
			return;
		}
		pqHeap.setElement(heapIndex, newValue);
		while (heapIndex>1 && (pqHeap.getElement(((BinaryHeapA) pqHeap).parent(heapIndex))).compareTo(pqHeap.getElement(heapIndex))<0) {
			pqHeap.swap(((BinaryHeapA) pqHeap).parent(heapIndex), heapIndex);
			heapIndex = ((BinaryHeapA) pqHeap).parent(heapIndex);

		}	
	}

}
