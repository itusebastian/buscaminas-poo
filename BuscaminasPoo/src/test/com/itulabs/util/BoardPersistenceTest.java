package test.com.itulabs.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardPersistenceTest {


	@Test
	void testSaveAndLoadBoard() throws Exception {
		com.itulabs.model.Board board = new com.itulabs.model.Board(2);
		board.setTile(new com.itulabs.model.Coordinate(0, 0), new com.itulabs.model.MineTile());
		String filename = "test_board.sav";
		com.itulabs.util.BoardPersistence.saveBoard(board, filename);
		com.itulabs.model.Board loaded = com.itulabs.util.BoardPersistence.loadBoard(filename);
		assertTrue(loaded.getTile(0, 0).isMine());
		java.io.File file = new java.io.File(filename);
		if (file.exists()) file.delete();
	}

}
