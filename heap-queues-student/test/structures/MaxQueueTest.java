package structures;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MaxQueueTest {

  MaxQueue<String> queue;
	
  @Before
  public void setup() {
    queue = new MaxQueue<String>();
  }

  @Test (timeout = 100)
  public void testEnqueueandDequeue() {
    queue.enqueue(100, "Highest priority");
    queue.enqueue(50, "High priority");
    queue.enqueue(25, "Medium priority");
    queue.enqueue(0, "Low priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }
 
  @Test (timeout = 100, expected = IllegalStateException.class)
  public void testDequeueEmpty() {
	    assertEquals(IllegalStateException.class, queue.dequeue());

	  }
  
  @Test (timeout = 100, expected = NullPointerException.class)
  public void testEnqueueNull() {
	    assertEquals(NullPointerException.class, queue.enqueue(null, null));

	  }
  
  @Test (timeout = 100)
  public void testPeek() {
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(0, "Low priority");
	    assertEquals("Highest priority", queue.peek());
	  }
  
  @Test (timeout = 100)
  public void testPeekOutOfOrder() {
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(0, "Low priority");
	    assertEquals("Highest priority", queue.peek());
	  }
  
  @Test (timeout = 100)
  public void testSize() {
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(0, "Low priority");
	    assertEquals(4, queue.size());
	    queue.dequeue();
	    assertEquals(3, queue.size());
	  }
  
  @Test (timeout = 100)
  public void testIsNotEmpty() {
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(0, "Low priority");
	    assertEquals(false, queue.isEmpty());
	  }
  
  @Test (timeout = 100)
  public void testIsEmpty() {
	    assertEquals(true, queue.isEmpty());
	  }
  
  @Test (timeout = 100)
  public void testIteratorInOrder() {
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(50, "High priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(0, "Low priority");
	    Iterator<Entry<Integer, String>> iterator = queue.iterator();
	    assertEquals("Highest priority", iterator.next().getValue());
	    assertEquals("High priority", iterator.next().getValue());
	  }
  
  @Test (timeout = 100)
  public void testIteratorOutOfOrder() {
	    queue.enqueue(100, "Highest priority");
	    queue.enqueue(0, "Low priority");
	    queue.enqueue(25, "Medium priority");
	    queue.enqueue(50, "High priority");
	    Iterator<Entry<Integer, String>> iterator = queue.iterator();
	    assertEquals("Highest priority", iterator.next().getValue());
	    assertEquals("High priority", iterator.next().getValue());
	  }
  
  @Test (timeout = 100)
  public void testEnqueueandDequeueOutOfOrder() {
	queue.enqueue(50, "High priority");
	queue.enqueue(25, "Medium priority");
    queue.enqueue(100, "Highest priority");
    queue.enqueue(0, "Low priority");
    assertEquals("Highest priority", queue.dequeue());
    assertEquals("High priority", queue.dequeue());
    assertEquals("Medium priority", queue.dequeue());
    assertEquals("Low priority", queue.dequeue());
  }
  

}
