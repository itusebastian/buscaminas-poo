package test.com.itulabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NormalTileTest {


	@Test
	void testIsMineAndAdjacentMines() {
		com.itulabs.model.NormalTile tile = new com.itulabs.model.NormalTile();
		assertFalse(tile.isMine());
		tile.setAdjacentMines(3);
		assertEquals(3, tile.getAdjacentMines());
	}

	@Test
	void testGetDisplayValue() {
		com.itulabs.model.NormalTile tile = new com.itulabs.model.NormalTile();
		assertEquals(" ? ", tile.getDisplayValue());
		tile.toggleFlag();
		assertEquals(" F ", tile.getDisplayValue());
		tile.toggleFlag();
		tile.reveal();
		tile.setAdjacentMines(2);
		assertEquals(" 2 ", tile.getDisplayValue());
	}

}
