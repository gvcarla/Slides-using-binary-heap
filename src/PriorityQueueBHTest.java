import static org.junit.Assert.*;

//import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * PriorityQueueBHTest class test the methods in the PriorityQueueBH class.
 * 
 * @author Prof. Klemperer gave us the initial Test
 * I, Carla Gonzalez-V., expanded the tests
 * Feb. 22. 2017
 */
public class PriorityQueueBHTest {
	//instance variables for the PQs 
	//and BHs
    protected Integer[] array;
    protected BinaryHeap bh;
    protected PriorityQueue pq;
    protected BinaryHeap emptyBH;
    protected PriorityQueue emptyPQ;

    /**
     * Gets called before any Test
     * Makes two Priority Queues.
     * emptyPQ is for me to test so I can add more elements and test it
     * pq is a full Priority Queue
     * 
     * Prof. Klemperer wrote this.
     */
    @Before
    public void init() {
        emptyBH = new BinaryHeapA(10);
        emptyPQ = new PriorityQueueBH(emptyBH);

        array = new Integer[]{2, 1, 3, 10, 15, 8};
        bh = new BinaryHeapA(array);
        pq = new PriorityQueueBH(bh);
    }

    /**
     * test for the constructors
     */
    @Test
    public void testConstructor() {
        assertNotNull(pq);
        
        assertNotNull(emptyPQ);
    }
    
    /**
     * Test for maximum() method
     */
    @Test
    public void maximumTest(){
    	//test the pq
        assertEquals("test maximum", 15, pq.maximum());
        assertEquals("test maximum", 15, pq.maximum());
        //tests the empty pq
        emptyPQ.insert(10);
        assertEquals("test maximum", 10, emptyPQ.maximum());
        emptyPQ.insert(20);
        emptyPQ.insert(30);
        assertEquals("test maximum", 30, emptyPQ.maximum());
        emptyPQ.insert(40);
        emptyPQ.insert(50);
        emptyPQ.insert(60);
        assertEquals("test maximum", 60, emptyPQ.maximum());
        
    }
    
    /**
     * Test for extract_max() method
     */
    @Test
    public void extractMaxTest(){
    	//tests thne pq
        assertEquals("test maximum", 15, pq.extract_max());
        assertEquals("test maximum", 10, pq.extract_max());
        
        
        //tests the empty pq
        emptyPQ.insert(1);
        emptyPQ.insert(2);
        emptyPQ.insert(3);
        
        emptyPQ.increase_value(2, 4);
        assertEquals("checks increase value", 4, emptyPQ.extract_max());
        
        emptyPQ.increase_value(1, 2);
        assertEquals("checks increase value", 3, emptyPQ.extract_max());
        
        
        emptyPQ.insert(7);
        emptyPQ.increase_value(1, 1);
        assertNotNull(emptyPQ.extract_max());
        
        
        
        
    }
    /**
     * Test for increase_value() method
     */
    @Test
    public void increaseValueTest() {
        pq.increase_value(1, 27);
        assertEquals("test increase value", 27, pq.extract_max());
        
       //tests the empty pq
        emptyPQ.insert(10);
        assertEquals("checks if 10 is inserted", 10, emptyPQ.extract_max());
        
        emptyPQ.insert(1);
        emptyPQ.insert(2);
        emptyPQ.insert(3);
        
        emptyPQ.increase_value(2, 4);
        assertEquals("checks increase value", 4, emptyPQ.extract_max());
        
        emptyPQ.increase_value(1, 2);
        assertEquals("checks increase value", 3, emptyPQ.extract_max());
        
        
        emptyPQ.insert(7);
        emptyPQ.increase_value(1, 1);
        assertNotNull(emptyPQ.extract_max());
    }

    /**
     * Test for insert() method
     */
    @Test
    public void insertTest(){
        emptyPQ.insert(72);
        assertEquals(72, emptyPQ.extract_max());
        //tests the empty pq
        emptyPQ.insert(90);
        emptyPQ.insert(91);
        emptyPQ.insert(89);
        emptyPQ.insert(55);
        assertEquals(91, emptyPQ.extract_max());
        assertEquals(90, emptyPQ.extract_max());
        assertEquals(89, emptyPQ.extract_max());
        
        emptyPQ.insert(60);
        assertEquals(60, emptyPQ.extract_max());
       
        
    }

}
