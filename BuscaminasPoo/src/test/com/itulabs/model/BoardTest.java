package test.com.itulabs.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {


	@Test
	void testBoardInitialization() {
		com.itulabs.model.Board board = new com.itulabs.model.Board(5);
		assertEquals(5, board.getSize());
		assertNotNull(board.getTile(0, 0));
		assertTrue(board.getTile(0, 0) instanceof com.itulabs.model.NormalTile);
	}

	@Test
	void testSetAndGetTile() {
		com.itulabs.model.Board board = new com.itulabs.model.Board(3);
		com.itulabs.model.Coordinate coord = new com.itulabs.model.Coordinate(1, 1);
		com.itulabs.model.MineTile mineTile = new com.itulabs.model.MineTile();
		board.setTile(coord, mineTile);
		assertTrue(board.getTile(coord).isMine());
	}

	@Test
	void testIsValidCoordinate() {
		com.itulabs.model.Board board = new com.itulabs.model.Board(2);
		assertTrue(board.isValid(new com.itulabs.model.Coordinate(1, 1)));
		assertFalse(board.isValid(new com.itulabs.model.Coordinate(2, 2)));
	}

}
