package structures;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ListInterfaceTest {

	private ListInterface<String> list;
	private ListInterface<String> listInsertAt;
	
	@Before
	public void setup(){
          list = new RecursiveList<String>();
          listInsertAt = new RecursiveList<String>();
	}
	
	@Test (timeout = 500)
	public void testInsertFirstIsEmptySizeAndGetFirst1() {
		assertTrue("Newly constructed list should be empty.", list.isEmpty());
		assertEquals("Newly constructed list should be size 0.", 0, list.size());
		assertEquals("Insert First should return instance of self", list, list.insertFirst("hello"));
		assertFalse("List should now have elements.", list.isEmpty());
		assertEquals("List should now have 1 element.", 1, list.size());
		assertEquals("First element should .equals \"hello\".", "hello", list.getFirst());
		list.insertFirst("world");
		assertEquals(2, list.size());
		list.insertFirst("foo");
		assertEquals(3, list.size());
		assertEquals("First element should .equals \"foo\".", "foo", list.getFirst());
	}
	@Test (timeout = 500)
	public void insertLast() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertLast("bologna");
		assertEquals("Last element should .equals \"bologna\".", "bologna", listInsertAt.getLast());	
		listInsertAt.insertAt(1, "pizza");
		listInsertAt.insertLast("burger");
		assertEquals("Last element should .equals \"burger\".", "burger", listInsertAt.getLast());
	}
	
	@Test (timeout = 500)
	public void insertFirst() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bologna");
		assertEquals("First element should .equals \"world\".", "world", listInsertAt.getFirst());
		listInsertAt.insertFirst("pizza");
		listInsertAt.insertAt(2, "cheese");
		listInsertAt.insertAt(3, "bologna");
		assertEquals("First element should .equals \"pizza\".", "pizza", listInsertAt.getFirst());
	}
	
	@Test (timeout = 500)
	public void insertAt() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bologna");
		listInsertAt.insertAt(2, "something");
		listInsertAt.insertAt(3, "good");
		assertEquals("The element should .equals \"bologna\".", "bologna", listInsertAt.get(1));
	}
	
	@Test (timeout = 500)
	public void removeAt() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals("bagel", listInsertAt.removeAt(1));
	}
	
	@Test (timeout = 500)
	public void remove() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals(true, listInsertAt.remove("bagel"));
	}
	@Test (timeout = 500)
	public void indexOf() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals(1, listInsertAt.indexOf("bagel"));
	}
	@Test (timeout = 500)
	public void emptyFalse() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals(false, listInsertAt.isEmpty());
	}
	@Test (timeout = 500)
	public void emptyTrue() {
		assertEquals(true, listInsertAt.isEmpty());
	}
	
	@Test (timeout = 500)
	public void getFirst() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals("world", listInsertAt.getFirst());
	}
	
	@Test (timeout = 500)
	public void getAt() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals("bagel", listInsertAt.get(1));
	}
	
	@Test (timeout = 500)
	public void removeLast() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals("pasta", listInsertAt.removeLast());
	}
	
	@Test (timeout = 500)
	public void removeFirst() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertAt(1, "bagel");
		listInsertAt.insertAt(2, "pasta");
		assertEquals("world", listInsertAt.removeFirst());
	}
	
	
	@Test (timeout = 500)
	public void currentSize() {
		listInsertAt.insertFirst("world");
		assertEquals(1, listInsertAt.size());
		listInsertAt.insertAt(0, "cheese");
		assertEquals(2, listInsertAt.size());
		listInsertAt.insertAt(1, "buffalo");
		assertEquals(3, listInsertAt.size());
		listInsertAt.insertLast("buffalo");
		assertEquals(4, listInsertAt.size());
	}
	
	@Test (timeout = 500)
	public void testCombined() {
		listInsertAt.insertFirst("world");
		listInsertAt.insertAt(0, "cheese");
		listInsertAt.insertLast("bologna");
		assertEquals(3, listInsertAt.size());
		assertEquals("Last element should .equals \"bologna\".", "bologna", listInsertAt.getLast());	
		listInsertAt.insertAt(1, "pizza");
		listInsertAt.insertLast("burger");
		assertEquals(5, listInsertAt.size());
		assertEquals("Last element should .equals \"burger\".", "burger", listInsertAt.getLast());
		assertEquals("world", listInsertAt.removeFirst());
		assertEquals("cheese", listInsertAt.getFirst());
		assertEquals(3, listInsertAt.size());
	}
}
