package test.com.itulabs.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineGeneratorTest {


	@Test
	void testGenerateMinesAvoidsSafeZone() {
		com.itulabs.model.Board board = new com.itulabs.model.Board(3);
		com.itulabs.model.Coordinate safe = new com.itulabs.model.Coordinate(1, 1);
		com.itulabs.service.MineGenerator gen = new com.itulabs.service.MineGenerator();
		gen.generateMines(board, 2, safe);
		// Ninguna mina en la zona segura
		for (int dx = -1; dx <= 1; dx++) {
			for (int dy = -1; dy <= 1; dy++) {
				int nx = safe.getX() + dx;
				int ny = safe.getY() + dy;
				com.itulabs.model.Coordinate c = new com.itulabs.model.Coordinate(nx, ny);
				if (c.isWithinBounds(3)) {
					assertFalse(board.getTile(c).isMine());
				}
			}
		}
	}

}
