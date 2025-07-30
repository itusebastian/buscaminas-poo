package test.com.itulabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineTileTest {


	@Test
	void testIsMineAndDisplayValue() {
		com.itulabs.model.MineTile tile = new com.itulabs.model.MineTile();
		assertTrue(tile.isMine());
		assertEquals(" ? ", tile.getDisplayValue());
		tile.toggleFlag();
		assertEquals(" F ", tile.getDisplayValue());
		tile.toggleFlag();
		tile.reveal();
		assertEquals(" * ", tile.getDisplayValue());
	}

}
