
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by peter on 2/7/17.
 *
 * Warning, these tests are just a jumping off point
 * to help you make sure that your methods have the correct
 * headers.
 *
 */
public class BinaryHeapBasicTests {
    // we use a BinaryHeapA variable here
    // because we want to test the internal
    // methods of the BinaryHeapA, not just
    BinaryHeapA<Integer> emptyBHA;
    BinaryHeapA<Integer> filledBHA;

    @Before
    public void init() {
        emptyBHA = new BinaryHeapA(10);
        Integer[] stringArray = {1,10,5,2,6,3,7,9,4,8};
        filledBHA = new BinaryHeapA(stringArray);
        
    }

    /**
     * Tests the getsElement() method
     */
    @Test
    public void getElementTest() {
        Integer expected = 8;
        assertEquals("getElement  test",expected,filledBHA.getElement(5));
    }

    /**
     * Tests the addElement() method
     */
    @Test
    public void addElementTest() {
        emptyBHA.addElement(10);
        assertEquals("addElement test",(Integer)10,emptyBHA.getElement(1));
        
        filledBHA.addElement(10);
        
        assertEquals("addElement test",(Integer)6,filledBHA.getElement(10));
    }

    /**
     * Test the leftChild() method
     */
    @Test
    public void leftChildTest() {
        assertEquals("leftChild test",2,filledBHA.leftChild(1));
    }

    /**
     * Tests the rightChild() method
     */
    @Test
    public void rightChildTest() {
        assertEquals("empty size test",3,filledBHA.rightChild(1));
    }
    
    /**
     * Test the parent() method
     */
    @Test
    public void parentTest() {
        assertEquals("empty size test",2,filledBHA.parent(5));
    }

    /**
     * Test the capacity() method
     */
    @Test
    public void capacityTest() {
        assertEquals("empty size test",10,emptyBHA.capacity());
    }

    /**
     * Tests the size() method
     */
    @Test
    public void sizeTest() {
        assertEquals("empty size test",0,emptyBHA.size());
    }

    /**
     * Tests the setSize() method
     */
    @Test
    public void setSize() {
        filledBHA.setSize(filledBHA.size()-1);
        assertEquals("set size test",9,filledBHA.size());
    }
    
    /**
     * Tests the swap() method
     */
    @Test
    public void swapTest() {
    	Integer expected =9;
        filledBHA.swap(1,2);
        assertEquals("swap test",expected,filledBHA.getElement(1));
    }

    /**
     * Test the builMaxHeap() method
     */
    @Test
    public void buildMaxHeap() {
        Integer expected = 6;
        filledBHA.buildMaxHeap();
        assertEquals("buildMaxHeap test",expected,filledBHA.getElement(10));
    }

    /**
     * Tests maxHeapify() method
     */
    @Test
    public void maxHeapifyTest() {
        Integer expected = 6;
        filledBHA.maxHeapify(10);
        assertEquals("maxHeap test",expected,filledBHA.getElement(10));
    }

    /**
     * Tests isEmpty() method
     */
    @Test
    public void isEmptyTest() {
        assertEquals("isEmpty Test",true,emptyBHA.isEmpty());
        //adds an element to heap
        emptyBHA.addElement(1);
        assertEquals("isEmpty Test",false,emptyBHA.isEmpty());
    }

}
