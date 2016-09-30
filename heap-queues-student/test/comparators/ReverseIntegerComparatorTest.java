package comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class ReverseIntegerComparatorTest {

  ReverseIntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new ReverseIntegerComparator();
  }

  @Test (timeout = 100)
  public void testOneGreater() {
	  assertEquals(-1, comparator.compare(2,1));
  }
  
  @Test (timeout = 100)
  public void testTwoEquals() {
	  assertEquals(0, comparator.compare(1,1));
  }
  
  @Test (timeout = 100)
  public void testThreeLess() {
	  assertEquals(1, comparator.compare(2,3));
  }

}
