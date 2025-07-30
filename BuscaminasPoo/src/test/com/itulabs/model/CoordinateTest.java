package test.com.itulabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CoordinateTest {


	@Test
	void testEqualsAndHashCode() {
		com.itulabs.model.Coordinate c1 = new com.itulabs.model.Coordinate(2, 3);
		com.itulabs.model.Coordinate c2 = new com.itulabs.model.Coordinate(2, 3);
		com.itulabs.model.Coordinate c3 = new com.itulabs.model.Coordinate(3, 2);
		assertEquals(c1, c2);
		assertNotEquals(c1, c3);
		assertEquals(c1.hashCode(), c2.hashCode());
	}

	@Test
	void testIsWithinBounds() {
		com.itulabs.model.Coordinate c = new com.itulabs.model.Coordinate(1, 1);
		assertTrue(c.isWithinBounds(2));
		assertFalse(c.isWithinBounds(1));
	}

}
