package comparators;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class IntegerComparatorTest {

  IntegerComparator comparator;
	
  @Before
  public void setup() {
    comparator = new IntegerComparator();
  }

  @Test (timeout = 100)
  public void testOneLess() {
	  assertEquals(-1, comparator.compare(1,2));
  }
  
  @Test (timeout = 100)
  public void testTwoEquals() {
	  assertEquals(0, comparator.compare(1,1));
  }
  
  @Test (timeout = 100)
  public void testThreeGreater() {
	  assertEquals(1, comparator.compare(3,2));
  }

}
