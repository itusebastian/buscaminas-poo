package test.com.itulabs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TileDetectorTest {


	@Test
	void testDetectAdjacentMines() {
		com.itulabs.model.Board board = new com.itulabs.model.Board(2);
		// Coloca una mina en (0,0)
		board.setTile(new com.itulabs.model.Coordinate(0, 0), new com.itulabs.model.MineTile());
		com.itulabs.service.TileDetector detector = new com.itulabs.service.TileDetector();
		detector.detectAdjacentMines(board);
		// (0,1), (1,0), (1,1) deben tener 1 mina adyacente
		assertEquals(1, ((com.itulabs.model.NormalTile) board.getTile(0, 1)).getAdjacentMines());
		assertEquals(1, ((com.itulabs.model.NormalTile) board.getTile(1, 0)).getAdjacentMines());
		assertEquals(1, ((com.itulabs.model.NormalTile) board.getTile(1, 1)).getAdjacentMines());
	}

}
