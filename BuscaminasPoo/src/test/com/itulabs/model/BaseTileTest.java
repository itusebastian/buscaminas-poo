package test.com.itulabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseTileTest {


	@Test
	void testRevealAndFlag() {
		com.itulabs.model.NormalTile tile = new com.itulabs.model.NormalTile();
		assertFalse(tile.isRevealed());
		tile.reveal();
		assertTrue(tile.isRevealed());
		assertFalse(tile.isFlagged());
		tile.toggleFlag();
		assertTrue(tile.isFlagged());
	}

}
